package com.kodekonveyor.work_request.find;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("FindWorkRequestController")

public class FindWorkRequestProviderTest
    extends FindWorkRequestControllerTestBase {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    WorkRequestEntityRepositoryStubs.behaviourCustomer(
        workRequestRepository
    );

    AuthenticatedUserStubs.behaviour(authenticatedUserService);
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
