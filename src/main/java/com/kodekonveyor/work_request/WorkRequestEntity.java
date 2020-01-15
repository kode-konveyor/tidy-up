package com.kodekonveyor.work_request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kodekonveyor.authentication.UserEntity;

import lombok.Data;

@Entity
@Data
public class WorkRequestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private StatusEnum status;
  private String workType;
  private AddressEntity address;
  private UserEntity customer;
  private boolean isActive;
  private UserEntity provider;
}
