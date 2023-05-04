package com.ltp.gradesubmission.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {

//     @Query(value = "SELECT * FROM grade WHERE student_id =:studentId AND course_id =:courseId");

     Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);  // custom query

     List<Grade> findByStudentId(Long studentId);

     List<Grade> findByCourseId(Long courseId);

     @Transactional  // deletion requires database access, so it needs to be part of a transaction
     void deleteByStudentIdAndCourseId(Long studentId, Long courseId);

}
