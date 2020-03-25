package com.kodekonveyor.completion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.webapp.LoggerService;

@RestController
public class MarkCompletionController {

  @Autowired
  LoggerService loggerService;

  @PutMapping
  public void call() {
    loggerService.call(this.getClass().getName());
  }

}
