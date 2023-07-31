package Jpa01.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

import java.util.Set;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "classname")
    @Max(value = 10, message = "Ten lop qua dai")
    private String classname;

    @Column(name = "numberofmember")
    @Max(value = 20, message = "Lop da du thanh vien")
    private int numberOfMember;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classStudent")
    private Set<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
