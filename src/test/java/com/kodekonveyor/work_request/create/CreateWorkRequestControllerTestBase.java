package com.kodekonveyor.work_request.create;

import com.kodekonveyor.authentication.*;
import com.kodekonveyor.work_request.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CreateWorkRequestControllerTestBase {
	
	@InjectMocks
	CreateWorkRequestController createWorkRequestController;
	
	@Mock
	WorkRequestRepository workRequestRepository;
	@Mock
	UserEntityRepository userEntityRepository;
	@Mock
	AddressEntity addressEntity;
	@Mock
	AuthenticatedUserService authenticatedUserService;
	
	@BeforeEach
	void setUp() {
		
		WorkRequestEntityRepositoryStubs
				.behaviour(workRequestRepository);
		UserEntityRepositoryStubs.behaviour(userEntityRepository);
		
		AuthenticatedUserStubs.behaviour(authenticatedUserService);
	}
	
}
