package com.softuni.mobilele.model.entity;

import com.softuni.mobilele.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "roles")
@Entity
public class UserRole extends BaseEntity{

    @Column
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
