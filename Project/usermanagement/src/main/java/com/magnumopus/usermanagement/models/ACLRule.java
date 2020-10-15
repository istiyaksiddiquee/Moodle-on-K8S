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
@Table(name = "t_acl_rule")
public class ACLRule {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "acl_rule_id")
    private int aclRuleId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id", referencedColumnName = "audit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Audit audit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_permission_id", referencedColumnName = "role_permission_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RolePermission rolePermission;

    @Column(name = "included")
    private String included;

    @Column(name = "excluded")
    private String excluded;

    // ============================ CONSTRUCTORS ===================================

    public ACLRule(Audit audit, User user, RolePermission rolePermission, String included, String excluded) {

        this.audit = audit;
        this.user = user;
        this.rolePermission = rolePermission;
        this.included = included;
        this.excluded = excluded;
    }
}
