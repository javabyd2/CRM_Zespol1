package com.example.crm_system.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

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
    private Contractors contractorsContacts;

    @OneToMany(mappedBy = "contactsCalls", cascade = CascadeType.ALL)
    private Set<Contacts> contactsCalls;

    @OneToMany(mappedBy = "contactsEmail", cascade = CascadeType.ALL)
    private Set<Contacts> contactsEmail;

    @OneToMany(mappedBy = "contactsMeetings", cascade = CascadeType.ALL)
    private Set<Contacts> contactsMeetings;

    @OneToMany(mappedBy = "contactsNote", cascade = CascadeType.ALL)
    private Set<Contacts> contactsNote;

    @OneToMany(mappedBy = "contactsSms", cascade = CascadeType.ALL)
    private Set<Contacts> contactsSms;

    @OneToMany(mappedBy = "contactsTask", cascade = CascadeType.ALL)
    private Set<Contacts> contactsTask;
}
