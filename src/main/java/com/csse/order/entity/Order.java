package com.csse.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "date")
    private String date;

    @Column(name = "address")
    private String address;

    @Column(name = "supplier_details")
    private String supplierDetails;

    @Column(name = "company_details")
    private String companyDetails;

    @Column(name = "qty")
    private String qty;

    public Order(String date, String address, String supplierDetails, String companyDetails, String qty) {
        this.date = date;
        this.address = address;
        this.supplierDetails = supplierDetails;
        this.companyDetails = companyDetails;
        this.qty = qty;
    }
}
