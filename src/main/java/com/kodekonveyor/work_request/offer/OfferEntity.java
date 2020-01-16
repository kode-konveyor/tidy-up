package com.kodekonveyor.work_request.offer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kodekonveyor.work_request.WorkRequestEntity;

import lombok.Data;

@Entity
@Data
public class OfferEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long price;
  private WorkRequestEntity workRequest;

}
