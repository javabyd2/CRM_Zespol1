package com.example.crm_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meetings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp startDate;
    private Timestamp endDate;
    private String repeatType;
    private String location;
    private String assignedTo;
    private String popupReminder;
    private String emailReminder;
    private String description;
    private Timestamp dateCreated;
    private Timestamp dateModified;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Contacts contactsMeetings;
}
