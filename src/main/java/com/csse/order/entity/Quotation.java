package com.csse.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="quotation_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quotation_id")
    private long quotationId;

    @Column(name = "quotation_RefId")
    private String quotationRefId;

    @Column(name = "quotation_Name")
    private String quotationName;

    @Column(name = "quotation_Type")
    private String quotationType;

    @Column(name = "quotation_Status")
    private String quotationStatus;

    public Quotation(String quotationRefId, String quotationName, String quotationType, String quotationStatus) {
        this.quotationRefId = quotationRefId;
        this.quotationName = quotationName;
        this.quotationType = quotationType;
        this.quotationStatus = quotationStatus;
    }
}

