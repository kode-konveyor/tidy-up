package com.kodekonveyor.completion;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

public class MarkAsPaidController {

  @Autowired
  private WorkRequestRepository repository;

  public void call(final Long id) {

    final WorkRequestEntity workRequest = repository.findById(id).get();
    if (!workRequest.getStatus().equals(WorkRequestStatusEnum.VERIFIED))
      throw new IllegalStateException();
    workRequest.setStatus(WorkRequestStatusEnum.PAID);
    repository.save(workRequest);

  }

}
