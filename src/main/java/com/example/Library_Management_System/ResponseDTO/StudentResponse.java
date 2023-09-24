package com.example.Library_Management_System.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    String name;
    String email;

    String cardIssuedNo;
    LibraryCardResponse libraryCardResponse;
}
