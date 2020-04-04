package com.kodekonveyor.work_request.find;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestListDTO;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("statuses")
@TestedService("FindWorkRequestController")

public class FindWorkRequestControllerStatusesTest
    extends FindWorkRequestControllerTestBase {

  @Test
  @DisplayName(
    "Not Posted work requests which do not belong to the user, not returned."
  )
  void test2() {
    final WorkRequestListDTO call = findWorkRequestController.call(
        AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
        WorkRequestEntityTestData.WORK_TYPE
    );
    assertEquals(
        WorkRequestEntityTestData.ENTITY_WITHOUT_OWNER_COUNT,
        call.getRequests().size()
    );
  }

  @Test
  @DisplayName(
    "Not Posted work requests for which the user is the owner, are returned."
  )
  void test3() {
    final WorkRequestListDTO call = findWorkRequestController.call(
        AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
        WorkRequestEntityTestData.WORK_TYPE
    );
    assertEquals(
        UserEntityTestData.CUSTOMER_ID, call.getRequests().get(1).getWorkRequestId()
    );
  }

  @Test
  @DisplayName(
    "Not Posted work requests for which the user is the provider, are returned."
  )
  void test4() {
    final WorkRequestListDTO call = findWorkRequestController.call(
        AddressEntityTestData.COUNTRY, AddressEntityTestData.CITY,
        WorkRequestEntityTestData.WORK_TYPE
    );
    assertEquals(
        UserEntityTestData.PROVIDER_ID, call.getRequests().get(1).getWorkRequestId()
    );
  }
}
