package com.kodekonveyor.work_request.create;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestTestData;

public class CreateWorkRequestControllerTestBase {

  @InjectMocks
  CreateWorkRequestController createWorkRequestController;
  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  AuthenticatedUserService authenticatedUserService;
  WorkRequestTestData workRequestTestData;

  @BeforeEach
  void setUp() {
    final UserTestData userTestData = new UserTestData();
    final AddressTestData addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);
    AuthenticatedUserStubs.behaviour(authenticatedUserService, userTestData);
    createWorkRequestController.call(workRequestTestData.CREATE_WORK_REQUEST);
    verify(workRequestRepository).save(workRequestTestData.WORK_REQUEST_ENTITY);
  }

}
