package Jpa01.Controller;

import Jpa01.Models.Student;
import Jpa01.Services.StudentServiecs;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "jpa01/v1")
public class StudentController {
    @Autowired
    private StudentServiecs studentServiecs;

    @RequestMapping(value = "addnewstudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addNewStudent(@RequestBody String student){
        try {
            Gson gson = new Gson();
            Student st = gson.fromJson(student, Student.class);
            return studentServiecs.addNewStudent(st);
        } catch (Exception e) {
            System.out.println(e);
            return new Student();
        }
    }
    @RequestMapping(value = "remakestudent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student remakeStudent(@RequestBody String studentRemake){
        try {
            Gson gson = new Gson();
            Student st = gson.fromJson(studentRemake, Student.class);
            return studentServiecs.remakeStudent(st);
        } catch (Exception e) {
            System.out.println(e);
            return new Student();
        }
    }
    @RequestMapping(value = "removestudent", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addNewStudent(@RequestParam int id){
        return studentServiecs.removeStudent(id);
    }
}
