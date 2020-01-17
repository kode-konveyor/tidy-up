package com.kodekonveyor.work_request.offer;

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
@TestedBehaviour("compile output")
@TestedService("GiveofferController")

public class GiveofferControllerCompileOutputTest
    extends GiveofferControllerTestBase

{

  @Test
  @DisplayName("the controller returns an OfferDTO")
  public void test() {

    final OfferDTO offerDTO = OfferDTOTestData.get();
    final OfferEntity offerEntity = OfferEntityTestData.get();
    assertEquals(offerEntity, giveofferController.call(offerDTO));
  }

}
