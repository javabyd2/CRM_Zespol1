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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;


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
    @Column(name = "contacts_id")
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


    @ManyToOne(cascade = CascadeType.MERGE)
    private Contractors contractors;

    @OneToMany(mappedBy = "contactsCalls", cascade = CascadeType.ALL)
    private Set<Contacts> contactsCalls;

    @OneToMany(mappedBy = "contactsEmail", cascade = CascadeType.ALL)
    private Set<Contacts> contactsEmail;

    @OneToMany(mappedBy = "contactsMeetings", cascade = CascadeType.ALL)
    private Set<Contacts> contactsMeetings;
}
