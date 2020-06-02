package com.kodekonveyor.completion;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.work_request.WorkRequestEntityRepositoryStubs;
import com.kodekonveyor.work_request.WorkRequestRepository;
import org.slf4j.Logger;

public class MarkCompletionControllerTestBase {

  @InjectMocks
  MarkCompletionController markCompletionController;
  @Mock
  WorkRequestRepository workRequestRepository;
  @Mock
  Logger loggerService;
  @Captor
  ArgumentCaptor<String> captorString;
  @BeforeEach
  void setUp() {
    WorkRequestEntityRepositoryStubs.agreedWorkRequest(workRequestRepository);

  }

}
