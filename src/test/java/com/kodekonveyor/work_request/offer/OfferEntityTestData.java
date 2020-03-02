package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferEntityTestData {

  public static final long OFFER_ID = 4242424;

  public static OfferEntity get() {
    final OfferEntity offerEntity = new OfferEntity();
    offerEntity.setId(OFFER_ID);
    offerEntity.setWorkRequest(WorkRequestEntityTestData.get());
    return offerEntity;
  }

  public static OfferEntity getProviderFilledIn() {
    final OfferEntity offerEntity = get();
    offerEntity.setProvider(UserEntityTestData.PROVIDER_ID);
    return offerEntity;
  }
}
