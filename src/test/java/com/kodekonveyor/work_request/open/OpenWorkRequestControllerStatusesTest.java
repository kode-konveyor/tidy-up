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
import com.kodekonveyor.exception.ThrowableTester;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("statuses")
@TestedService("OpenWorkRequestController")
public class OpenWorkRequestControllerStatusesTest
    extends OpenWorkRequestControllerTestBase {

  @Test
  @DisplayName("Work requests not posted will not be returned")
  void testOne() {

    ThrowableTester.assertThrows(
        () -> openWorkRequestController
            .call(WorkRequestEntityTestData.WORK_REQUEST_ID_NOT_POSTED)
    ).showStackTrace();
  }
}
