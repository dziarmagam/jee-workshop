package my;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import my.dao.user.JdbcUserDao;
import my.dao.user.UserDao;
import my.dao.usergroup.JdbcUserGroupDao;
import my.dao.usergroup.UserGroupDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
    private static DataSource dataSource;
    private static final UserGroupDao USER_GROUP_DAO = new JdbcUserGroupDao();
    private static final UserDao USER_DAO = new JdbcUserDao(USER_GROUP_DAO);

    public static Connection getConn() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/test");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }
    
    public static <T> List<T> executeQeury(String query, ThrowableConsumer<PreparedStatement> statConsumer, ThrowableFunction<ResultSet, T> mapper) {
    	List<T> list = new ArrayList<T>();
    	try(Connection con = getConn();
    			PreparedStatement preparedStatement = con.prepareStatement(query)){
    			if(statConsumer != null) {
    				statConsumer.accept(preparedStatement);    				
    			}
    			try(ResultSet resultSet = preparedStatement.executeQuery()){
    				while (resultSet.next()) {
						list.add(mapper.apply(resultSet));
					}
    			}
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    	return list;
    }
    
    public static int executeUpdate(String query, ThrowableConsumer<PreparedStatement> statConsumer) {
    	try(Connection con = getConn();
    			PreparedStatement preparedStatement = con.prepareStatement(query)){
    			statConsumer.accept(preparedStatement);
    			return preparedStatement.executeUpdate();
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
    
    public static UserDao getUserDao() {
    	return USER_DAO;
    }
    
    public static UserGroupDao getUserGroupDao() {
    	return USER_GROUP_DAO;
    }
    
}
