package com.kodekonveyor.work_request.create;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerValidationTest
    extends CreateWorkRequestControllerTestBase {

  @Test()
  @DisplayName("We return an exception for invalid customer id")
  public void createWorkRequestControllerValidatesCustomerId() {
    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID)
    )
        .assertException(ValidationException.class)
        .assertMessageContains(workRequestTestData.INVALID_CUSTOMER_ID);
  }

  @Test()
  @DisplayName("We return an exception for invalid work type")
  public void createWorkRequestControllerValidatesWorkType() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_WORKTYPE)
    )
        .assertException(ValidationException.class)
        .assertMessageContains(workRequestTestData.INVALID_WORK_TYPE);
  }

  @Test()
  @DisplayName("We return an exception for invalid description")
  public void createWorkRequestControllerValidatesDescription() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION)
    )
        .assertException(ValidationException.class)
        .assertMessageContains(workRequestTestData.INVALID_DESCRIPTION);
  }

  @Test()
  @DisplayName("We return an exception for invalid address")
  public void createWorkRequestControllerValidatesAddress() {

    final CreateWorkRequestDTO createWorkRequestDTO =
        workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_ADDRESS;
    ThrowableTester.assertThrows(
        () -> createWorkRequestController.call(createWorkRequestDTO)
    )
        .assertException(ValidationException.class).assertMessageContains(workRequestTestData.INVALID_ADDRESS);
  }

  @Test()
  @DisplayName("We return an exception for invalid city")
  public void createWorkRequestControllerValidatesCity() {

    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_CITY)
        )
        .assertException(ValidationException.class).assertMessageContains(workRequestTestData.INVALID_CITY);
  }

  @Test()
  @DisplayName("We return an exception for invalid country")
  public void createWorkRequestControllerValidatesCountry() {

    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(workRequestTestData.CREATE_REQUEST_DTO_WITH_BAD_COUNTRY)
        )
        .assertException(ValidationException.class).assertMessageContains(workRequestTestData.INVALID_COUNTRY);
  }

}
