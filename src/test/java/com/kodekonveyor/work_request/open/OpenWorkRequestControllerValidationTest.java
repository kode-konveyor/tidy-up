package com.kodekonveyor.work_request.open;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.work_request.CustomerWorkRequestControllerTestBase;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("input validation")
@TestedService("OpenWorkRequestController")

class OpenWorkRequestControllerValidationTest extends CustomerWorkRequestControllerTestBase {

//	@InjectMocks
//	private OpenWorkRequestController openWorkRequestController;
//
//	@Test
//	@DisplayName("Work Request Id cannot be negative")
//	public void testWorkRequestNegativeId() {
//		ThrowableTester.assertThrows(() -> openWorkRequestController.call(workRequestTestData.NEGATIVE_WORK_REQUEST_ID))
//				.assertMessageIs(workRequestTestData.NEGATIVE_WORK_REQUEST_ID_EXCEPTION);

//	}

}
