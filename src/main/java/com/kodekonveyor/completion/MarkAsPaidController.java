package com.kodekonveyor.completion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@Controller
public class MarkAsPaidController {

  @Autowired
  WorkRequestRepository repository;

  @PutMapping("/paid/{workRequestId}")
  public void call(@PathVariable("workRequestId") final Long workRequestId) {

    final WorkRequestEntity workRequest =
        repository.findById(workRequestId).get();
    if (!workRequest.getStatus().equals(WorkRequestStatusEnum.VERIFIED))
      throw new IllegalStateException();
    workRequest.setStatus(WorkRequestStatusEnum.PAID);
    repository.save(workRequest);

  }

}
