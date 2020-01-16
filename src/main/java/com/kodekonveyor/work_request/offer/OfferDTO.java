package com.kodekonveyor.work_request.offer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data

public class OfferDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long price;
  private long workRequestId;
}
