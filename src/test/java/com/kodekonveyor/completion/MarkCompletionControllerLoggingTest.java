package com.kodekonveyor.completion;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestedBehaviour("Logging")
@TestedService("MarkCompletionController")

public class MarkCompletionControllerLoggingTest
    extends MarkCompletionControllerTestBase {

  @Test
  @DisplayName("Name of the controller is logged")

  void test1() {
    markCompletionController.call();
    final ArgumentCaptor<String> argCaptor =
        ArgumentCaptor.forClass(String.class);
    Mockito.verify(loggerService).call(argCaptor.capture());
    assertTrue(
        argCaptor.getValue()
            .contains(CompletionTestData.MARK_COMPLETION_CONTROLLER)
    );
  }

}
