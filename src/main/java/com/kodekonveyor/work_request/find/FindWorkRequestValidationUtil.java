package com.kodekonveyor.work_request.find;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class FindWorkRequestValidationUtil {

  public static void inputValidation(
      final String workType
  ) {
    if (null == workType)
      throw new ValidationException(
          WorkRequestConstants.NULL_WORKTYPE
      );
  }
}
