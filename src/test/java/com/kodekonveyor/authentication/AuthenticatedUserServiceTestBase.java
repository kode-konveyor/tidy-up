package com.kodekonveyor.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AuthenticatedUserServiceTestBase {

  @InjectMocks
  AuthenticatedUserService authenticatedUserService;
  @Mock
  UserEntityRepository userEntityRepository;

  @BeforeEach
  void setUp() {
    UserEntityRepositoryStubs.behaviour(userEntityRepository);
  }

}
