package com.csse.order.dto;

import lombok.Data;

@Data
public class ContractDTO {

    private long contractId;

    private String contractRefId;

    private String contractName;

    private String startDate;

    private String endDate;

    private String contractStatus;

}
