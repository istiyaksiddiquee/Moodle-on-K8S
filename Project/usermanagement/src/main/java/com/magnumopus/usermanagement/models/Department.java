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
@Table(name = "t_department")
public class Department {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "department_id")
    private int departmentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="audit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Audit audit;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="faculty_id", referencedColumnName = "faculty_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faculty faculty;


    // ============================ CONSTRUCTORS ===================================

    public Department(String name, String address, Faculty faculty) {

        this.name = name;
        this.address = address;
        this.faculty = faculty;
    }
}
