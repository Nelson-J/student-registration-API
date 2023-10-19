package com.student.studentRegistration.Controllers;

import com.student.studentRegistration.Beans.Student;
import com.student.studentRegistration.Services.Response;
import com.student.studentRegistration.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    studentService studentService;
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudents/{id}")
    public ResponseEntity<Student> getStudentbyID(@PathVariable(value = "id") int id){
        try{
            Student student = studentService.getStudentbyID(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registerStudent")
    public Student registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int id, @RequestBody Student student){

        try {
            Student ExitsStudent = studentService.getStudentbyID(id);

            ExitsStudent.setStudentClass(student.getStudentClass());
            ExitsStudent.setStudentAge(student.getStudentAge());
            ExitsStudent.setStudentSex(student.getStudentSex());
            ExitsStudent.setStudentName(student.getStudentName());

            Student updatedStudent = studentService.updateStudentinfo(ExitsStudent);
            return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteStudents/{id}")
    public Response deleteStudentbyID(@PathVariable (value = "id") int id){
        return studentService.deleteStudentbyID(id);
    }

    @DeleteMapping("/deleteStudents")
    public Response deleteStudents(){
        return studentService.deleteStudents();
    }
}
