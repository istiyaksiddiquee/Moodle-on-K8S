package com.magnumopus.usermanagement.models;

import com.magnumopus.usermanagement.utilities.ActionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_audit")
public class Audit {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "audit_id")
    private int auditId;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "affected_table")
    private String affectedTable;

    @Column(name = "performed_operation")
    private String performedOperation;

    @Column(name = "audit_msg")
    private String auditMsg;

    // ============================ CONSTRUCTORS ===================================

    public Audit(Integer userId, String affectedTable, String performedOperation, String auditMsg) {

        this.userId = userId;
        this.affectedTable = affectedTable;
        this.performedOperation = performedOperation;
        this.auditMsg = auditMsg;
        this.createdOn = LocalDateTime.now();
    }
}
