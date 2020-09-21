package packages.models;

import java.util.Objects;

public class User {
    private int userId;
    private String name;
    private String surName;

    public User() {
    }

    public User(int userId, String name, String surName) {
        this.userId = userId;
        this.name = name;
        this.surName = surName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                name.equals(user.name) &&
                surName.equals(user.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surName);
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }
}
