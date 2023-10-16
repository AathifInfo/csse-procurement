package com.csse.order.dto;

import lombok.Data;

@Data
public class QuotationDTO {

    private long quotationId;

    private String quotationRefId;

    private String quotationName;

    private String quotationType;

    private String quotationStatus;

}
