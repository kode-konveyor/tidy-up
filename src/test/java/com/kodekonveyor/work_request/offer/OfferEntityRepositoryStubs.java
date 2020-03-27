package com.kodekonveyor.work_request.offer;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

public class OfferEntityRepositoryStubs {

  public static void
      behaviour(final OfferEntityRepository offerEntityRepository) {
    final Optional<OfferEntity> optionalOffer =
        Optional.of(OfferEntityTestData.get());
    doReturn(optionalOffer)
        .when(offerEntityRepository)
        .findById(OfferEntityTestData.OFFER_ID);
  }

}
