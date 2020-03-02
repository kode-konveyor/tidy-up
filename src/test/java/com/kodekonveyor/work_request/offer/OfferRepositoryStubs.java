package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.mockito.Mockito;

public class OfferRepositoryStubs {

  public static void behaviour(final OfferRepository offerRepository) {

    final Optional<OfferEntity> offerEntity =
        Optional.of(OfferEntityTestData.get());
    System.out.println(offerEntity);
    Mockito.doReturn(offerEntity)
        .when(offerRepository).findById(Mockito.anyLong());
  }

}
