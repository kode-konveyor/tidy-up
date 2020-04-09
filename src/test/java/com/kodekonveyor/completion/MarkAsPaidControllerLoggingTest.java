package com.kodekonveyor.completion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("Logging")
@TestedService("MarkAsPaidController")
public class MarkAsPaidControllerLoggingTest
    extends MarkAsPaidControllerStatusesTestBase {

  @Test
  @DisplayName("The name of the controller is logged")
  void test1() {

    final ArgumentCaptor<String> argCaptor =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(loggerService).call(argCaptor.capture());

    Assertions
        .assertTrue(
            argCaptor.getValue()
                .contains(MarkAsPaidControllerTestData.CLASS_NAME)
        );

  }

  @Test
  @DisplayName("The call of MarkAsPaidController input validation is logged")
  void test2() {
    final ArgumentCaptor<Long> captorLong =
        ArgumentCaptor.forClass(Long.class);

    Mockito.verify(logger)
        .info(Mockito.eq(MarkAsPaidControllerTestData.INPUT_VALIDATION), captorLong.capture());
    Assertions.assertEquals(
        WorkRequestEntityTestData.get().getId(),
        captorLong.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of MarkAsPaidController input validation SUCCESS is logged"
  )
  void test3() {
    final ArgumentCaptor<String> captorString =
        ArgumentCaptor.forClass(String.class);

    Mockito.verify(logger)
        .debug(
            Mockito.eq(MarkAsPaidControllerTestData.INPUT_VALIDATION_STATUS), captorString.capture(), Mockito.eq(MarkAsPaidControllerTestData.SUCCESS)
        );
    Assertions.assertEquals(
        WorkRequestEntityTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of MarkAsPaidController find work request is logged"
  )
  void test4() {
    final ArgumentCaptor<String> captorString =
        ArgumentCaptor.forClass(String.class);

    Mockito.verify(logger)
        .info(
            Mockito.eq(MarkAsPaidControllerTestData.FIND_WORK_REQUEST), captorString.capture()
        );
    Assertions.assertEquals(
        WorkRequestEntityTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Test
  @DisplayName(
    "The call of MarkAsPaidController find work request SUCCESS is Logged"
  )
  public void test5() {
    final ArgumentCaptor<String> captorString =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(logger)
        .debug(
            Mockito.eq(MarkAsPaidControllerTestData.FIND_WORK_REQUEST_STATUS), captorString.capture(), Mockito.eq(MarkAsPaidControllerTestData.SUCCESS)
        );
    Assertions.assertEquals(
        WorkRequestEntityTestData.get().getId(),
        captorString.getValue()
    );
  }

  @Override
  @BeforeEach
  public void setUp() {
    super.setUp();
    workRequestEntityData.setStatus(WorkRequestStatusEnum.VERIFIED);
    markAsPaidController.call(workRequestEntityData.getId());
  }

}
