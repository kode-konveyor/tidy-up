package com.kodekonveyor.completion;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.webapp.LoggerService;

public class MarkCompletionControllerTestBase {

  @InjectMocks
  MarkCompletionController markCompletionController;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  @Mock
  LoggerService loggerService;

  @BeforeEach
  void setUp() {
    AuthenticatedUserStubs.behaviour(authenticatedUserService);
  }

}
