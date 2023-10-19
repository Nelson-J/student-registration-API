package com.student.studentRegistration.Services;

import com.student.studentRegistration.Beans.Student;
import com.student.studentRegistration.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class studentService {

    @Autowired
    studentRepository studentRep;
    public studentService() {

    }

    public List<Student> getStudents() {
        return studentRep.findAll();
    }

    public Student getStudentbyID(int id) {
        return studentRep.findById(id).get();
    }

    public Student registerStudent(Student student) {
            student.setId(getNextId());
            studentRep.save(student);
        return student;
    }

    public int getNextId() {
        return studentRep.findAll().size()+1;
    }

    public Student updateStudentinfo(Student student){
            studentRep.save(student);
       return student;
    }

    public Response deleteStudentbyID(int id) {
         studentRep.deleteById(id);
         Response res = new Response();
         res.setMessage("Student has been deleted");
         res.setId(id);
        return res;
    }

    public Response deleteStudents() {
        studentRep.deleteAll();
        Response res = new Response();
        res.setMessage("All students have been deleted");
        res.setId(1);
        return res;
    }
}