package com.kodekonveyor.webapp;

import lombok.Getter;

@Getter
public class NotLoggedInException extends RuntimeException {

  private static final long serialVersionUID = -4900004519786666447L;

  public NotLoggedInException(final String message) {
    super(message);
  }
}
