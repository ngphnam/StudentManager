package Jpa01.Services;

import Jpa01.Models.Student;

public interface IStudentServices {
    public Student addNewStudent(Student student);
    public Student remakeStudent(Student studentRemake);
    public Student removeStudent(int id);
}
