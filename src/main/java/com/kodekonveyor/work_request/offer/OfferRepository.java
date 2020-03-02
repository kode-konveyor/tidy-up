package com.kodekonveyor.work_request.offer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<OfferEntity, Long> {

  Optional<OfferEntity> findById(long OfferId);

}
