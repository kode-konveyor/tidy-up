package com.kodekonveyor.work_request.find;

import static org.junit.Assert.assertEquals;

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
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;
import com.kodekonveyor.work_request.create.WorkRequestValidationUtilTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("FindWorkRequestController")

public class FindWorkRequestControllerStatusesTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName("Work type cannot be null")
  public void testFindWorkRequestNullWorkType() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.VALID_COUNTRY,
                FindWorkRequestTestData.VALID_CITY,
                FindWorkRequestTestData.NUll_WORKTYPE
            )
    )
        .assertMessageIs(WorkRequestValidationUtilTestData.NULL_WORKTYPE);

  }

  @Test
  @DisplayName("Country cannot be null")
  public void testFindWorkRequestNullCountry() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.NUll_COUNTRY,
                FindWorkRequestTestData.VALID_CITY,
                FindWorkRequestTestData.VALID_WORKTYPE
            )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_CANNOT_BE_EMPTY
        );

  }

  @Test
  @DisplayName("Country cannot be more or less than 2 letter")
  public void testFindWorkRequestLengthCountry() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.INVALID_LARGE_COUNTRY,
                FindWorkRequestTestData.VALID_CITY,
                FindWorkRequestTestData.VALID_WORKTYPE
            )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_LENGTH_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName("Country can contain alphabetic characters/letters only")
  public void testFindWorkRequestRegexCountry() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.INVALID_COUNTRY,
                FindWorkRequestTestData.VALID_CITY,
                FindWorkRequestTestData.VALID_WORKTYPE
            )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.COUNTRY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName("City cannot be null")
  public void testFindWorkRequestNullCity() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.VALID_COUNTRY,
                FindWorkRequestTestData.NUll_CITY,
                FindWorkRequestTestData.VALID_WORKTYPE
            )
    )
        .assertMessageIs(WorkRequestValidationUtilTestData.CITY_CANNOT_BE_EMPTY);

  }

  @Test
  @DisplayName("City can contain alphabetic characters/letters only")
  public void testFindWorkRequestRegexCity() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController
            .call(
                FindWorkRequestTestData.VALID_COUNTRY,
                FindWorkRequestTestData.INVALID_CITY,
                FindWorkRequestTestData.VALID_WORKTYPE
            )
    )
        .assertMessageIs(
            WorkRequestValidationUtilTestData.CITY_CODE_NON_ALPHABETIC_CHARACTER_ERROR_MESSAGE
        );

  }

  @Test
  @DisplayName("Sucess when status is not in POSTED")
  public void testSuccessNotInPostedState() {

    assertEquals(
        WorkRequestStatusEnum.AGREED.name(),
        findWorkRequestController
            .call(
                AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
                WorkRequestEntityTestData.WORK_TYPE
            )
            .getRequests().get(0).getStatus()
    );

  }

  @Test
  @DisplayName("Sucess when status is not in POSTED for Customer")
  public void testSuccessNotInPostedProvider() {

    assertEquals(
        WorkRequestStatusEnum.AGREED.name(),
        findWorkRequestController
            .call(
                AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
                WorkRequestEntityTestData.WORK_TYPE
            )
            .getRequests().get(0).getStatus()
    );

  }
}
