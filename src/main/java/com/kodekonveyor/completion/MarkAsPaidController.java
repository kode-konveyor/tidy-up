package com.kodekonveyor.completion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@Controller
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
