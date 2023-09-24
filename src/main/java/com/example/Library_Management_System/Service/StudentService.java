package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.Enum.CardStatus;
import com.example.Library_Management_System.Enum.Gender;
import com.example.Library_Management_System.Models.LibraryCard;
import com.example.Library_Management_System.Models.Student;
import com.example.Library_Management_System.Repository.StudentRepository;
import com.example.Library_Management_System.RequestDTO.StudentRequest;
import com.example.Library_Management_System.ResponseDTO.LibraryCardResponse;
import com.example.Library_Management_System.ResponseDTO.StudentResponse;
import com.example.Library_Management_System.Transformer.StudentTransformer;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentResponse addStudent(StudentRequest studentRequest) {

        Student student= StudentTransformer.StudentRequestToStudent(studentRequest);
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setEmail(studentRequest.getEmail());
//        student.setGender(studentRequest.getGender());

        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        Student saved=studentRepository.save(student);

//        StudentResponse studentResponse=new StudentResponse();
//        studentResponse.setName(saved.getName());
//        studentResponse.setEmail(saved.getEmail());
//        studentResponse.setMessage("you have been registered");

//       LibraryCardResponse cardResponse=LibraryCardResponse.builder()
//               .cardNo(saved.getLibraryCard().getCardNo())
//               .cardStatus(saved.getLibraryCard().getCardStatus())
//               .issueDate(saved.getLibraryCard().getIssueDate())
//               .build();
//        cardResponse.setCardNo(saved.getLibraryCard().getCardNo());
//        cardResponse.setCardStatus(saved.getLibraryCard().getCardStatus());
//        cardResponse.setIssueDate(saved.getLibraryCard().getIssueDate());
        StudentResponse studentResponse=StudentTransformer.StudentToStudentResponse(saved);
        return studentResponse;
    }

    public Student getStudent(int regNo) {
        Optional<Student> response=studentRepository.findById(regNo);
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }

    public List<String> getAllMales() {
        List<String> names=new ArrayList<>();
        List<Student> students=studentRepository.findByGender(Gender.MALE);
        for(Student s:students){
            names.add(s.getName());
        }
        return names;
    }


}
