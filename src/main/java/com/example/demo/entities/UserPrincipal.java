package com.example.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserPrincipal {
    @Id
    private Long id;
    //@Column(name = "username")
    private String username;
    private String password;

    @ManyToMany(mappedBy = "userPrincipal")
    private Set<Role> roles = new HashSet<>();

    public UserPrincipal() {
    }

    public UserPrincipal(Long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal userPrincipal = (UserPrincipal) o;
        return id.equals(userPrincipal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
