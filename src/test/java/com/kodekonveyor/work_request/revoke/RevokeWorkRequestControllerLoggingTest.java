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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.open.OpenWorkRequestControllerTestData;

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
            captorLong.capture()
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
            captorLong.capture()
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
            Mockito.eq(
                RevokeWorkRequestControllerTestData.INPUT_VALIDATION_STATUS
            ),
            captorLong.capture(),
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
                .eq(
                    RevokeWorkRequestControllerTestData.FIND_WORK_REQUEST_ENTITY_STATUS
                ),
            captorLong.capture(),
            Mockito.eq(RevokeWorkRequestControllerTestData.SUCCESS)
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "The call of Revoke Controller delete work request entity is Logged with workRequestID"
  )
  public void test6() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .info(
            Mockito
                .eq(
                    RevokeWorkRequestControllerTestData.DELETE_WORK_REQUEST_ENTITY
                ),
            captorLong.capture()
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "The call of Revoke Controller delete work request entity SUCCESS is Logged with workRequestID"
  )
  public void test7() {
    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(loggerService)
        .debug(
            Mockito
                .eq(
                    RevokeWorkRequestControllerTestData.DELETE_WORK_REQUEST_ENTITY_STATUS

                ),
            captorLong.capture(), Mockito
                .eq(RevokeWorkRequestControllerTestData.SUCCESS)
        );
    assertEquals(
        WorkRequestEntityTestData.WORK_REQUEST_ID,
        captorLong.getValue()
    );

  }

  @Test
  @DisplayName(
    "Revoke Controller input validation failure with invalid work request ID Log"
  )
  public void test8() {
    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.INVALID_WORK_REQUEST_ID)
    ).assertMessageIs(
        OpenWorkRequestControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION
    );
    Mockito.verify(loggerService)
        .warn(
            Mockito
                .eq(
                    RevokeWorkRequestControllerTestData.INPUT_VALIDATION_STATUS
                ),
            captorString.capture(),
            Mockito
                .eq(RevokeWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        RevokeWorkRequestControllerTestData.INVALID_WORK_REQUEST_ID_EXCEPTION,
        captorString.getValue()
    );

  }

  @Test
  @DisplayName(
    "Revoke Controller input validation failure with non-positive work request ID Log"
  )
  public void test9() {
    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.NON_POSITIVE_WORK_REQUEST_ID)
    ).assertMessageIs(
        OpenWorkRequestControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION
    );
    Mockito.verify(loggerService)
        .warn(
            Mockito
                .eq(
                    RevokeWorkRequestControllerTestData.INPUT_VALIDATION_STATUS
                ),
            captorString.capture(),
            Mockito
                .eq(RevokeWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        RevokeWorkRequestControllerTestData.NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION,
        captorString.getValue()
    );

  }

  @Test
  @DisplayName(
    "Revoke Controller delete work request entity FAILURE is Logged"
  )
  public void test10() {

    ThrowableTester.assertThrows(
        () -> revokeWorkRequestController
            .call(WorkRequestEntityTestData.REVOKE_WORK_REQUEST_ID)
    )
        .assertMessageIs(
            RevokeWorkRequestControllerTestData.WORK_REQUEST_ACCESS_EXCEPTION
        );
    Mockito.verify(loggerService)
        .warn(
            Mockito
                .eq(
                    RevokeWorkRequestControllerTestData.DELETE_WORK_REQUEST_ENTITY_STATUS

                ),
            captorString.capture(), Mockito
                .eq(RevokeWorkRequestControllerTestData.FAILURE)
        );
    assertEquals(
        RevokeWorkRequestControllerTestData.WORK_REQUEST_ACCESS_EXCEPTION,
        captorString.getValue()
    );

  }

}
