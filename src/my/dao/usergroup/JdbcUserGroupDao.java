package my.dao.usergroup;

import my.DbUtil;
import my.entity.UserGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcUserGroupDao implements UserGroupDao {
	
	private static final String SELECT_QUERY = "SELECT * FROM user_group";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM user_group WHERE id = ?";
	private static final String FIND_ALL_USERS_ID_QUERY = "SELECT id FROM users WHERE person_group_id = ?";
	

    public UserGroup findById(int id){
         UserGroup userGroup = DbUtil.executeQeury(FIND_BY_ID_QUERY, ps -> ps.setInt(1, id), this::mapper).stream()
 				.findAny()
 				.orElseThrow(() -> new RuntimeException("No element found"));
         userGroup.setUsersIds(getUserIds(id));
         return userGroup;
    }

    public List<UserGroup> loadAll(){
    	List<UserGroup> userGroups = DbUtil.executeQeury(SELECT_QUERY, null, this::mapper);
    	userGroups.stream()
    	.forEach(userGroup -> userGroup.setUsersIds(getUserIds(userGroup.getId())));
    	
        return userGroups;
    }
    
    public UserGroup mapper(ResultSet resultSet) throws SQLException {
    	return new UserGroup(resultSet.getInt("id"), resultSet.getString("name"), null);
    }
    
    private List<Integer> getUserIds(int groupId) {
    	return DbUtil.executeQeury(FIND_ALL_USERS_ID_QUERY, ps -> ps.setInt(1, groupId), rs -> rs.getInt(1));
    }

}
