package com.ltp.gradesubmission.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Past(message = "The birth date must be in the past")
    @NonNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;



    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)   // One student can have many grades. one to many
    private List<Grade> grades;

    @JsonIgnore
    @ManyToMany()  //  In Many-to-Many relationship, the joining columns live inside the join table. so it doesn't matter who owns the association. both are managing the relationship
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

}
