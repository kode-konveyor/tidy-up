package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.work_request.open.OpenWorkRequestControllerTestData;

public class GiveofferControllerTestData
    extends OpenWorkRequestControllerTestData {

  public String INVALID_PRICE = "Invalid Price";
  public String NEGATIVE_PRICE_EXCEPTION = "Price cannot be negative";

  public final OfferDTO OFFER_DTO_INVALID_PRICE;
  public final OfferDTO OFFER_DTO_NEGATIVE_PRICE;

  public final OfferDTO OFFER_DTO_INVALID_WORK_REQUEST_ID;
  public final OfferDTO OFFER_DTO_ZERO_WORK_REQUEST_ID;
  public final OfferDTO OFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID;

  public GiveofferControllerTestData() {
    OFFER_DTO_INVALID_PRICE =
        createOFFER_DTO_INVALID_PRICE();
    OFFER_DTO_NEGATIVE_PRICE = createOFFER_DTO_NEGATIVE_PRICEE();
    OFFER_DTO_INVALID_WORK_REQUEST_ID =
        createOFFER_DTO_INVALID_WORK_REQUEST_ID();
    OFFER_DTO_ZERO_WORK_REQUEST_ID = createOFFER_DTO_ZERO_WORK_REQUEST_ID();
    OFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID =
        createOFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID();
  }

  public OfferDTO createOFFER_DTO_NEGATIVE_PRICEE() {
    final OfferDTO dto = createOfferDTO();
    dto.setPrice(-89);
    return dto;
  }

  public OfferDTO createOFFER_DTO_INVALID_PRICE() {
    final OfferDTO dto = createOfferDTO();
    dto.setPrice(0);
    return dto;
  }

  public OfferDTO createOFFER_DTO_INVALID_WORK_REQUEST_ID() {
    final OfferDTO dto = createOfferDTO();
    dto.setWorkRequestId(12345);
    return dto;
  }

  public OfferDTO createOFFER_DTO_ZERO_WORK_REQUEST_ID() {
    final OfferDTO dto = createOfferDTO();
    dto.setWorkRequestId(0);
    return dto;
  }

  public OfferDTO createOFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID() {
    final OfferDTO dto = createOfferDTO();
    dto.setWorkRequestId(-1234);
    return dto;
  }

  private OfferDTO createOfferDTO() {
    final OfferDTO dto = new OfferDTO();
    dto.setId(1);
    dto.setPrice(234);
    dto.setWorkRequestId(1234);
    return dto;
  }
}
