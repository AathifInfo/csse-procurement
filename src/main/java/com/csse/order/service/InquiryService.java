package com.csse.order.service;

import com.csse.order.dto.InquiryDTO;
import com.csse.order.dto.InquiryResponseDTO;
import com.csse.order.entity.Inquiry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InquiryService {
    InquiryResponseDTO createInquiry(InquiryDTO inquiryDTO);

    ResponseEntity<List<Inquiry>> getInquires();
}
