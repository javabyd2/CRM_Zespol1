package com.example.crm_system.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

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
    private String name;
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String industry;
    @Field
    private String type;
    @Field
    private String website;
    @Field
    private Long phone;
    @Field
    private Long alternatePhone;
    @Field
    private String address;
    @Field
    private String email;
    @Field
    private String fax;
    @Field
    private String assignedTo;
    @Field
    private Timestamp dateCreated;
    @Field
    private Timestamp dateModified;

}
