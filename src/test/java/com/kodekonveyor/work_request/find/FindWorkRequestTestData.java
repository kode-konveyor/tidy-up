package com.kodekonveyor.work_request.find;

import java.util.List;

import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.work_request.AddressEntityTestData;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestEntityTestData;

public class FindWorkRequestTestData {

  public final static String NUll_WORKTYPE = null; //NOPMD
  public final static String VALID_WORKTYPE = "ELECTRICAL_REPAIRMENT"; //NOPMD
  public final static String INVALID_WORKTYPE = "XXXYYYZZZ";

  public final static String NUll_COUNTRY = null; //NOPMD
  public final static String VALID_COUNTRY = "in";
  public final static String INVALID_LARGE_COUNTRY = "XXXXXX";
  public final static String INVALID_COUNTRY = "X1";

  public final static String NUll_CITY = null; //NOPMD
  public final static String VALID_CITY = "Xyz";
  public final static String INVALID_CITY = "XX12345";

  public static WorkRequestEntity get() {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setCustomer(UserEntityTestData.get());
    workRequestEntity.setWorkType(WorkRequestEntityTestData.WORK_TYPE);
    workRequestEntity.setId(WorkRequestEntityTestData.WORK_REQUEST_ID);
    workRequestEntity.setDescription(WorkRequestEntityTestData.DESCRIPTION);
    workRequestEntity.setAddress(AddressEntityTestData.get());
    return workRequestEntity;
  }

  public static List<WorkRequestEntity> list() {
    return List.of(get());
  }
}
