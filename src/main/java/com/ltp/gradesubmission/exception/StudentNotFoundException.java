package com.ltp.gradesubmission.exception;

public class StudentNotFoundException extends RuntimeException { 

    public StudentNotFoundException(Long id) {
        super("The student with id '" + id + "' does not exist in our records");
    }
    
}