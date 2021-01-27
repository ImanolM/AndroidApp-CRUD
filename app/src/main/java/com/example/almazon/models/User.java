package com.example.almazon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;

@Root (name="user")
public class User implements Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * The auto generated id of the user.
     */
    @SerializedName("id")
    @Expose
    private Long id;
    /**
     * The username of the user.
     */
    @SerializedName("username")
    @Expose
    private String username;
    /**
     * The email of the user.
     */
    @SerializedName("email")
    @Expose
    private String email;
    /**
     * The name of the user.
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * The Surname of the user
     */
    @SerializedName("surname")
    @Expose
    private String surname;

    /**
     * The status of the user. Enum.
     */
    @SerializedName("status")
    @Expose
    private UserStatus status;
    /**
     * The privilege of the user.
     */
    @SerializedName("privilege")
    @Expose
    private UserPrivilege privilege;
    /**
     * The password of the user.
     */
    @SerializedName("password")
    @Expose
    private String password;
    /**
     * The last access of the user.
     */
    @SerializedName("lastAccess")
    @Expose
    private Date lastAccess;
    /**
     * The last passsword change that has been made for this user.
     */
    @SerializedName("lastPasswordChange")
    @Expose
    private Date lastPasswordChange;

    /**
     * The company object where this user belongs.
     */
    @SerializedName("company")
    @Expose
    private Company company;


    public User() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
