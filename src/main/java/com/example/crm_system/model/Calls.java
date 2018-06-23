package com.example.crm_system.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Calls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calls_id")
    private Long id;

    private Timestamp startDate;
    private Timestamp endDate;
    private String repeatType;
    private String direction;
    private String popupReminder;
    private String emailReminder;
    private String description;
    private String assignedTo;
    private Timestamp dateCreated;
    private Timestamp dateModified;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Contacts contactsCalls;
}
