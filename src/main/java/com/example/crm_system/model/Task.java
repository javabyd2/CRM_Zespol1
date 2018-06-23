package com.example.crm_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;
    private Timestamp startDate;
    private Timestamp dueDate;
    private String priority;
    private String status;
    private String type;
    private String popupReminder;
    private String emailReminder;
    private String assignedTo;
    private String description;
    private Timestamp dateCreated;
    private Timestamp dateModified;
}
