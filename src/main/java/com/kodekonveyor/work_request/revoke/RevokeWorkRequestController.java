package com.kodekonveyor.work_request.revoke;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class RevokeWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;
  @Autowired
  Logger loggerService; //NOPMD
  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @GetMapping("/workRequest/@workRequestId")
  public void call(@RequestParam final long workRequestId) {
    loggerService.info(
        WorkRequestConstants.SERVICE_CALL_NAME,
        this.getClass().getName()
    );
    loggerService.info(
        WorkRequestConstants.INPUT_VALIDATION,
        this.getClass().getName(), workRequestId

    );
    inputValidation(workRequestId);
    loggerService.debug(
        WorkRequestConstants.INPUT_VALIDATION,
        this.getClass().getName(), workRequestId,
        WorkRequestConstants.SUCCESS
    );
    loggerService.info(
        WorkRequestConstants.FIND_WORK_REQUEST_ENTITY,
        this.getClass().getName(), workRequestId
    );
    final WorkRequestEntity workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId).get(0);
    loggerService.debug(
        WorkRequestConstants.FIND_WORK_REQUEST_ENTITY,
        this.getClass().getName(), workRequestId,
        WorkRequestConstants.SUCCESS
    );
    final UserEntity user = authenticatedUserService.call();
    final UserEntity customer = workRequestEntity.getCustomer();

    if (customer.getId() == user.getId())
      workRequestRepository.delete(workRequestEntity);
    else
      throw new ValidationException(
          WorkRequestConstants.UNAUTHORIZE_REVOKE_WORK_REQUEST
      );

  }

  private void inputValidation(final long workRequestId) {

    final int workId = 0;
    if (workRequestId <= workId)
      throw new ValidationException(
          WorkRequestConstants.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
      );

    final List<WorkRequestEntity> workRequestEntity =
        workRequestRepository.findByWorkRequestId(workRequestId);
    if (workRequestEntity.isEmpty())
      throw new ValidationException(
          WorkRequestConstants.INVALID_WORK_REQUEST_ID_EXCEPTION
      );

  }

}
