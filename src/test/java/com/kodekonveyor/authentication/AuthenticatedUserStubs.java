package com.kodekonveyor.authentication;

import static org.mockito.Mockito.doReturn;

public class AuthenticatedUserStubs {

  public static void behaviour(
      final AuthenticatedUserService authenticatedUserService
  ) {

    doReturn(UserEntityTestData.get()).when(authenticatedUserService).call();

  }

  public static void providerIsAuthenticated(
      final AuthenticatedUserService authenticatedUserService
  ) {

    doReturn(UserEntityTestData.getIdProvider()).when(authenticatedUserService)
        .call();

  }
}
