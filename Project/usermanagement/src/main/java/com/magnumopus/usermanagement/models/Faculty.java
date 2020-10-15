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
@Table(name = "t_faculty")
public class Faculty {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "faculty_id")
    private int facultyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="audit_id", referencedColumnName = "audit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Audit audit;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    // ============================ CONSTRUCTORS ===================================

    public Faculty(Audit audit, String name, String address) {

        this.audit = audit;
        this.name = name;
        this.address = address;
    }
}
