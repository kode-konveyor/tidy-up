package com.kodekonveyor.work_request.find;

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
import com.kodekonveyor.webapp.LoggingConstants;
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("logging")
@TestedService("FindWorkRequestController")
public class FindWorkRequestControllerLoggingTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName("The call of the service is logged with INFO level")
  public void test() {
    findWorkRequestController
        .call(
            AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
            WorkRequestEntityTestData.WORK_TYPE
        );
    Mockito.verify(loggerService).info(
        WorkRequestConstants.WORK_REQUEST_FIND
    );
  }

  @Test
  @DisplayName("Find of work request entity logged with FINE level")
  public void test2() {
    findWorkRequestController
        .call(
            AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
            WorkRequestEntityTestData.WORK_TYPE
        );
    Mockito.verify(loggerService).debug(
        LoggingConstants.SUCCESS, LoggingConstants.WORK_REQUEST_FIND_COMPLETED,
        WorkRequestEntityTestData.WORK_REQUEST_ID_STRING
    );
  }
}
