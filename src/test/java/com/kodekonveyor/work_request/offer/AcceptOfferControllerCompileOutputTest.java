package com.kodekonveyor.work_request.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestDTOTestData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("compile output")
@TestedService("AcceptOfferController")
public class AcceptOfferControllerCompileOutputTest
    extends AcceptOfferControllerTestBase {

  private WorkRequestDTO workRequestDTOTestData;
  private WorkRequestDTO workRequestDTO;

  @BeforeEach
  public void setUpTest() {
    workRequestDTOTestData =
        WorkRequestDTOTestData.getStatusAgreedAndProvider();
    workRequestDTO = acceptOfferController.call(OfferDTOTestData.get().getId());
  }

  @Test
  @DisplayName("Work Request returned successfully")
  public void test1() {
    assertEquals(
        workRequestDTOTestData,
        workRequestDTO
    );
  }

  @Test
  @DisplayName("Work Request ID returned successfully")
  public void test2() {

    assertEquals(
        workRequestDTOTestData.getWorkRequestId(),
        workRequestDTO.getWorkRequestId()
    );
  }

  @Test
  @DisplayName("Work Request description returned successfully")
  public void test3() {

    assertEquals(
        workRequestDTOTestData.getDescription(),
        workRequestDTO.getDescription()
    );
  }

  @Test
  @DisplayName("Work request status returned successfully")
  public void test4() {

    assertEquals(
        workRequestDTOTestData.getStatus(),
        workRequestDTO.getStatus()
    );
  }

  @Test
  @DisplayName("Work request type returned successfully")
  public void test5() {

    assertEquals(
        workRequestDTOTestData.getWorkType(),
        workRequestDTO.getWorkType()
    );
  }

  @Test
  @DisplayName("Work request address returned successfully")
  public void test6() {

    assertEquals(
        workRequestDTOTestData.getAddress(),
        workRequestDTO.getAddress()
    );
  }
}
