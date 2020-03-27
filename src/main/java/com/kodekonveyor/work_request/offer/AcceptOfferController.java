package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@RestController
public class AcceptOfferController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @Autowired
  OfferEntityRepository offerEntityRepository;

  @PostMapping("/accept/{offerId}")
  public void call(final Long offerId) {
    final Optional<OfferEntity> offer = offerEntityRepository.findById(offerId);
    final UserEntity provider = authenticatedUserService.call();
    final WorkRequestEntity workRequest = offer.get().getWorkRequest();
    workRequest.setProvider(provider);
    workRequestRepository.save(workRequest);
  }

}
