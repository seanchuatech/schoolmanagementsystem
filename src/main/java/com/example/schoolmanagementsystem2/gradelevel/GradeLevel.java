package com.example.schoolmanagementsystem2.gradelevel;

import javax.persistence.*;

@Entity
public class GradeLevel {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long Id;
    @Column(unique=true)
    private Integer gradeLevel;
    private String description;

    public GradeLevel() {
    }

    public GradeLevel(Integer gradeLevel, String description) {
        this.gradeLevel = gradeLevel;
        this.description = description;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GradeLevel{" +
                "Id=" + Id +
                ", gradeLevel=" + gradeLevel +
                ", description='" + description + '\'' +
                '}';
    }

    public void setId(Long id) {
    }
}
