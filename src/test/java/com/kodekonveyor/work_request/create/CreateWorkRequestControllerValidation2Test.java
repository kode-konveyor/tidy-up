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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("CreateWorkRequestController")

public class CreateWorkRequestControllerValidation2Test
    extends CreateWorkRequestControllerTestBase {

  @Test
  @DisplayName("Country cannot be more or less than 2 letter")
  public void testCreateWorkRequestCountryCodeLenght() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(createWorkRequestTestData.CREATE_WORK_REQUEST_COUNTRY_LENGTH)
    )
        .assertMessageIs(addressTestData.COUNTRY_LENGTH_ERROR_MESSAGE);

  }

  @Test
  @DisplayName("Country can contains only alphahets")
  public void testCreateWorkRequestCountryCodeDigit() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController.call(
            createWorkRequestTestData.CREATE_WORK_REQUEST_COUNTRY_ALPHABET
        )
    )
        .assertMessageIs(addressTestData.COUNTRY_CODE_ALPHABET);

  }

  @Test
  @DisplayName("Address can contains only 120 characters")
  public void testCreateWorkRequestAddressLength() {

    ThrowableTester.assertThrows(
        () -> createWorkRequestController
            .call(createWorkRequestTestData.CREATE_WORK_REQUEST_ADDRESS_LENGTH)
    )
        .assertMessageIs(addressTestData.ADDRESS_LENGTHEXCEED);

  }

  @Test
  @DisplayName("Customer Id cannot be negative")
  public void testCreateWorkRequestCustomerId1() {
    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    createWorkRequestTestData.CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID
                )
        )
        .assertMessageIs(
            createWorkRequestTestData.NEGATIVE_CUSTOMERID_ERROR_MESSAGE
        );
  }

  @Test
  @DisplayName("Work type cannot contain digits")
  public void testCreateWorkRequestWorkType1() {

    ThrowableTester
        .assertThrows(
            () -> createWorkRequestController
                .call(
                    createWorkRequestTestData.CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE
                )
        )
        .assertMessageIs(
            createWorkRequestTestData.DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR
        );

  }

  //  @Test
  //  @DisplayName("Invalid Work type ")
  //  public void testCreateWorkRequestWorkType2() {
  //
  //    ThrowableTester.assertThrows(
  //        () -> createWorkRequestController.call(
  //            createWorkRequestTestData.CREATE_WORK_REQUEST_INVALID_WORKTYPE
  //        )
  //    )
  //        .assertMessageIs(
  //            createWorkRequestTestData.INVALID_WORKTYPE_ERROR_MESSAGE
  //        );

  //  }

  //

}
