package com.kodekonveyor.work_request.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;

@RestController
public class CustomerGetWorkRequestsController {

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @GetMapping("/work-request/byOwner/")
  public Object call(final String ownerId) {
    final UserEntity userEntity = authenticatedUserService.call();

    if (!userEntity.getId().toString().equals(ownerId))
      throw new ValidationException(null);
    return null;
  }
}
