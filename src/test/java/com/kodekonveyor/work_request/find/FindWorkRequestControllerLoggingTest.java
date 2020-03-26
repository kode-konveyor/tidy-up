package com.kodekonveyor.work_request.find;

import static org.junit.Assert.assertTrue;

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
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@TestedBehaviour("Logging")
@TestedService("FindWorkRequestController")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)

public class FindWorkRequestControllerLoggingTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName("The call of the service is logged")
  void teszt1() {
    findWorkRequestController
        .call(
            AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
            WorkRequestEntityTestData.WORK_TYPE
        );
    final ArgumentCaptor<String> argumentCaptor =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(loggerService).call(argumentCaptor.capture());
    assertTrue(argumentCaptor.getValue().contains(FindTestData.IS_STARTED));
  }

}
