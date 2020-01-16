package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferDTOTestData {

  public static OfferDTO get() {
    final OfferDTO offerDTO = new OfferDTO();
    offerDTO.setId(OfferEntityTestData.OFFER_ID);
    offerDTO.setPrice(OfferEntityTestData.OFFER_PRICE);
    offerDTO.setWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    return offerDTO;
  }
}
