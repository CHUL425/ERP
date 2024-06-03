package com.erp.io.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {
    
    // ctrl + . : quick fix
    
    private int    studentId;
    private String grade    ;
    
    public Student() {
        super();
        this.studentId = 1001;
        this.grade     = "1" ;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", grade=" + grade + ", getAge()=" + getAge() + ", getName()=" + getName() + "]";
    }

}