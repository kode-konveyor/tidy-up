package com.kodekonveyor.work_request.revoke;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("RevokeWorkRequestController")

public class RevokeWorkRequestControllerLoggingTest
    extends RevokeWorkRequestControllerTestBase {

  @Test
  @DisplayName(
    "The call of Revoke Controller Sevice call is Logged with Revoked entity"
  )
  public void test1() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(RevokeWorkRequestControllerTestData.SERVICE_CALL_NAME), captorString.capture()
        );
    assertEquals(
        RevokeWorkRequestController.class.getName(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of Revoke Controller input validation is Logged with Revoked entity"
  )
  public void test2() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .info(
            Mockito.eq(RevokeWorkRequestControllerTestData.INPUT_VALIDATION),
            Mockito.eq(RevokeWorkRequestController.class.getName()), captorLong.capture()
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "The call of Revoke Controller work Request ID for find work request is Logged"
  )
  public void test3() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .info(
            Mockito
                .eq(RevokeWorkRequestControllerTestData.FIND_WORK_REQUEST_ENTITY),
            Mockito.eq(RevokeWorkRequestController.class.getName()), captorLong.capture()
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "The call of Revoke Controller input validation SUCCESS is Logged with workRequestID"
  )
  public void test4() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .debug(
            Mockito.eq(RevokeWorkRequestControllerTestData.INPUT_VALIDATION),
            Mockito.eq(RevokeWorkRequestController.class.getName()), captorLong.capture(),
            Mockito.eq(RevokeWorkRequestControllerTestData.SUCCESS)
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "The call of Revoke Controller find work request entity SUCCESS is Logged with workRequestID"
  )
  public void test5() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .debug(
            Mockito
                .eq(RevokeWorkRequestControllerTestData.FIND_WORK_REQUEST_ENTITY),
            Mockito.eq(RevokeWorkRequestController.class.getName()), captorLong.capture(),
            Mockito.eq(RevokeWorkRequestControllerTestData.SUCCESS)
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

}
