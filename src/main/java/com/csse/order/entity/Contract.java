package com.csse.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contract_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private long contractId;

    @Column(name = "contract_RefId")
    private String contractRefId;

    @Column(name = "contract_Name")
    private String contractName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "contract_Status")
    private String contractStatus;

    public Contract(String contractRefId, String contractName, String startDate, String endDate, String contractStatus) {
        this.contractRefId = contractRefId;
        this.contractName = contractName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractStatus = contractStatus;
    }
}
