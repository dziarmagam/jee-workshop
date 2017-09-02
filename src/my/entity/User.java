package my.entity;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String passsword;
    private UserGroup userGroup;

    public User(Integer id, String username, String email, UserGroup userGroup) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userGroup = userGroup;
    }
    
    public User(Integer id, String username, String password, String email, UserGroup userGroup) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userGroup = userGroup;
        this.passsword = password;
    }

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", userGroup=" + userGroup + "]";
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
    
    
}
