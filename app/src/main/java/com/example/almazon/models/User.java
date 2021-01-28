package com.example.almazon.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que contiene los atributos del usuario: id, username, email, name, surname, status,
 * privilege, password, lastAccess, lastPasswordChange, company.
 */
@Root (name="user")
public class User implements Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * Id usuario auto-generado.
     */
    @SerializedName("id")
    @Expose
    private Long id;
    /**
     * Username del usuario.
     */
    @SerializedName("username")
    @Expose
    private String username;
    /**
     * Email del usuario.
     */
    @SerializedName("email")
    @Expose
    private String email;
    /**
     * Nombre del usuario.
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * Apellido del usuario.
     */
    @SerializedName("surname")
    @Expose
    private String surname;

    /**
     * Estado del usuario.
     */
    @SerializedName("status")
    @Expose
    private UserStatus status;
    /**
     * Privilegio del usuario.
     */
    @SerializedName("privilege")
    @Expose
    private UserPrivilege privilege;
    /**
     * Contraseña del usuario.
     */
    @SerializedName("password")
    @Expose
    private String password;
    /**
     * Fecha ultimo acceso del usuario.
     */
    @SerializedName("lastAccess")
    @Expose
    private Date lastAccess;
    /**
     * Fecha del ultimo cambio de contraseña del usuario.
     */
    @SerializedName("lastPasswordChange")
    @Expose
    private Date lastPasswordChange;

    /**
     * Objeto compañia a la que pertenece el usuario.
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
