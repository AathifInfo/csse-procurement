package com.csse.order.serviceimpl;

import com.csse.order.dto.InquiryDTO;
import com.csse.order.dto.InquiryResponseDTO;
import com.csse.order.entity.Inquiry;
import com.csse.order.repository.InquiryRepository;
import com.csse.order.service.InquiryService;
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
public class InquiryServiceIMPL implements InquiryService {

    private static final Logger logger = LoggerFactory.getLogger(InquiryServiceIMPL.class );

    @Autowired
    InquiryRepository inquiryRepository;


    /**
     * Create inquiry request
     *
     * @param inquiryDTO - required dto to create an inquiry
     * @return success or failed response from inquiry creation and inquiry details
     * @author Mufeel M.I.M
     */

    @Override
    public InquiryResponseDTO createInquiry(InquiryDTO inquiryDTO) {
        try{
            logger.error("InquiryServiceIMPL -> createInquiry() => started!");
            Inquiry inquiry= new Inquiry(
                    inquiryDTO.getCompanyName(),
                    inquiryDTO.getPersonName(),
                    inquiryDTO.getContactNumber(),
                    inquiryDTO.getSubject(),
                    inquiryDTO.getMessage()
            );

            inquiryRepository.save(inquiry);
            logger.error("InquiryServiceIMPL -> createInquiry() => success!");
            return new InquiryResponseDTO(Integer.parseInt("200"), inquiry, "Inquiry Creation successfully", new Date());
        }catch (Exception e){
            logger.error("OrderServiceIMPL -> createInquiry() => error: {}", e.getMessage());
            return new InquiryResponseDTO(Integer.parseInt("500"), null, "Inquiry Creation failed", new Date());
        }
    }

    /**
     * Get inquiry request
     *
     * @return success or failed response from inquiry and all inquiry details
     * @author Mufeel M.I.M
     */

    @Override
    public ResponseEntity<List<Inquiry>> getInquires() {
        try{
            logger.error("InquiryServiceIMPL -> getInquires() => started!");
            List<Inquiry> inquiryList = new ArrayList<>(inquiryRepository.findAll());

            if (inquiryList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("InquiryServiceIMPL -> getInquires() => success!");
            return new ResponseEntity<>(inquiryList, HttpStatus.OK);

        } catch (Exception e){
            logger.error("InquiryServiceIMPL -> getInquires() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
