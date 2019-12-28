package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class OfferDTOTestData {

  public static OfferDTO getPriceNegative() {
    final OfferDTO dto = get();
    dto.setPrice(-89);
    return dto;
  }

  public static OfferDTO getPriceInvalid() {
    final OfferDTO dto = get();
    dto.setPrice(0);
    return dto;
  }

  public static OfferDTO getInvalidWorkRequestId() {
    final OfferDTO dto = get();
    dto.setWorkRequestId(WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID);
    return dto;
  }

  public static OfferDTO getWorkRequestIdNonPositive() {
    final OfferDTO dto = get();
    dto.setWorkRequestId(
        WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID
    );
    return dto;
  }

  public static OfferDTO get() {
    final OfferDTO dto = new OfferDTO();
    dto.setId(1);
    dto.setPrice(234);
    dto.setWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    return dto;
  }
}
