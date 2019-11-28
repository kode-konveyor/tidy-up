package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestDTO;

public class WorkRequestTestData {// NOPMD

  public final UserTestData userTestData;
  public final String OWNER_ID = "4242";
  public final String WORK_TYPE = "CLEANING";
  public final Long WORK_REQUEST_ID = (long) 42;
  public final WorkRequestDTO WORK_REQUEST_DTO;
  public final WorkRequestListDTO WORK_REQUEST_LIST_DTO;
  public final String DESCRIPTION = "Clean up the mess";
  public final boolean IS_ACTIVE = true;
  public final WorkRequestEntity WORK_REQUEST_ENTITY;
  public List<WorkRequestEntity> WORK_REQUEST_ENTITY_LIST;
  public final String NULL_OWNERID = "No OwnerId";
  public final AddressTestData addressTestData;
  public final CreateWorkRequestDTO CREATE_WORK_REQUEST;
  //public final CreateWorkRequestDTO CREATE_REQUEST_DTO;
  public final Long BAD_CUSTOMER_ID = -1L;
  //public final String NULL_CUSTOMER_ID = null;
  public final String BAD_WORK_TYPE = "ENGINEERING";
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID;
  //public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_NULL_CUSTOMER_ID;
  public final AddressDTO ADDRESS;
  public final AddressDTO BAD_ADDRESS;
  public final AddressDTO NULL_ADDRESS;
  public final AddressDTO BAD_CITY;
  public final AddressDTO NULL_CITY;
  public final AddressDTO BAD_COUNTRY;
  public final AddressDTO NULL_COUNTRY;
  public final String BAD_DESCRIPTION = "";
  public final String NULL_DESCRIPTION = null;
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_WORKTYPE;
  public final String INVALID_WORK_TYPE = "Invalid work type";
  public final String INVALID_CUSTOMER_ID = "Invalid customer id";
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION;
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_NULL_DESCRIPTION;
  public final String INVALID_DESCRIPTION = "Invalid description";
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_ADDRESS;
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_NULL_ADDRESS;
  public final String INVALID_ADDRESS = "Invalid address";
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_CITY;
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_NULL_CITY;
  public final String INVALID_CITY = "Invalid city";
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_COUNTRY;
  public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_NULL_COUNTRY;
  public final String INVALID_COUNTRY = "Invalid country";

  public WorkRequestTestData(
      final UserTestData userTestData, final AddressTestData addressTestData
  ) {
    this.userTestData = userTestData;
    this.addressTestData = addressTestData;
    WORK_REQUEST_ENTITY = createWORK_REQUEST_ENTITY();
    /* WORK_REQUEST_ENTITY.setCustomer(userTestData.USER);
    WORK_REQUEST_ENTITY.setWorkType(WORK_TYPE);
    WORK_REQUEST_ENTITY.setId(WORK_REQUEST_ID);*/
    WORK_REQUEST_DTO = createWORK_REQUEST_DTO();
    /* WORK_REQUEST_DTO = new WorkRequestDTO();
    WORK_REQUEST_DTO.setWorkRequestId(WORK_REQUEST_ID);
    WORK_REQUEST_DTO.setWorkType(WORK_TYPE);*/
    WORK_REQUEST_LIST_DTO = new WorkRequestListDTO();
    WORK_REQUEST_LIST_DTO.setRequests(List.of(WORK_REQUEST_DTO));
    WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);
    //CREATE_REQUEST_DTO = createCREATE_REQUEST_DTO();
    CREATE_WORK_REQUEST = createCREATE_WORK_REQUEST();
    ADDRESS = new AddressDTO();
    ADDRESS.setId(WORK_REQUEST_ID);
    ADDRESS.setAddress("address");// NOPMD
    ADDRESS.setCity("city");// NOPMD
    ADDRESS.setCountry("country");// NOPMD

    CREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID =
        createCREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID();

