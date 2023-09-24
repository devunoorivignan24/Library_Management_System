package com.example.Library_Management_System.Transformer;

import com.example.Library_Management_System.Models.Student;
import com.example.Library_Management_System.RequestDTO.StudentRequest;
import com.example.Library_Management_System.ResponseDTO.LibraryCardResponse;
import com.example.Library_Management_System.ResponseDTO.StudentResponse;

public class StudentTransformer {
    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return  Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }
    public static StudentResponse StudentToStudentResponse(Student student){

       LibraryCardResponse cardResponse=LibraryCardResponse.builder()
               .cardNo(student.getLibraryCard().getCardNo())
               .cardStatus(student.getLibraryCard().getCardStatus())
              .issueDate(student.getLibraryCard().getIssueDate())
               .build();

        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardResponse(cardResponse)
                .build();
    }
}
