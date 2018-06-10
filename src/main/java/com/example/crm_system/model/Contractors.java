package com.example.crm_system.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contractors {

    private String name;
    private String industry;
    private String type;
    private String website;
    private Long phone;
    private Long alternatePhone;
    private String address;
    private String email;
    private String fax;
    private String assignedTo;
    private Date dateCreated;
    private Date dateModified;

}
