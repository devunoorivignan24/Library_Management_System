package com.example.Library_Management_System.ResponseDTO;

import com.example.Library_Management_System.Enum.TransactionStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class IssueBookResponse {
    String transactionNumber;

    Date transactionTime;

    TransactionStatus transactionStatus;

    BookResponse bookResponse;
    StudentResponse studentResponse;
    String bookName;
    String authorName;
    String studentName;
    String libraryCardNumber;
}
