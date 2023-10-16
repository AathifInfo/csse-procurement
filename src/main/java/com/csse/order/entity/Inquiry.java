package com.csse.order.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "inquiry_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inquiry_id")
    private long inquiryId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "person_Name")
    private String personName;

    @Column(name = "contact_Number")
    private String contactNumber;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    public Inquiry(String companyName, String personName, String contactNumber, String subject, String message) {
        this.companyName = companyName;
        this.personName = personName;
        this.contactNumber = contactNumber;
        this.subject = subject;
        this.message = message;
    }
}
