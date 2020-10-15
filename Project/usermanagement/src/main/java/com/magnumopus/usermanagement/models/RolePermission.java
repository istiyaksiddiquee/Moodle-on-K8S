package com.magnumopus.usermanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_role_permission")
public class RolePermission {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "role_permission_id")
    private int rolePermissionsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id", referencedColumnName = "audit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Audit audit;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "privilege")
    private String privilege;

    // ============================ CONSTRUCTORS ===================================

    public RolePermission(Audit audit, String roleName, String privilege) {

        this.audit = audit;
        this.roleName = roleName;
        this.privilege = privilege;
    }
}
