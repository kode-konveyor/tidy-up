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

  @Override
  @BeforeEach
  public void setUp() {
    super.setUp();
    workRequestEntityData.setStatus(WorkRequestStatusEnum.VERIFIED);
    markAsPaidController.call(workRequestEntityData.getId());
  }

}
