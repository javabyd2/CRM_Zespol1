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
import java.math.BigDecimal;
import java.util.Date;

@Data
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
    private Date validUntil;
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

}
