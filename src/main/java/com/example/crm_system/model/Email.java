package com.example.crm_system.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.sql.Timestamp;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private Long id;

    private String subject;
    private String odKogo; // TODO: To ja - Adrian
    private String doKogo; // TODO: To ja - Adrian
    private String cC;
    private String assignedTo;
    private String text;
    private Timestamp sendDate;
    private String attachment;

}
