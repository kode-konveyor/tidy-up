package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  protected AcceptOfferController acceptOfferController;
  @Mock
  protected WorkRequestRepository workRequestRepository;
  @Mock
  AuthenticatedUserService authenticatedUserService;
  @Mock
  OfferEntityRepository offerEntityRepository;

  @BeforeEach
  void setUp() {
    OfferEntityRepositoryStubs.behaviour(offerEntityRepository);
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
    WorkRequestEntityRepositoryStubs.behaviour(workRequestRepository);
  }

}
