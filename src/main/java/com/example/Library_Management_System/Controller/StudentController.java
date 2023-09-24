package com.example.Library_Management_System.Controller;

import com.example.Library_Management_System.Models.Student;
import com.example.Library_Management_System.RequestDTO.StudentRequest;
import com.example.Library_Management_System.ResponseDTO.StudentResponse;
import com.example.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response= studentService.addStudent(studentRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("q") int regNo){
        Student res= studentService.getStudent(regNo);
        if(res!=null){
            return new ResponseEntity(res,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getMales")
    public List<String> getAllmales(){
        List<String> males=studentService.getAllMales();
        return males;
    }

}
