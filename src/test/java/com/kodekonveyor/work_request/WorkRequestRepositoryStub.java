package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

import com.kodekonveyor.authentication.UserTestData;

public class WorkRequestRepositoryStub {

	public static void behaviour(final WorkRequestTestData workRequestTestData,
			final WorkRequestRepository workRequestRepository, final UserTestData userTestData) {

		doReturn(workRequestTestData.WORK_REQUEST_ENTITY_LIST).when(workRequestRepository)
				.findByCustomer(userTestData.USER);

	}

}