package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.ContractDTO;
import com.csse.order.dto.ContractResponseDTO;
import com.csse.order.dto.QuotationResponseDTO;
import com.csse.order.entity.Contract;
import com.csse.order.service.ContractService;
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
public class ContractController {

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    ContractService contractService;

    /**
     * Create contract request
     *
     * @param contractDTO - required dto to create a contract
     * @return success or failed response from contract creation and contract details
     * @author Mufeel M.I.M
     */

    @PostMapping("/contract")
    public ResponseEntity<CommonResponse> createContract(@RequestBody ContractDTO contractDTO){
        logger.info("ContractController -> createContract() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        ContractResponseDTO responseDto =  contractService.createContract(contractDTO);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("ContractController -> createContract() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create contract failed");
            commonResponse.setData(responseDto);
            logger.info("ContractController -> createContract() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    /**
     * Get contract request
     *
     * @return success or failed response from contract and all contract details
     * @author Mufeel M.I.M
     */

    @GetMapping("/contracts")
    public ResponseEntity<List<Contract>> getContracts(){return contractService.getContracts();}

}
