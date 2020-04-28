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
@TestedBehaviour("accepted behaviour")
@TestedService("AcceptOfferController")
public class AcceptOfferControllerAcceptedOfferTest
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
  @DisplayName("Work request provider returned successfully")
  public void test1() {
    assertEquals(
        workRequestDTOTestData.getProvider(),
        workRequestDTO.getProvider()
    );
  }

}
