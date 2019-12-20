package com.kodekonveyor.work_request.offer;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class OfferValidationUtil {

  public static void inputValidation(final OfferDTO offerDTO) {
    validatePrice(offerDTO);
  }

  public static void validatePrice(final OfferDTO offerDTO) {
    if (0L == offerDTO.getPrice())
      throw new ValidationException(WorkRequestConstants.INVALID_PRICE);

    if (0L > offerDTO.getPrice())
      throw new ValidationException(
          WorkRequestConstants.NEGATIVE_PRICE_EXCEPTION
      );

  }

}
