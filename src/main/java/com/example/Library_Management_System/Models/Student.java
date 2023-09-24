package com.example.Library_Management_System.Models;

import com.example.Library_Management_System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info")
@Builder
public class Student {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;
    @Column(name = "student_name")
    String name;
    int age;
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard libraryCard;
}
