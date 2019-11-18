package com.kodekonveyor.work_request.create;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerTest {
	@InjectMocks
	private CreateWorkRequestController createWorkRequestController;
	@Mock
	private WorkRequestRepository workRequestRepository;
	@Mock
	private AuthenticatedUserService authenticatedUserService;
	private WorkRequestTestData workRequestTestData;

	@BeforeEach
	public void setUp() {
		final UserTestData userTestData = new UserTestData();
		workRequestTestData = new WorkRequestTestData(userTestData);
		AuthenticatedUserStubs.behaviour(authenticatedUserService, userTestData);
	}

	@Test
	@DisplayName("Controller creates WorkRequestEntity based on request")
	public void test() {
		createWorkRequestController.call(workRequestTestData.CREATE_WORK_REQUEST);
		verify(workRequestRepository).save(workRequestTestData.WORK_REQUEST_ENTITY);
	}

}
