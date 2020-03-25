package com.kodekonveyor.work_request.offer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("access control")
@TestedService("AcceptOfferController")
class AcceptOfferControllerAccessControlTest
    extends AcceptOfferControllerTestBase {

  @Test
  @DisplayName("No exception when authenticate user and owner is same")
  void test1() {
    acceptOfferController.call(OfferTestData.OFFER_ID);
  }

  @Test
  @DisplayName("exception when authenticate user and owner is not same")
  void test2() {
    ThrowableTester.assertThrows(
        () -> acceptOfferController.call(OfferTestData.UNAUTHORIZED_OFFER_ID)
    );

  }

}
