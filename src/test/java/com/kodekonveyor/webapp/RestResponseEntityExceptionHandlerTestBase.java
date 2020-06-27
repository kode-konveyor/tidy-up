package com.kodekonveyor.webapp;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

public class RestResponseEntityExceptionHandlerTestBase {

  @InjectMocks
  RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;
  @Mock
  Logger loggerService;
  ResponseEntity<Object> response;

  @BeforeEach
  void setUp() {
    restResponseEntityExceptionHandler.loginUrl =
        HttpServletRequestTestData.LOGIN_URL;
    response = restResponseEntityExceptionHandler.handleNotLoggedInException(
        HttpServletRequestTestData.NOT_LOGGED_IN_EXCEPTION,
        HttpServletRequestTestData.getWebRequest()
    );
  }

}
