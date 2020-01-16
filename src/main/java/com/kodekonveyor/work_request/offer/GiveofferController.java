package com.kodekonveyor.work_request.offer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GiveofferController {

  @PostMapping("/offer")

  public OfferDTO call(final OfferEntity offerEntity) {
    final OfferDTO offerDTO = new OfferDTO();
    offerDTO.setId(offerEntity.getId());
    offerDTO.setPrice(offerEntity.getPrice());
    offerDTO.setWorkRequestId(offerEntity.getWorkRequest().getId());
    return offerDTO;
  }

}