    CREATE_REQUEST_DTO_WITH_BAD_WORKTYPE =
        createCREATE_REQUEST_DTO_WITH_BAD_WORKTYPE();
    CREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION =
        createCREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION();
    CREATE_REQUEST_DTO_WITH_NULL_DESCRIPTION =
        createCREATE_REQUEST_DTO_WITH_NULL_DESCRIPTION();
    BAD_ADDRESS = new AddressDTO();
    BAD_ADDRESS.setId(WORK_REQUEST_ID);
    BAD_ADDRESS.setAddress("");
    BAD_ADDRESS.setCity("city");// NOPMD
    BAD_ADDRESS.setCountry("country");
    NULL_ADDRESS = new AddressDTO();
    NULL_ADDRESS.setId(WORK_REQUEST_ID);
    NULL_ADDRESS.setAddress(null);
    NULL_ADDRESS.setCity("city");
    NULL_ADDRESS.setCountry("country");
    BAD_CITY = new AddressDTO();
    BAD_CITY.setId(WORK_REQUEST_ID);
    BAD_CITY.setAddress("address");// NOPMD
    BAD_CITY.setCity("");
    NULL_CITY = new AddressDTO();
    NULL_CITY.setId(WORK_REQUEST_ID);
    NULL_CITY.setAddress("address");
    NULL_CITY.setCity(null);
    NULL_CITY.setCountry("country");
    BAD_COUNTRY = new AddressDTO();
    BAD_COUNTRY.setId(WORK_REQUEST_ID);
    BAD_COUNTRY.setAddress("address");
    BAD_COUNTRY.setCity("city");
    BAD_COUNTRY.setCountry("");
    NULL_COUNTRY = new AddressDTO();
    NULL_COUNTRY.setId(WORK_REQUEST_ID);
    NULL_COUNTRY.setAddress("address");
    NULL_COUNTRY.setCity("city");
    NULL_COUNTRY.setCountry(null);
    CREATE_REQUEST_DTO_WITH_BAD_ADDRESS =
        createCREATE_REQUEST_DTO_WITH_BAD_ADDRESS(BAD_ADDRESS);
    CREATE_REQUEST_DTO_WITH_NULL_ADDRESS =
        createCREATE_REQUEST_DTO_WITH_BAD_ADDRESS(NULL_ADDRESS);
    CREATE_REQUEST_DTO_WITH_BAD_CITY =
        createCREATE_REQUEST_DTO_WITH_BAD_CITY(BAD_CITY);
    CREATE_REQUEST_DTO_WITH_NULL_CITY =
        createCREATE_REQUEST_DTO_WITH_BAD_CITY(NULL_CITY);
    CREATE_REQUEST_DTO_WITH_BAD_COUNTRY =
        createCREATE_REQUEST_DTO_WITH_BAD_COUNTRY(BAD_COUNTRY);
    CREATE_REQUEST_DTO_WITH_NULL_COUNTRY =
        createCREATE_REQUEST_DTO_WITH_BAD_COUNTRY(NULL_COUNTRY);
  }

  private CreateWorkRequestDTO
      createCREATE_REQUEST_DTO_WITH_BAD_ADDRESS(final AddressDTO address) {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setAddress(address);
    return createWorkRequestDTO;
  }

  private CreateWorkRequestDTO
      createCREATE_REQUEST_DTO_WITH_BAD_CITY(final AddressDTO address) {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setAddress(address);
    return createWorkRequestDTO;
  }

  private CreateWorkRequestDTO
      createCREATE_REQUEST_DTO_WITH_BAD_COUNTRY(final AddressDTO address) {

    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setAddress(address);
    return createWorkRequestDTO;
  }

  /*private CreateWorkRequestDTO createCREATE_REQUEST_DTO() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        new CreateWorkRequestDTO();
    createWorkRequestDTO.setCustomerId(OWNER_ID);
    createWorkRequestDTO.setWorkType(WORK_TYPE);
    createWorkRequestDTO.setDescription(DESCRIPTION);
    createWorkRequestDTO.setAddress(ADDRESS);
    return createWorkRequestDTO;
  }
  */
  private CreateWorkRequestDTO createCREATE_WORK_REQUEST() {
    final CreateWorkRequestDTO createWorkRequest = new CreateWorkRequestDTO();
    createWorkRequest.setCustomerId(WORK_REQUEST_ID);
    createWorkRequest.setWorkType(WORK_TYPE);
    createWorkRequest.setDescription(DESCRIPTION);
    createWorkRequest.setAddress(addressTestData.ADDRESS_DTO);
    return createWorkRequest;
  }

  private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setCustomerId(BAD_CUSTOMER_ID);
    return createWorkRequestDTO;
  }

  /* private CreateWorkRequestDTO
      createCREATE_REQUEST_DTO_WITH_NULL_CUSTOMER_ID() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setCustomerId(NULL_CUSTOMER_ID);
    return createWorkRequestDTO;
  }*/

  private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_WORKTYPE() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setWorkType(BAD_WORK_TYPE);
    return createWorkRequestDTO;
  }

  private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setDescription(BAD_DESCRIPTION);
    return createWorkRequestDTO;
  }

  private CreateWorkRequestDTO
      createCREATE_REQUEST_DTO_WITH_NULL_DESCRIPTION() {
    final CreateWorkRequestDTO createWorkRequestDTO =
        createCREATE_WORK_REQUEST();
    createWorkRequestDTO.setDescription(NULL_DESCRIPTION);
    return createWorkRequestDTO;
  }

  private WorkRequestEntity createWORK_REQUEST_ENTITY() {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setCustomer(userTestData.USER);
    workRequestEntity.setWorkType(WORK_TYPE);
    workRequestEntity.setId(WORK_REQUEST_ID);
    workRequestEntity.setDescription(DESCRIPTION);
    workRequestEntity.setAddress(addressTestData.ADDRESS_ENTITY);
    return workRequestEntity;
  }

  private WorkRequestDTO createWORK_REQUEST_DTO() {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO.setWorkRequestId(WORK_REQUEST_ID);
    workRequestDTO.setWorkType(WORK_TYPE);
    workRequestDTO.setDescription(DESCRIPTION);
    return workRequestDTO;
  }
}
