package com.kodekonveyor.completion;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.webapp.LoggerService;

public class MarkCompletionControllerTestBase {

  @InjectMocks
  protected MarkCompletionController markCompletionController;
  @Mock
  protected LoggerService loggerService;

}
