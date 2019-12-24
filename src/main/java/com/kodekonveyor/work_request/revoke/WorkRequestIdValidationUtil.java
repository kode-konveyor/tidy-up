package com.kodekonveyor.work_request.revoke;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;

public class WorkRequestIdValidationUtil {

  public static void inputValidation(final long workRequestId) {

    final int workId = 0;
    if (workRequestId <= workId)
      throw new ValidationException(
          WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
      );
  }
}
