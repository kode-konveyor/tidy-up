package com.kodekonveyor.work_request.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class GiveofferController {

  @Autowired
  private WorkRequestRepository workRequestRepository;

  @PostMapping("/offer")

  public OfferDTO call(final OfferEntity offerEntity) {
    final OfferDTO offerDTO = new OfferDTO();
    offerDTO.setId(offerEntity.getId());
    offerDTO.setPrice(offerEntity.getPrice());
    offerDTO.setWorkRequestId(offerEntity.getWorkRequest().getId());
    return offerDTO;
  }

}
