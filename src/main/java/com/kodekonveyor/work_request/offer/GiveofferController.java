package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class GiveofferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @PostMapping("/offer")

  public OfferEntity call(final OfferDTO offerDTO) {

    final OfferEntity offerEntity = new OfferEntity();
    final Optional<WorkRequestEntity> workRequest =
        workRequestRepository.findById(offerDTO.getWorkRequestId());

    offerEntity.setId(offerDTO.getId());
    offerEntity.setPrice(offerDTO.getPrice());
    if (workRequest.isPresent())
      offerEntity.setWorkRequest(workRequest.get());
    else
      offerEntity.setWorkRequest(null);
    return offerEntity;
  }

}
