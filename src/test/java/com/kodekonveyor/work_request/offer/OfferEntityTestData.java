package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferEntityTestData {

  public static final Long OFFER_ID = 42422L;
  public static final Long OFFER_PRICE = 2345L;

  public static OfferEntity get() {
    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setWorkRequest(WorkRequestEntityTestData.get());

    offerEntity.setPrice(OFFER_PRICE);
    offerEntity.setId(OFFER_ID);
    return offerEntity;
  }

}
