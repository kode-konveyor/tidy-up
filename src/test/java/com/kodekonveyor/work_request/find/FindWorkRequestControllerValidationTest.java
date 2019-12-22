package com.kodekonveyor.work_request.find;

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
@TestedService("findWorkRequestController")

public class FindWorkRequestControllerValidationTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName(
    "When the work type is null, an exception is thrown."
  )
  public void testWorktypeIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            addressTestData.COUNTRY,
            addressTestData.CITY, null
        )
    )
        .assertMessageIs(
            createWorkRequestTestData.NULL_WORKTYPE
        );

  }

  @Test
  @DisplayName(
    "When the country is null, an exception is thrown."
  )
  public void testCountryIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            null,
            addressTestData.CITY,
            workRequestTestData.WORK_TYPE
        )
    )
        .assertMessageIs(
            addressTestData.NULL_COUNTRY
        );

  }

  @Test
  @DisplayName(
    "When the city is null, an exception is thrown."
  )
  public void testCityIsNotNull() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            addressTestData.COUNTRY,
            null, workRequestTestData.WORK_TYPE
        )
    )
        .assertMessageIs(
            addressTestData.NULL_CITY
        );

  }

  @Test
  @DisplayName("Country cannot be more or less than 2 letter")
  public void testtCountryCodeLenght() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            addressTestData.COUNTRY_LENGHT,
            addressTestData.CITY, workRequestTestData.WORK_TYPE
        )

    )
        .assertMessageIs(addressTestData.COUNTRY_LENGTH_ERROR_MESSAGE);

  }

  @Test
  @DisplayName("Country can contain only alphahet")
  public void testCountryCode() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            addressTestData.COUNTRY_ALPHABET,
            addressTestData.CITY, workRequestTestData.WORK_TYPE
        )

    )
        .assertMessageIs(addressTestData.COUNTRY_CODE_ALPHABET);
  }

  @Test
  @DisplayName("City can contain only alphabet")
  public void testCity() {

    ThrowableTester.assertThrows(
        () -> findWorkRequestController.call(
            addressTestData.COUNTRY,
            addressTestData.CITY_NON_ALPHABET, workRequestTestData.WORK_TYPE
        )

    )
        .assertMessageIs(addressTestData.CITY_NON_ALPHABET_EXEPTION);
  }

}
