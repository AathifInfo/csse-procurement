package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.InquiryDTO;
import com.csse.order.dto.InquiryResponseDTO;
import com.csse.order.entity.Inquiry;
import com.csse.order.service.InquiryService;
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
public class InquiryController {

    private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);

    @Autowired
    InquiryService inquiryService;

    /**
     * Create inquiry request
     *
     * @param inquiryDTO - required dto to create an inquiry
     * @return success or failed response from inquiry creation and inquiry details
     * @author Mufeel M.I.M
     */

    @PostMapping("/inquiry")
    public ResponseEntity<CommonResponse> createInquiry(@RequestBody InquiryDTO  inquiryDTO){
        logger.info("InquiryController -> createInquiry() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        InquiryResponseDTO responseDto =  inquiryService.createInquiry(inquiryDTO);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("InquiryController -> createInquiry() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create inquiry failed");
            commonResponse.setData(responseDto);
            logger.info("InquiryController -> create() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Get inquiry request
     *
     * @return success or failed response from order and all inquiry details
     * @author Mufeel M.I.M
     */

    @GetMapping("/inquiries")
    public ResponseEntity<List<Inquiry>> getInquiries(){ return inquiryService.getInquires();}

}
