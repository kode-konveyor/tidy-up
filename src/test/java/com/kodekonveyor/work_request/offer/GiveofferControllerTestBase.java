package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.AddressTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestTestData;

public class GiveofferControllerTestBase {

  @InjectMocks
  GiveofferController giveofferController;

  @Mock
  WorkRequestRepository workRequestRepository;

  UserTestData userTestData;
  WorkRequestTestData workRequestTestData;
  AddressTestData addressTestData;

  GiveofferControllerTestData giveofferControllerTestData;

  @BeforeEach
  void setUp() {

    userTestData = new UserTestData();

    addressTestData = new AddressTestData();
    workRequestTestData =
        new WorkRequestTestData(userTestData, addressTestData);
    giveofferControllerTestData =
        new GiveofferControllerTestData();

    WorkRequestRepositoryStubs
        .behaviour(workRequestRepository, workRequestTestData);
  }
}
