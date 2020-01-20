package com.kodekonveyor.work_request.offer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class GiveofferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @PostMapping("/offer")
  public void call(@RequestBody final OfferDTO offerDTO) {
    OfferValidationUtil.inputValidation(offerDTO);
    validateWorkRequestId(offerDTO);
  }

  private void validateWorkRequestId(final OfferDTO offerDTO) {

    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setPrice(offerDTO.getPrice());
    final int workId = 0;
    final long workRequestId = offerDTO.getWorkRequestId();

    if (workRequestId == workId)
      throw new ValidationException(
          WorkRequestConstants.ZERO_WORK_REQUEST_ID_EXCEPTION
      );

    if (workRequestId < workId)
      throw new ValidationException(
          WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
      );

    final List<WorkRequestEntity> workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId);
    if (workRequestEntity.isEmpty())
      throw new ValidationException(
          WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION
      );

  }

}
