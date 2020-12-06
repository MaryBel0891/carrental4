package com.task.three.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table( name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = false)
    @NotNull
    @Pattern(regexp = "[A-ZA-ЯҐІЇЄ]{1}[a-zа-яґіїє']{1,15}+")
    private String name;
    @Basic
    @Column(name = "surname", nullable = false)
    @NotNull
    @Pattern(regexp = "[A-ZA-ЯҐІЇЄ]{1}[a-zа-яґіїє']{1,15}+")
    private String surname;
    @Basic
    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    @Basic
    @Column(name = "password", nullable = false)
    @NotNull
    private String password;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public static class Builder{
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder id(int id){
            user.id = id;
            return this;
        }
        public Builder name(String name){
            user.name = name;
            return this;
        }
        public Builder surname(String surname){
            user.surname = surname;
            return this;
        }
        public Builder email(String email){
            user.email = email;
            return this;
        }
        public Builder password(String password){
            user.password = password;
            return this;
        }
        public Builder role(RoleType role){
            user.role = role;
            return this;
        }
        public User build(){
            return user;
        }

    }
}
