package Jpa01.Services;

import Jpa01.Models.Student;
import Jpa01.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentServiecs implements IStudentServices {
    @Autowired
    private StudentRepository studentRepository ;
    @Override
    public Student addNewStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student removeStudent(int id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            System.out.println(student.toString());
            if(student.isEmpty()){
                return null;
            }
            studentRepository.delete(student.get());
            return student.get();
        } catch (Exception e){
            System.out.println("aaaa");
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Student remakeStudent(Student studentRemake) {
        Optional<Student> student = studentRepository.findById(studentRemake.getId());
        if(student.isEmpty()){
            return null;
        }
        Student st = student.get();
        st.setClassId(studentRemake.getClassId());
        st.setFullName(studentRemake.getFullName());
        st.setYob(studentRemake.getYob());
        st.setAddress(studentRemake.getAddress());
        studentRepository.save(st);
        return st;

    }
}
