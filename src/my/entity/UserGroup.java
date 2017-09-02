package my.entity;

import java.util.List;

public class UserGroup {
	private int id;
    private String name;
    private List<Integer> usersIds;

    public UserGroup(int id, String name, List<Integer> usersIds) {
        this.name = name;
        this.usersIds = usersIds;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<Integer> usersIds) {
        this.usersIds = usersIds;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
