package com.csse.order.service;

import com.csse.order.dto.QuotationDTO;
import com.csse.order.dto.QuotationResponseDTO;
import com.csse.order.entity.Quotation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuotationService {
    QuotationResponseDTO createQuotation(QuotationDTO quotationDTO);

    ResponseEntity<List<Quotation>> getQuotations();
}
