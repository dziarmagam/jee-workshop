package my.dao.user;

import java.util.List;

import my.entity.User;

public interface UserDao {
	
	void addUser(User user);
	List<User> loadAll();
	User findById(int id);
	void updateUser(User user);
}
