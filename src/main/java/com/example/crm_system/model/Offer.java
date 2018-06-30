package com.example.crm_system.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long offerNumber;
    private String contractorName;
    private Long purchaseOrderNumber;
    private String paymentsTerm;
    private Timestamp validUntil;
    private String description;
    private String billingAccountName;
    private String billingAccountAdress;
    private String shippingAccountName;
    private String shippingAccountAdress;
    private BigDecimal totalDiscount;
    private BigDecimal discountedSubtotal;
    private BigDecimal totalTax;
    private BigDecimal shippingCost;
    private BigDecimal grandTotal;
    private Timestamp dateCreated;
    private Timestamp dateModified;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Contractors contractorsOffer;

}
