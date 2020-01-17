package com.kodekonveyor.completion;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class MarkAsPaidControllerStatusesTestBase {

  @InjectMocks
  protected MarkAsPaidController markAsPaidController;
  @Mock
  protected WorkRequestRepository workRequestRepository;

  protected final WorkRequestEntity workRequestEntityData =
      WorkRequestEntityTestData.get();

  @BeforeEach
  public void setUp() {
    doReturn(Optional.of(workRequestEntityData))
        .when(workRequestRepository)
        .findById(workRequestEntityData.getId());

  }

}
