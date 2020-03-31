package com.kodekonveyor.work_request.revoke;

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
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)

@TestedBehaviour("Save the new/modified entities")
@TestedService("RevokeWorkRequestController")

class RevokeWorkRequestControllerTest
    extends RevokeWorkRequestControllerTestBase {

  @Test
  @DisplayName("Check if Delete is called")
  void test() {

    revokeWorkRequestController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    Mockito.verify(workRequestRepository)
        .delete(Mockito.eq(WorkRequestEntityTestData.get()));

  }

}
