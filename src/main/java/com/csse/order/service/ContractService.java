package com.csse.order.service;

import com.csse.order.dto.ContractDTO;
import com.csse.order.dto.ContractResponseDTO;
import com.csse.order.dto.QuotationResponseDTO;
import com.csse.order.entity.Contract;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractService {
    ContractResponseDTO createContract(ContractDTO contractDTO);

    ResponseEntity<List<Contract>> getContracts();
}
