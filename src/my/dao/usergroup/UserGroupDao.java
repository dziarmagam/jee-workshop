package my.dao.usergroup;

import java.util.List;

import my.entity.UserGroup;

public interface UserGroupDao {

	public UserGroup findById(int id);

    public List<UserGroup> loadAll();
}
