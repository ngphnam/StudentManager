package Jpa01.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "classid")
    private int classId;

    @Column(name = "fullname")
    @Size(min = 2, max = 20, message = "Loi do dai")
    private String fullName;

    @Column(name = "yob")
    @Min(value = 2002, message = "Nam sinh phai lon hon 2001")
    @Max(value = 2014, message = "Nam sinh phai nho hon 2015")
    private String yob;

    @Column(name = "address")
    @Size(min = 2, max = 20, message = "Loi do dai")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classid", referencedColumnName = "id" , insertable = false, updatable = false)
    @JsonIgnore
    private Class classStudent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Class getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(Class classStudent) {
        this.classStudent = classStudent;
    }
}
