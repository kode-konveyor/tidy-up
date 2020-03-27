package com.kodekonveyor.work_request.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("accepted offer")
@TestedService("AcceptOfferController")

public class AcceptOfferControllerAcceptedOfferTest extends AcceptOfferControllerTestBase {

  @Test
  @DisplayName("The current user is set as the provider of the work request")

  void test1() {
    acceptOfferController.call(OfferEntityTestData.OFFER_ID);
    final ArgumentCaptor<WorkRequestEntity> entity =
        ArgumentCaptor.forClass(WorkRequestEntity.class);
    Mockito.verify(workRequestRepository).save(entity.capture());
    assertEquals(UserEntityTestData.get(), entity.getValue().getProvider());
  }
}
