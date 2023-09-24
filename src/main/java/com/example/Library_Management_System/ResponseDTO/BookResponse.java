package com.example.Library_Management_System.ResponseDTO;

import com.example.Library_Management_System.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {

    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;

}
