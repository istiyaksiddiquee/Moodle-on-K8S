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
@Table(name = "t_course")
public class Course {

    // ============================ VARIABLES ===================================

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial")
    @SequenceGenerator(name = "serial", sequenceName = "serial", allocationSize = 1)
    @Column(name = "course_id")
    private int courseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id", referencedColumnName = "audit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Audit audit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;

    @Column(name = "title")
    private String title;

    @Column(name = "credit_points")
    private Float creditPoints;

    @Column(name = "address")
    private String address;

    // ============================ CONSTRUCTORS ===================================

    public Course(Audit audit, String title, Float creditPoints, String address, Department department) {

        this.audit = audit;
        this.department = department;
        this.title = title;
        this.creditPoints = creditPoints;
        this.address = address;
    }
}
