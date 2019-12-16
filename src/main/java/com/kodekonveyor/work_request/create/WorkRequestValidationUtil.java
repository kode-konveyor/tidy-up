package com.kodekonveyor.work_request.create;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class WorkRequestValidationUtil {

  public static void
      validateWorkRequest(final CreateWorkRequestDTO createWorkRequestDTO) {
    validateWorkType(createWorkRequestDTO);
    validateDescrption(createWorkRequestDTO);
    validateCustomerId(createWorkRequestDTO);
    validateAddressDetails(createWorkRequestDTO);
    validateCityAndCountry(createWorkRequestDTO);
  }

  public static void
      validateWorkType(final CreateWorkRequestDTO createWorkRequestDTO) {
    if (null == createWorkRequestDTO.getCustomerId())
      throw new ValidationException(WorkRequestConstants.NULL_CUSTOMERID);

    if (null == createWorkRequestDTO.getWorkType())
      throw new ValidationException(WorkRequestConstants.NULL_WORKTYPE);

    if (!createWorkRequestDTO.getWorkType().matches("^[a-zA-Z]*$"))
      throw new ValidationException(
          WorkRequestConstants.DIGIT_SPECIAL_CHARACTER_WORKTYPE
      );

  }

  public static void
      validateDescrption(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getDescription())
      throw new ValidationException(WorkRequestConstants.NULL_DESCRIPTION);

  }

  public static void
      validateAddressDetails(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getAddress())
      throw new ValidationException(WorkRequestConstants.NULL_ADDRESS_STRING);

    final int charLimit = 120;

    if (createWorkRequestDTO.getAddress().getAddress().length() > charLimit)
      throw new ValidationException(WorkRequestConstants.ADDRESS_LENGTH);

    final int charLimit1 = 0;
    if (createWorkRequestDTO.getAddress().getAddress().length() == charLimit1)
      throw new ValidationException(WorkRequestConstants.ZERO_ADDRESS_LENGTH);

  }

  public static void
      validateCityAndCountry(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getCity())
      throw new ValidationException(WorkRequestConstants.NULL_CITY);

    if (null == createWorkRequestDTO.getAddress().getCountry())
      throw new ValidationException(WorkRequestConstants.NULL_COUNTRY);

    final int length = 2;
    if (createWorkRequestDTO.getAddress().getCountry().length() != length)
      throw new ValidationException(WorkRequestConstants.COUNTRY_LENGTH);

    if (!createWorkRequestDTO.getAddress().getCountry().matches("^[a-z]*$"))
      throw new ValidationException(WorkRequestConstants.COUNTRY_ALPHABET);

  }

  public static void
      validateCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (createWorkRequestDTO.getCustomerId() < 0)
      throw new ValidationException(WorkRequestConstants.NEGATIVE_CUSTOMERID);

    if (createWorkRequestDTO.getCustomerId() == 0)
      throw new ValidationException(WorkRequestConstants.ZERO_CUSTOMERID);

  }

}
