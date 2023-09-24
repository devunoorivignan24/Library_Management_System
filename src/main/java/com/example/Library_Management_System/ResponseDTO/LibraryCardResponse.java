package com.example.Library_Management_System.ResponseDTO;

import com.example.Library_Management_System.Enum.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LibraryCardResponse {
    String cardNo;

    CardStatus cardStatus;

    Date issueDate;
}
