package com.kodekonveyor.work_request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CustomerGetWorkRequestsController")

public class CustomerGetWorkRequestsControllerTest extends CustomerWorkRequestControllerTestBase {

	@Test
	@DisplayName("We return the right work request list for the owner ID")
	public void testWorkRequestDetails() {
		assertEquals(workRequestTestData.WORK_REQUEST_LIST_DTO,
				customerGetWorkRequestsController.call(workRequestTestData.OWNER_ID));
	}

	@Test
	@DisplayName("When no request for Owner, the message is 'No work Requests'")
	public void testWorkRequestDetailsNotPresent() {
//		WorkRequestRepositoryStub.behaviour(workRequestRepository, workRequestTestData);
		ThrowableTester
				.assertThrows(() -> customerGetWorkRequestsController.call(workRequestTestData.NO_WORKREQUESTS_ID))
				.assertMessageIs(workRequestTestData.NO_WORKREQUESTS);
	}
}
