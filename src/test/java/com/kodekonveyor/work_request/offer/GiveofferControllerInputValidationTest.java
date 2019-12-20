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
import com.kodekonveyor.exception.ThrowableTester;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
public class GiveofferControllerInputValidationTest
    extends GiveofferControllerTestBase {

  @Test
  @DisplayName(
    "When the price is zero, an exception is thrown."
  )
  public void testOfferForInvalidPrice() {
    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(giveofferControllerTestData.OFFER_DTO_INVALID_PRICE)
    )
        .assertMessageIs(
            giveofferControllerTestData.INVALID_PRICE
        );

  }

  @Test
  @DisplayName(
    "When the price is non-positive, an exception is thrown."
  )
  public void testPriceNegativeId() {

    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(giveofferControllerTestData.OFFER_DTO_NEGATIVE_PRICE)
    )
        .assertMessageIs(
            giveofferControllerTestData.NEGATIVE_PRICE_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is non-positive, an exception is thrown."
  )
  public void testWorkRequestNegativeId() {

    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(
                giveofferControllerTestData.OFFER_DTO_NON_POSITIVE_WORK_REQUEST_ID
            )
    )
        .assertMessageIs(
            giveofferControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is not present in repository, an exception is thrown."
  )
  public void testWorkRequestInvalidId() {
    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(
                giveofferControllerTestData
                    .createOFFER_DTO_INVALID_WORK_REQUEST_ID()
            )
    )
        .assertMessageIs(
            giveofferControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION
        );

  }

  @Test
  @DisplayName(
    "When the work request id is zero, an exception is thrown."
  )
  public void testZeroWorkRequestId() {
    ThrowableTester.assertThrows(
        () -> giveofferController
            .call(
                giveofferControllerTestData
                    .createOFFER_DTO_ZERO_WORK_REQUEST_ID()
            )
    )
        .assertMessageIs(
            giveofferControllerTestData.ZERO_WORK_REQUEST_ID_EXCEPTION
        );

  }

}
