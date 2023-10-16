package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.QuotationDTO;
import com.csse.order.dto.QuotationResponseDTO;
import com.csse.order.entity.Quotation;
import com.csse.order.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class QuotationController {

    private static final Logger logger = LoggerFactory.getLogger(QuotationController.class);

    @Autowired
    QuotationService quotationService;

    /**
     * Create quotation request
     *
     * @param quotationDTO - required dto to create an inquiry
     * @return success or failed response from inquiry creation and quotation details
     * @author Mufeel M.I.M
     */

    @PostMapping("/quotation")
    public ResponseEntity<CommonResponse> createQuotation(@RequestBody QuotationDTO quotationDTO){
        logger.info("QuotationController -> createQuotation() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        QuotationResponseDTO responseDto =  quotationService.createQuotation(quotationDTO);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("QuotationController -> createQuotation() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create quotation failed");
            commonResponse.setData(responseDto);
            logger.info("QuotationController -> create() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get quotation request
     *
     * @return success or failed response from order and all quotation details
     * @author Mufeel M.I.M
     */

    @GetMapping("/quotations")
    public ResponseEntity<List<Quotation>> getQuotations(){return quotationService.getQuotations();}


}
