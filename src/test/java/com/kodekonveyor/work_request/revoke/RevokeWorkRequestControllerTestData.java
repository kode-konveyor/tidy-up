package com.kodekonveyor.work_request.revoke;

public class RevokeWorkRequestControllerTestData {

  public static final String NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be positive";
  public static final String INVALID_WORK_REQUEST_ID_EXCEPTION =
      "Invalid work request Id";
  public static final String WORK_REQUEST_ACCESS_EXCEPTION =
      "You can only revoke your own work request";
  public static final String SUCCESS = "SUCCESS";
  public static final String FAILURE = "FAILURE";
  public static final String INPUT_VALIDATION = "InputValidation: {}";
  public static final String FIND_WORK_REQUEST_ENTITY =
      "FindWorkRequestEntityById: {}";
  public static final String SERVICE_CALL_NAME = "Service Call Name: {}";
  public static final String AUTHENTICATION = "Authentication: {}";
  public static final String GET_CUSTOMER = "GetCustomer: {}";

}
