package my.dao.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import my.entity.User;
import my.entity.UserGroup;

public class MemoryUserDao implements UserDao {

	private final List<User> users;
	
	public MemoryUserDao() {
		users = new ArrayList<>();
		UserGroup userGroup = new UserGroup(1, "Klasa 1", Arrays.asList(0, 1));
        UserGroup userGroup2 = new UserGroup(2, "Klasa 2", Arrays.asList(2));
        User kamil = new User(0, "Kowalski Kamil", "kamil@gmail.com", userGroup);
        User ania = new User(1, "Wawrzyniak Ania", "ania@gmail.com", userGroup);
        User wojtek = new User(2, "Polak Wojtek", "wojtek@gmail.com", userGroup2);
        
		users.add(kamil);
		users.add(ania);
		users.add(wojtek);
	}
	
	@Override
	public void addUser(User user) {
		users.add(user);
		
	}

	@Override
	public List<User> loadAll() {
		return users;
	}

	@Override
	public User findById(int id) {
		return users.stream()
				.filter(user -> user.getId().equals(id))
				.findAny()
				.orElseThrow(() -> new RuntimeException("No user found"));
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
