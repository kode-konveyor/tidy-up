package com.kodekonveyor.work_request.offer;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntityTestData;

public class AcceptOfferControllerTestBase {

  @InjectMocks
  protected AcceptOfferController acceptOfferController;

  @Mock
  private OfferEntityRepository offerEntityRepository;

  @Mock
  private AuthenticatedUserService authenticatedUserService;

  @BeforeEach
  public void setUp() {
    doReturn(Optional.of(OfferEntityTestData.get()))
        .when(offerEntityRepository)
        .findById(OfferTestData.OFFER_ID);

    doReturn(Optional.of(OfferEntityTestData.getWithOtherUser())).when(
        offerEntityRepository
    ).findById(OfferTestData.UNAUTHORIZED_OFFER_ID);

    doReturn(UserEntityTestData.get()).when(authenticatedUserService)
        .call();

  }

}
