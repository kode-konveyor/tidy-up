
package com.kodekonveyor.work_request.offer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<OfferEntity, Long> {

  List<OfferEntity> findByOfferId(Long offerId);
}
