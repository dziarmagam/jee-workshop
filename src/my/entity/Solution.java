package my.entity;

import java.util.Date;

public class Solution {
    private Integer id;
    private String name;
    private Date created;
    private Date updated;
    private Exercise exercise;
    private User user;

    public Solution(){

    }

    public Solution(Integer id, String name, Date created,
                    Date updated, Exercise exercise, User user) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
        this.exercise = exercise;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
