package com.kodekonveyor.work_request.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("GiveOfferController")

public class GiveOfferControllerLogging extends GiveofferControllerTestBase {

  @BeforeEach
  public void setUpTest() {
    giveofferController.call(OfferDTOTestData.get());
  }

  @Test
  @DisplayName(
    "The call of GiveOfferController is Logged"
  )
  public void test1() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(GiveofferControllerTestData.SERVICE_CALL_NAME), captorString.capture()
        );
    assertEquals(
        GiveofferController.class.getName(),
        captorString.getValue()
    );
  }

}
