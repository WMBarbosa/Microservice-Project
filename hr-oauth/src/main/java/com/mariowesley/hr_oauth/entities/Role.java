package com.mariowesley.hr_oauth.entities;

import java.io.Serializable;
import java.util.Objects;


public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.roleName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(getRoleName(), role.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRoleName());
    }
}
