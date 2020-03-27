package com.kodekonveyor.completion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
@TestedBehaviour("Logging")
@TestedService("MarkCompletionController")
public class MarkCompletionControllerLoggingTest
    extends MarkCompletionControllerTestBase {

  @Test
  @DisplayName("Log when controller is started")
  void test1() {
    markCompletionController
        .call(WorkRequestEntityTestData.WORK_REQUEST_ID);
    final ArgumentCaptor<String> msg = ArgumentCaptor.forClass(String.class);
    Mockito.verify(loggerService).call(msg.capture());
    assertTrue(msg.getValue().contains(CompletionTestData.IS_STARTED));

  }
}
