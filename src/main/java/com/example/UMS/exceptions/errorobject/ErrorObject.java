package com.example.UMS.exceptions.errorobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "errors")
public class ErrorObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer statusCode;
    private String message;

    @CreationTimestamp
    private Instant createdOn;
}
