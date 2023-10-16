package com.csse.order.serviceimpl;

import com.csse.order.dto.ContractDTO;
import com.csse.order.dto.ContractResponseDTO;
import com.csse.order.entity.Contract;
import com.csse.order.repository.ContractRepository;
import com.csse.order.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContractServiceIMPL  implements ContractService {

    private static final Logger logger = LoggerFactory.getLogger(ContractServiceIMPL.class );

    @Autowired
    ContractRepository contractRepository;


    /**
     * Create contract request
     *
     * @param contractDTO - required dto to create an contract
     * @return success or failed response from contract creation and contract details
     * @author Mufeel M.I.M
     */

    @Override
    public ContractResponseDTO createContract(ContractDTO contractDTO) {
        try{
            logger.error("ContractServiceIMPL -> createContract() => started!");
            Contract contract = new Contract(
                    contractDTO.getContractRefId(),
                    contractDTO.getContractName(),
                    contractDTO.getStartDate(),
                    contractDTO.getEndDate(),
                    contractDTO.getContractStatus()
            );
            contractRepository.save(contract);
            logger.error("ContractServiceIMPL -> createContract() => success!");
            return new ContractResponseDTO(Integer.parseInt("200"), contract,"Contract Creation successfully", new Date());
        }catch (Exception e){
            logger.error("ContractServiceIMPL -> createContract() => error: {}", e.getMessage());
            return new ContractResponseDTO(Integer.parseInt("500"), null, "Contract Creation failed", new Date());
        }
    }



    /**
     * Get contract request
     *
     * @return success or failed response from contract and all contract details
     * @author Mufeel M.I.M
     */
    @Override
    public ResponseEntity<List<Contract>> getContracts() {
        try{
            logger.error("ContractServiceIMPL -> getContracts() => started!");
            List<Contract> contractList = new ArrayList<>(contractRepository.findAll());

            if(contractList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("ContractServiceIMPL -> getContracts() => success!");
            return new ResponseEntity<>(contractList, HttpStatus.OK);

        }catch(Exception e){
            logger.error("ContractServiceIMPL -> getContracts() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }








}
