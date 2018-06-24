package com.example.crm_system.model;


import lombok.*;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Set;

/**
 * The annotation Indexed marks Contractors as an entity which needs to be indexed by
 * Hibernate Search.
 */
@Indexed
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contractors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    @NotEmpty(message = "Please provide valid name")
    private String name;
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @NotEmpty(message = "Please provide valid industry")
    private String industry;
    @Field
    private String type;
    @Field
    @URL(message = "Please provide valid website")
    private String website;
    @Field
    @Min(6)
    private Long phone;
    @Field
    private Long alternatePhone;
    @Field
    private String address;
    @Field
    @Email(message = "Please provide valid email")
    private String email;
    @Field
    private String fax;
    @Field
    private String assignedTo;
    @Field
    private Timestamp dateCreated;
    @Field
    private Timestamp dateModified;

    @OneToMany(mappedBy = "contractorsContacts", cascade = CascadeType.ALL)
    private Set<Contacts> contractorsContacts;

    @OneToMany(mappedBy = "contractorsOffer", cascade = CascadeType.ALL)
    private Set<Contractors> contractorsOffer;

}
