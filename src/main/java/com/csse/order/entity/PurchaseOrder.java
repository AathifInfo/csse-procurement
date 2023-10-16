package com.csse.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_order_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @Column(name = "item_id")
    private long purchaseOrderId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "qty")
    private String totalQty;

    @Column(name = "price")
    private float price;

    public PurchaseOrder(String supplierName, String companyName, String contactNo, String totalQty, float price) {
        this.supplierName = supplierName;
        this.companyName = companyName;
        this.contactNo = contactNo;
        this.totalQty = totalQty;
        this.price = price;
    }
}
