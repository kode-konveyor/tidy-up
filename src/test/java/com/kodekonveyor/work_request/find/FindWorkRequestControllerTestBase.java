package com.kodekonveyor.work_request.find;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestTestData;

public class FindWorkRequestControllerTestBase {

  @InjectMocks
  FindWorkRequestController findWorkRequestController;
  @Mock
  WorkRequestRepository workRequestRepository;
  AddressTestData addressTestData;
  UserTestData userTestData;
  WorkRequestTestData workRequestTestData;
  CreateWorkRequestTestData createWorkRequestTestData;

  @BeforeEach
  void setUp() {
    addressTestData = new AddressTestData();
    userTestData = new UserTestData();
    workRequestTestData = new WorkRequestTestData(
        userTestData,
        addressTestData
    );

    createWorkRequestTestData =
        new CreateWorkRequestTestData(workRequestTestData, addressTestData);

    WorkRequestEntityRepositoryStubs.behaviour(
        workRequestRepository,
        workRequestTestData, addressTestData
    );
  }
}
