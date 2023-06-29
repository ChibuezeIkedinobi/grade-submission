package com.ltp.gradesubmission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ltp.gradesubmission.validation.Score;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade", uniqueConstraints={
    @UniqueConstraint(columnNames = {"student_id", "course_id"})
}) 
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Score
    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne(optional = false)     // Many grades can belong to one student. The foreign key lives here so grade owns the relationship
    @JoinColumn(name = "student_id", referencedColumnName = "id")    // student_id column joins both tables
    private Student student;



    @ManyToOne(optional = false)     // Many grades belong to one course
    @JoinColumn(name = "course_id", referencedColumnName = "id")     // course_id joins both tables
    private Course course;
    
}
