package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.WorkRequestDTO;

@RestController
public class AcceptOfferController {

  @Autowired
  private OfferEntityRepository offerEntityRepository;

  @Autowired
  private AuthenticatedUserService authenticatedUserService;

  @PutMapping("/accept/{offerId}")
  public WorkRequestDTO call(@PathVariable("offerId") final long offerId) {

    final Optional<OfferEntity> offer = offerEntityRepository.findById(offerId);

    final UserEntity user = authenticatedUserService.call();

    if (!offer.get().getWorkRequest().getCustomer().equals(user))
      throw new ValidationException(
          "user is not authorized to accept this offer"
      );
    return null;
  }
}
