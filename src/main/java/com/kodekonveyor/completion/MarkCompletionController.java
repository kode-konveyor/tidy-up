package com.kodekonveyor.completion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.webapp.LoggerService;

@RestController
public class MarkCompletionController {

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @Autowired
  LoggerService loggerService;

  @PutMapping("/paid/{workRequestId}")
  void call(final Long workRequestId) {
    loggerService.call(CompletionConstants.IS_STARTED);

  }
}
