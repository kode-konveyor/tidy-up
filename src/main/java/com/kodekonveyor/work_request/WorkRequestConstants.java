package com.kodekonveyor.work_request;

public class WorkRequestConstants {

  public static String NULL_DESCRIPTION = "Blank Description";
  public static String NULL_WORKTYPE = "Blank Work Type";
  public static String ADDRESS_LENGHT_EXCEEDED = "Address Lenght Exceeded";
  public static String NO_WORKREQUESTS = "No Work Request";
  public static String NULL_OWNERID = "No OwnerId";
  public static String INVALID_OWNERID = "Invalid OwnerId";
  public static String NEGATIVE_OWNERID = "Negative Owner Id";
  public static String ALPHACHAR_OWNERID =
      "Contains Alphabet or Special Character";
  public static String LENGTHEXCEED_OWNERID = "Contains more than 4 digits";
  public static String NULL_ADDRESS = "Blank Address";
  public static String NULL_CUSTOMERID = "Blank Customer Id";
  public static String NULL_ADDRESS_STRING = "Blank Address Field";
  public static String NEGATIVE_CUSTOMERID = "Negative Customer Id";
  public static String ALPHACHAR_CUSTOMERID =
      "Customer Id contains Alphabet OR Special Characters";
  public static String LENGTH_CUSTOMERID =
      "Length of Customer Id cannot be more be 4 digit";
  public static String DIGIT_SPECIAL_CHARACTER_WORKTYPE =
      "Work Type contains digits or special characters";
  public static String INVALID_WORKTYPE = "Invalid Work Type";
  public static String NULL_CITY = "City cannot be empty";
  public static String NULL_COUNTRY = "Country cannot be empty";
  public static String COUNTRY_LENGTH =
      "Country cannot be more or less than 2 letter";
  public static String COUNTRY_ALPHABET =
      "Country can contain alphabetic characters/letters only";
  public static String ADDRESS_LENGTH =
      "Address can contains only 120 characters";
  public static String NON_POSITIVE_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be positive";
  public static String DECIMAL_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id should be an integer";
  public static final String WORK_REQUEST_IS_NOT_POSTED =
      "Work request is not posted";
  public static final String WORK_REQUEST_ERROR = "Work request error: {} {}";

  public static String CUSTOMER_ID_LENGTH_ERROR =
      "Customer ID should not be longer than 4 digit";
  public static String ZERO_WORK_REQUEST_ID_EXCEPTION =
      "Work Request Id cannot be zero";
  public static String ZERO_CUSTOMERID = "Customer Id cannot be zero";
  public static String ZERO_ADDRESS_LENGTH = "Address cannot be blank";
  public static String ADDRESS_MAX_LENGTH = "Address reached max limit";
  public static String INVALID_WORK_REQUEST_ID_EXCEPTION =
      "Invalid work request Id";
  public static String CITY_ALPHABET =
      "City can contain alphabetic characters/letters only";
  public static String INVALID_PRICE = "Invalid Price";
  public static String NEGATIVE_PRICE_EXCEPTION = "Price cannot be negative";

  public static final String UNAUTHORIZE_REVOKE_WORK_REQUEST =
      "You can only revoke your own work request";

  public static final String UNAUTHORIZE_GET_WORK_REQUESTS_FOR_USER =
          "You can only fetch your own work request";

  public static final String OWNER_ID_REGEX = "[0-9]+";
  public static final int MIN_PRICE = 1;
  public static final String SERVICE_CALL_NAME = "Service Call Name: {}";
  public static final String INPUT_VALIDATION = "Input Validation: {}";
  public static final String INPUT_VALIDATION_STATUS =
      "Input Validation Status: {} {}";
  public static final String SUCCESS = "SUCCESS";
  public static final String FIND_WORK_REQUEST =
      "Finding work request for ID: {}";
  public static final String FIND_WORK_REQUEST_BY_CUSTOMER =
          "Finding work request for owner : {}";
  public static final String FIND_WORK_REQUEST_BY_CUSTOMER_STATUS =
          "Finding work request for owner id {} status : {}";

  public static final String FIND_WORK_REQUEST_BY_CUSTOMER_API_CALL_STATUS =
          "API call for work request by owner id {} : {}";

  public static final String FIND_WORK_REQUEST_STATUS =
      "Work request found : {} {}";
  public static final String SAVE_OFFER = "Save offer with offer ID: {}";
  public static final String SAVE_OFFER_STATUS =
      "Save offer with offer ID: {} {}";
  public static final String FAILURE = "FAILURE";
  public static final String WORK_REQUEST_RECEIVED = "workrequest.received";
  public static final String OPEN_WORK_REQUEST = "Open work request: {}";
}
