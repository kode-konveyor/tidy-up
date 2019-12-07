package com.kodekonveyor.work_request.create;

import static org.junit.Assert.assertEquals;

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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("CreateWorkRequestController")
public class CreateWorkRequestControllerTest
    extends CreateWorkRequestControllerTestBase {

  @Test
  @DisplayName("Controller files address of WorkRequestEntity based on request")
  public void test4() {
    assertEquals(
        workRequestTestData.addressTestData.ADDRESS_ENTITY,
        workRequestTestData.WORK_REQUEST_ENTITY.getAddress()
    );
  }

  @Test
  @DisplayName(
    "Controller files customer of WorkRequestEntity based on request"
  )
  public void test3() {
    assertEquals(
        workRequestTestData.userTestData.USER,
        workRequestTestData.WORK_REQUEST_ENTITY.getCustomer()
    );

  }

}
