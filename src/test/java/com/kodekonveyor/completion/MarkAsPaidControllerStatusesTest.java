package com.kodekonveyor.completion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MarkAsPaidControllerStatusesTest extends MarkAsPaidControllerStatusesTestBase {

  private final ArgumentCaptor<WorkRequestEntity> argCaptor =
      ArgumentCaptor.forClass(WorkRequestEntity.class);

  @Test
  public void markAsPaidStatusPositiveTest() {

    workRequestEntityData.setStatus(WorkRequestStatusEnum.VERIFIED);
    markAsPaidController.call(workRequestEntityData.getId());
    Mockito.verify(workRequestRepository).save(argCaptor.capture());
    assertEquals(WorkRequestStatusEnum.PAID, argCaptor.getValue().getStatus());

  }

  @Test
  public void markAsPaidStatusNegativeTest() {
    workRequestEntityData.setStatus(WorkRequestStatusEnum.AGREED);

    assertThrows(
        IllegalStateException.class,
        () -> markAsPaidController.call(workRequestEntityData.getId())
    );
  }

}
