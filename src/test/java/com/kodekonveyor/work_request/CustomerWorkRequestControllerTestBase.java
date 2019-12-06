package com.kodekonveyor.work_request;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.authentication.UserEntityRepositoryStubs;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestController;
import com.kodekonveyor.work_request.create.CreateWorkRequestTestData;

public class CustomerWorkRequestControllerTestBase { // NOPMD

  @InjectMocks
  CustomerGetWorkRequestsController customerGetWorkRequestsController;
  @InjectMocks
  CreateWorkRequestController createWorkRequestController;

  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  UserEntityRepository userEntityRepository;
  @Mock
  AddressEntity addressEntity;

  UserTestData userTestData;
  WorkRequestTestData workRequestTestData;
  AddressTestData addressTestData;
  GetWorkRequestTestData getWorkRequestTestData;
  CreateWorkRequestTestData createWorkRequestTestData;

  @BeforeEach
  void setUp() {
    userTestData = new UserTestData();

    addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);
    getWorkRequestTestData = new GetWorkRequestTestData();
    createWorkRequestTestData =
        new CreateWorkRequestTestData(workRequestTestData, addressTestData);

    WorkRequestRepositoryStub
        .behaviour(workRequestRepository, workRequestTestData);
    UserEntityRepositoryStubs.behaviour(userEntityRepository, userTestData);
  }

}
