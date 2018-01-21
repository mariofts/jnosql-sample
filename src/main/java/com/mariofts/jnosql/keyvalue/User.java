package com.mariofts.jnosql.keyvalue;

import java.util.List;

import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class User {

    @Id
    private String userName;
    private String name;

    private List<String> phones;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
