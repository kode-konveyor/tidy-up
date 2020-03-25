package com.kodekonveyor.work_request.open;

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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("access control")
@TestedService("CustomerGetWorkRequestsController")
public class CustomerGetWorkRequestsControllerAccessControlTest
    extends CustomerGetWorkRequestsControllerTestBase {

  @Test
  @DisplayName("user cannot list a work request of another user")
  void test1() {

    AuthenticatedUserStubs
        .ownerOfNoworkRequestIsLoggedIn(authenticatedUserService);
    ThrowableTester.assertThrows(
        () -> customerGetWorkRequestsController
            .call(WorkRequestTestData.OWNER_ID)
    ).assertException(ValidationException.class);
  }

  @Test
  @DisplayName("user can list work request of herself/himself")
  void test2() {
    AuthenticatedUserStubs.behaviour(authenticatedUserService);

    ThrowableTester.assertNoException(
        () -> customerGetWorkRequestsController
            .call(WorkRequestTestData.OWNER_ID)
    );

  }
}
