package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("accepted offer")
@TestedService("AcceptOfferController")
public class AcceptOfferControllerAcceptedOfferTest
    extends AcceptOfferControllerTestBase {

  @Test
  @DisplayName(
    "When an offer is accepted, the provider of the offer is set as the provider of the work request"
  )
  public void testAcceptedOffer() {
    AuthenticatedUserStubs.providerIsAuthenticated(authenticatedUserService);
    final OfferEntity offerEntity = OfferEntityTestData.getProviderFilledIn();
    acceptOfferController.call(offerEntity.getId());
    final WorkRequestEntity entity =
        WorkRequestEntityTestData.getProviderFilledIn();
    Mockito.verify(workRequestRepository).save(entity);
  }
}
