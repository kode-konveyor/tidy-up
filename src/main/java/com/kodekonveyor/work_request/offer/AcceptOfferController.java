package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
  OfferRepository offerRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  public void call(final Long offerId) {
    System.out.println(offerId);
    final Optional<OfferEntity> optionalOfferEntity =
        offerRepository.findById(offerId);
    System.out.println(optionalOfferEntity);
    final OfferEntity offerEntity = optionalOfferEntity.get();
    final WorkRequestEntity workRequestEntity = offerEntity.getWorkRequest();
    final UserEntity userEntity = authenticatedUserService.call();
    workRequestEntity.setProvider(userEntity);
    workRequestRepository.save(workRequestEntity);
  }

}
