package com.kodekonveyor.work_request.offer;

public class GiveofferControllerTestData {

  public static final String INVALID_PRICE = "Invalid Price";
  public static final String NEGATIVE_PRICE_EXCEPTION =
      "Price cannot be negative";
  public static final String NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be positive";

  public static final String INVALID_WORK_REQUEST_ID_EXCEPTION =
      "Invalid work request Id";

  /*  public final OfferDTO OFFER_DTO_INVALID_PRICE;
  public final OfferDTO OFFER_DTO_NEGATIVE_PRICE;
  
  public final OfferDTO OFFER_DTO_INVALID_WORK_REQUEST_ID;
  public final OfferDTO OFFER_DTO_ZERO_WORK_REQUEST_ID;
  public final OfferDTO OFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID;
  
  public GiveofferControllerTestData() {
    OFFER_DTO_INVALID_PRICE =
        getPriceInvalid();
    OFFER_DTO_NEGATIVE_PRICE = getPriceNegative();
    OFFER_DTO_INVALID_WORK_REQUEST_ID =
        getInvalidWorkRequestId();
    OFFER_DTO_ZERO_WORK_REQUEST_ID = getWorkRequestIdZero();
    OFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID =
        getWorkRequestIdNonPositive();
  }*/

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
    dto.setWorkRequestId(12345);
    return dto;
  }

  public static OfferDTO getWorkRequestIdNonPositive() {
    final OfferDTO dto = get();
    dto.setWorkRequestId(-1234);
    return dto;
  }

  private static OfferDTO get() {
    final OfferDTO dto = new OfferDTO();
    dto.setId(1);
    dto.setPrice(234);
    dto.setWorkRequestId(1234);
    return dto;
  }
}
