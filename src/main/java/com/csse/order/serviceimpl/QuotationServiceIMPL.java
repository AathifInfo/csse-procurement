package com.csse.order.serviceimpl;

import com.csse.order.dto.QuotationDTO;
import com.csse.order.dto.QuotationResponseDTO;
import com.csse.order.entity.Quotation;
import com.csse.order.repository.QuotationRepository;
import com.csse.order.service.QuotationService;
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
public class QuotationServiceIMPL implements QuotationService {

    private static final Logger logger = LoggerFactory.getLogger(QuotationServiceIMPL.class );

    @Autowired
    QuotationRepository quotationRepository;

    /**
     * Create quotation request
     *
     * @param quotationDTO - required dto to create an inquiry
     * @return success or failed response from quotation creation and quotation details
     * @author Mufeel M.I.M
     */

    @Override
    public QuotationResponseDTO createQuotation(QuotationDTO quotationDTO) {
        try{
            logger.error("QuotationServiceIMPL -> createQuotation() => started!");
            Quotation quotation = new Quotation(
                    quotationDTO.getQuotationRefId(),
                    quotationDTO.getQuotationName(),
                    quotationDTO.getQuotationType(),
                    quotationDTO.getQuotationStatus()
            );
            quotationRepository.save(quotation);
            logger.error("QuotationServiceIMPL -> createQuotation() => success!");
            return new QuotationResponseDTO(Integer.parseInt("200"), quotation,"Quotation Creation successfully", new Date());
        }catch (Exception e){
            logger.error("QuotationServiceIMPL -> createQuotation() => error: {}", e.getMessage());
            return new QuotationResponseDTO(Integer.parseInt("500"), null, "Quotation Creation failed", new Date());
        }
    }

    /**
     * Get quotation request
     *
     * @return success or failed response from quotation and all quotation details
     * @author Mufeel M.I.M
     */

    @Override
    public ResponseEntity<List<Quotation>> getQuotations() {
        try{
            logger.error("QuotationServiceIMPL -> getQuotation() => started!");
            List<Quotation> quotationList = new ArrayList<>(quotationRepository.findAll());

            if(quotationList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("QuotationServiceIMPL -> getQuotation() => success!");
            return new ResponseEntity<>(quotationList, HttpStatus.OK);

        }catch(Exception e){
            logger.error("QuotationServiceIMPL -> getQuotation() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }





}
