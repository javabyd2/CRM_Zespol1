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
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String department;
    private String contractorName;
    private String mobile;
    private String mail;
    private String typeOfContact;
    private String primaryAddress;
    private String alternateAddress;
    private String officePhone;
    private String fax;
    private String description;
    private String assignedTo;
    private Timestamp dataModified;
    private Timestamp dataCreated;
}
