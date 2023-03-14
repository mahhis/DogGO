package by.fpmibsu.doggo.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private int id;

    private String firstName;
    private String secondName;

    private String telephoneNumber;
    private String email;
    private String password;

    private List<Role> roles;

    private List<Pet> pets;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
