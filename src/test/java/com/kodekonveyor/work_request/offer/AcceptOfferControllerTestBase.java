package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  protected AcceptOfferController acceptOfferController;
  @Mock
  WorkRequestRepository workRequestRepository;

  @Mock
  OfferRepository offerRepository;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  public AcceptOfferControllerTestBase() {
    super();
  }

  @BeforeEach
  void setUp() {
    WorkRequestEntityRepositoryStubs.behaviour(workRequestRepository);
    OfferRepositoryStubs.behaviour(offerRepository);
  }

}
