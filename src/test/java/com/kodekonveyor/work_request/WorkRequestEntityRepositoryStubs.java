package com.kodekonveyor.work_request;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.kodekonveyor.authentication.UserEntityTestData;

public abstract class WorkRequestEntityRepositoryStubs {

  public static void behaviour(
      final WorkRequestRepository workRequestRepository
  ) {

    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByCustomer(UserEntityTestData.get());
    doReturn(List.of(WorkRequestEntityTestData.get()))
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByWorkRequestId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    doReturn(WorkRequestEntityTestData.list())
        .when(workRequestRepository)
        .findByTypeAndCountryAndCity(
            WorkTypeEnum.CLEANING, AddressEntityTestData.COUNTRY,
            AddressEntityTestData.CITY
        );

  }

  public static void behaviourCustomer(
      final WorkRequestRepository workRequestRepository
  ) {

    doReturn(WorkRequestEntityTestData.listCustomer())
        .when(workRequestRepository)
        .findByTypeAndCountryAndCity(
            WorkTypeEnum.CLEANING, AddressEntityTestData.COUNTRY,
            AddressEntityTestData.CITY
        );

  }

  public static void behaviourInvalid(
      final WorkRequestRepository workRequestRepository
  ) {

    doReturn(WorkRequestEntityTestData.listInvalid())
        .when(workRequestRepository)
        .findByTypeAndCountryAndCity(
            WorkTypeEnum.CLEANING, AddressEntityTestData.COUNTRY,
            AddressEntityTestData.CITY
        );

  }

}
