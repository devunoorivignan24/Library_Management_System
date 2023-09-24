package com.example.Library_Management_System.RequestDTO;

import com.example.Library_Management_System.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    String name;
    int age;
    String email;
    Gender gender;
}
