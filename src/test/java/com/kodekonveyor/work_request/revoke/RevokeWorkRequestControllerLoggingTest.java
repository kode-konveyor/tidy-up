package com.kodekonveyor.work_request.revoke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

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
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("RevokeWorkRequestController")

public class RevokeWorkRequestControllerLoggingTest
    extends RevokeWorkRequestControllerTestBase {

  @Test
  @DisplayName("The call of Revoke Controller is Logged with Revoked entity")
  public void test1() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService, times(numberOfCallForInfoInLoggerService))
        .info(
            captor.capture()
        );

    assertEquals(
        RevokeWorkRequestController.class.getName(),
        captor.getAllValues().get(0)
    );
  }

  @Test
  @DisplayName(
    "The call of Revoke Controller input validation is Logged with Revoked entity"
  )
  public void test2() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService, times(numberOfCallForInfoInLoggerService))
        .info(
            captor.capture()
        );
    assertEquals(
        RevokeWorkRequestController.class.getName() + WorkRequestConstants.DOT +
            WorkRequestConstants.INPUT_VALIDATION,
        captor.getAllValues().get(1)
    );
  }

  @Test
  @DisplayName(
    "The call of Revoke Controller input validation SUCCESS is Logged with Revoked entity"
  )
  public void test3() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService, times(numberOfCallForFineInLoggerService))
        .fine(
            captor.capture()
        );

    assertEquals(
        RevokeWorkRequestController.class.getName() + WorkRequestConstants.DOT +
            WorkRequestConstants.INPUT_VALIDATION + WorkRequestConstants.DOT +
            WorkRequestConstants.SUCCESS,
        captor.getAllValues().get(0)
    );
  }

  @Test
  @DisplayName(
    "The call of Revoke Controller find work request entity is Logged with Revoked entity"
  )
  public void test4() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService, times(numberOfCallForInfoInLoggerService))
        .info(
            captor.capture()
        );

    assertEquals(
        RevokeWorkRequestController.class.getName() + WorkRequestConstants.DOT +
            WorkRequestConstants.FIND_WORK_REQUEST_ENTITY,
        captor.getAllValues().get(2)
    );
  }

  @Test
  @DisplayName(
    "The call of Revoke Controller find work request entity SUCCESS is Logged with Revoked entity"
  )
  public void test5() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService, times(numberOfCallForFineInLoggerService))
        .fine(
            captor.capture()
        );

    assertEquals(
        RevokeWorkRequestController.class.getName() + WorkRequestConstants.DOT +
            WorkRequestConstants.FIND_WORK_REQUEST_ENTITY +
            WorkRequestConstants.DOT +
            WorkRequestConstants.SUCCESS,
        captor.getAllValues().get(1)
    );
  }

}
