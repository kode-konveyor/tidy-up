package com.kodekonveyor.work_request.open;

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
import com.kodekonveyor.work_request.WorkRequestDTOTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Logging")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerLoggingTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName("The call of controller is logged sucessfully")
  public void test() {
    openWorkRequestController
        .call(WorkRequestDTOTestData.get().getWorkRequestId());
    Mockito.verify(loggerService).call(captor.capture());
    assertEquals(
        OpenWorkRequestController.class.getName(),
        captor.getValue()
    );
  }
}
