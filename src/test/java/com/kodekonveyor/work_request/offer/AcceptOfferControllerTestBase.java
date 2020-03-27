package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  AcceptOfferController acceptOfferController;
  @Mock
  OfferEntityRepository offerEntityRepository;
  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  Logger loggerService; //NOPMD
  @Captor
  ArgumentCaptor<Long> captorLong;
  @Captor
  ArgumentCaptor<String> captorString;

  @BeforeEach
  void setUp() {
    OfferEntityRepositoryStubs.behaviour(offerEntityRepository);
    WorkRequestEntityRepositoryStubs.behaviour2(workRequestRepository);
  }
}
