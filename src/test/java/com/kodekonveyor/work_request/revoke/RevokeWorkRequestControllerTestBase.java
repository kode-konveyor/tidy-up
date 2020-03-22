package com.kodekonveyor.work_request.revoke;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class RevokeWorkRequestControllerTestBase {

  @InjectMocks
  RevokeWorkRequestController revokeWorkRequestController;

  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  @Mock
  AddressEntity addressEntity;
  @Mock
  AuthenticatedUserService authenticatedUserService;
  @Mock
  static Logger loggerService;

  @Captor
  ArgumentCaptor<Long> captorLong;
  @Captor
  ArgumentCaptor<String> captorString;

  int numberOfCallForInfoInLoggerService = 2;
  int numberOfCallForFineInLoggerService = 2;

  @BeforeEach
  void setUp() {
    WorkRequestEntityRepositoryStubs
        .behaviour(workRequestRepository);
    UserEntityRepositoryStubs.behaviour(userEntityRepository);

    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
