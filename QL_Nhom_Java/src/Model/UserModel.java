/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author BN
 */
public class UserModel {
    private int id;
    private String userName;
    private String password;
    private String name;

    public UserModel() {
    }

    public UserModel(int id, String userName, String password, String name) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public UserModel(UserModel user) {
        this.id = user.id;
        this.userName = user.userName;
        this.password = user.password;
        this.name = user.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String Username) {
        this.userName = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
    
}
