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
import com.kodekonveyor.work_request.WorkRequestDTOTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("AcceptOfferController")

public class AcceptOfferControllerLoggingTest
    extends AcceptOfferControllerTestBase {

  @BeforeEach
  public void setUpTest() {
    acceptOfferController.call(OfferDTOTestData.get().getId());
  }

  @Test
  @DisplayName(
    "The call of AccepptOfferController is Logged"
  )
  public void test1() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(AcceptOfferControllerTestData.SERVICE_CALL_NAME), captorString.capture()
        );
    assertEquals(
        AcceptOfferController.class.getName(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The Find work request log"
  )
  public void test2() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(AcceptOfferControllerTestData.FIND_OFFER), captorString.capture()
        );
    assertEquals(
        OfferDTOTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The Find work request return log"
  )
  public void test3() {
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(AcceptOfferControllerTestData.FIND_OFFER_STATUS), captorString.capture(), Mockito.eq(AcceptOfferControllerTestData.SUCCESS)
        );
    assertEquals(
        OfferEntityTestData.getWorkRequestPosted().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "set work request enum log"
  )
  public void test4() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(AcceptOfferControllerTestData.SET_WORK_REQUEST_ENUM), captorString.capture()
        );
    assertEquals(
        WorkRequestStatusEnum.AGREED,
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "set work request enum status log"
  )
  public void test5() {
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(
                AcceptOfferControllerTestData.SET_WORK_REQUEST_ENUM_STATUS
            ), captorString.capture(),
            Mockito.eq(AcceptOfferControllerTestData.SUCCESS)
        );
    assertEquals(
        WorkRequestEntityTestData.getStatusAgreed(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "Save work request log"
  )
  public void test6() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(
                AcceptOfferControllerTestData.SAVE_WORK_REQUEST
            ), captorString.capture()

        );
    assertEquals(
        WorkRequestEntityTestData.getStatusAgreed(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "return work request DTO success"
  )
  public void test7() {
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(
                AcceptOfferControllerTestData.RETURN_WORK_REQUEST_DTO_STATUS
            ), captorString.capture(), Mockito.eq(
                AcceptOfferControllerTestData.SUCCESS
            )

        );
    assertEquals(
        WorkRequestDTOTestData.getStatusAgreedAndProvider(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "return work request log"
  )
  public void test8() {
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(
                AcceptOfferControllerTestData.RETURN_WORK_REQUEST_DTO
            ), captorString.capture()

        );
    assertEquals(
        WorkRequestDTOTestData.getStatusAgreedAndProvider(),
        captorString.getValue()
    );
  }
}
