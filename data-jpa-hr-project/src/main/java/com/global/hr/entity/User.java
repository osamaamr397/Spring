package com.global.hr.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sec_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;
    //@Version
    //private Long version;
    @ManyToMany
    @JoinTable(name = "sec_user_roles"
            ,joinColumns =@JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles=new HashSet<>();
    public void addRole (Role role) {
        roles.add(role);
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
}
