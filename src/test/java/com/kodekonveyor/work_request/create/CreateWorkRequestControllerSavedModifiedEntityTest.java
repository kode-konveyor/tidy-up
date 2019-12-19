package com.kodekonveyor.work_request.create;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.work_request.WorkRequestEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Save the new/modified entities")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerSavedModifiedEntityTest extends CreateWorkRequestControllerTestBase {

	@Override
	@BeforeEach
	void setUp() {
		super.setUp();
		createWorkRequestController.call(createWorkRequestTestData.CREATE_WORK_REQUEST);
	}

	@Test
	@DisplayName("given work request is saved correctly")
	public void test1() {
		verify(workRequestRepository).save(workRequestTestData.WORK_REQUEST_ENTITY);
	}

	@Test
	@DisplayName("for any given work request save method is invoked one time")
	public void test2() {
		verify(workRequestRepository, Mockito.times(1)).save(Mockito.any(WorkRequestEntity.class));
	}
}
