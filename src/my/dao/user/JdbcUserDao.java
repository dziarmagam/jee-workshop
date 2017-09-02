package my.dao.user;

import my.DbUtil;
import my.dao.usergroup.UserGroupDao;
import my.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class JdbcUserDao implements UserDao {
	
	private final UserGroupDao userGroupDao;
	
	public JdbcUserDao(UserGroupDao userGroupDao) {
		this.userGroupDao = userGroupDao;
	}
	
	private static final String SELECT_QUERY = "SELECT * FROM users";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
	private static final String INSERT_QUERY = "INSERT INTO users(username,email,password,person_group_id) VALUES(?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE users SET username = ?, email = ?, password = ?, person_group_id = ? WHERE id = ?";
	
	@Override
	public void addUser(User user) {
		DbUtil.executeUpdate(INSERT_QUERY, ps -> setUser(user, ps));
	}

	@Override
	public List<User> loadAll() {
		return DbUtil.executeQeury(SELECT_QUERY, null, this::map);
	}

	@Override
	public User findById(int id) {
		return DbUtil.executeQeury(FIND_BY_ID_QUERY, ps -> ps.setInt(1, id), this::map)
				.stream()
				.findAny()
				.orElseThrow(() -> new RuntimeException("No element found"));
	}

	@Override
	public void updateUser(User user) {
		DbUtil.executeUpdate(UPDATE_QUERY, ps -> setUserUpdate(user, ps));
	}
	
	private void setUser(User user, PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2,user.getEmail());
			preparedStatement.setString(3,user.getPasssword());
			preparedStatement.setInt(4,user.getUserGroup().getId());
	}
	private void setUserUpdate(User user, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1,user.getUsername());
		preparedStatement.setString(2,user.getEmail());
		preparedStatement.setString(3,user.getPasssword());
		preparedStatement.setInt(4,user.getUserGroup().getId());
		preparedStatement.setInt(5,user.getId());
}
	
	private User map(ResultSet resultSet) throws SQLException {
			int id = resultSet.getInt("id");
			String username = resultSet.getString("username");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			int groupId = resultSet.getInt("person_group_id");
			return new User(id, username, password, email, userGroupDao.findById(groupId));
	}
}
