package com.kodekonveyor.work_request.revoke;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RevokeWorkRequestController {

  @GetMapping("/workRequest/@workRequestId")
  public void call(@RequestParam final long workRequestId) {
    WorkRequestIdValidationUtil.inputValidation(workRequestId);

  }

}
