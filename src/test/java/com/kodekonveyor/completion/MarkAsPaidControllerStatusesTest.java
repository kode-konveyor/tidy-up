package com.kodekonveyor.completion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MarkAsPaidControllerStatusesTest {

  @InjectMocks
  private MarkAsPaidController markAsPaidController;

  @Mock
  private WorkRequestRepository workRequestRepository;

  private final WorkRequestEntity workRequestEntityData =
      WorkRequestEntityTestData.get();

  private final ArgumentCaptor<WorkRequestEntity> argCaptor =
      ArgumentCaptor.forClass(WorkRequestEntity.class);

  @BeforeEach
  public void setUp() {
    doReturn(Optional.of(workRequestEntityData))
        .when(workRequestRepository)
        .findById(workRequestEntityData.getId());

  }

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
