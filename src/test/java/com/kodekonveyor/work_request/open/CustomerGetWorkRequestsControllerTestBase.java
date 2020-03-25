package com.kodekonveyor.work_request.open;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;

public class CustomerGetWorkRequestsControllerTestBase {

  @InjectMocks
  CustomerGetWorkRequestsController customerGetWorkRequestsController;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  @BeforeEach
  void setUp() {
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
