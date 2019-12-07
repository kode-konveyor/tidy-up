
package com.kodekonveyor.work_request.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkTypeEnum;

@Controller
public class CreateWorkRequestController { //NOPMD

  @Autowired
  public WorkRequestRepository workRequestRepository;
  @Autowired
  public UserEntityRepository userEntityRepository;
  @Autowired
  public AuthenticatedUserService authenticatedUserService;
  @Autowired
  public WorkTypeEnum workTypeEnum;

  @PostMapping("/work-request")
  public void
      call(@RequestBody final CreateWorkRequestDTO createWorkRequestDTO) {

    validateWorkType(createWorkRequestDTO);
    validateDescrption(createWorkRequestDTO);
    validateCustomerId(createWorkRequestDTO);
    validateAddressDetails(createWorkRequestDTO);

    validateCityAndCountry(createWorkRequestDTO);
    createWorkRequest(createWorkRequestDTO);

  }

  private void createWorkRequest(
      final CreateWorkRequestDTO createWorkRequestDTO
  ) {
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setWorkType(createWorkRequestDTO.getWorkType());
    final UserEntity userEntity = authenticatedUserService.call();
    final AddressEntity addressEntity = new AddressEntity();
    addressEntity.setId(createWorkRequestDTO.getCustomerId());
    addressEntity.setAddress(createWorkRequestDTO.getAddress().getAddress());
    addressEntity.setCity(createWorkRequestDTO.getAddress().getCity());
    addressEntity.setCountry(createWorkRequestDTO.getAddress().getCountry());
    workRequestEntity.setCustomer(userEntity);
    workRequestEntity.setId(createWorkRequestDTO.getCustomerId());
    workRequestEntity.setDescription(createWorkRequestDTO.getDescription());
    workRequestEntity.setAddress(addressEntity);
    workRequestRepository.save(workRequestEntity);

  }

  private void
      validateWorkType(final CreateWorkRequestDTO createWorkRequestDTO) {
    if (null == createWorkRequestDTO.getCustomerId())
      throw new ValidationException(WorkRequestConstants.NULL_CUSTOMERID);

    if (null == createWorkRequestDTO.getWorkType())
      throw new ValidationException(WorkRequestConstants.NULL_WORKTYPE);

    if (!createWorkRequestDTO.getWorkType().matches("^[a-zA-Z]*$"))
      throw new ValidationException(
          WorkRequestConstants.DIGIT_SPECIAL_CHARACTER_WORKTYPE
      );

    //    WorkTypeEnum.values();
    //
    //    if (WorkTypeEnum.values() != null)
    //      throw new ValidationException(WorkRequestConstants.INVALID_WORKTYPE);
  }

  private void
      validateDescrption(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getDescription())
      throw new ValidationException(WorkRequestConstants.NULL_DESCRIPTION);

  }

  //	public void validateAddress(final CreateWorkRequestDTO createWorkRequestDTO) {
  //		if (null == createWorkRequestDTO.getAddress())
  //			throw new ValidationException(WorkRequestConstants.NULL_ADDRESS);
  //	}

  private void
      validateAddressDetails(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getAddress())
      throw new ValidationException(WorkRequestConstants.NULL_ADDRESS_STRING);

    final int charLimit = 120;
    if (createWorkRequestDTO.getAddress().getAddress().length() > charLimit)
      throw new ValidationException(WorkRequestConstants.ADDRESS_LENGTH);

  }

  private void
      validateCityAndCountry(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (null == createWorkRequestDTO.getAddress().getCity())
      throw new ValidationException(WorkRequestConstants.NULL_CITY);

    if (null == createWorkRequestDTO.getAddress().getCountry())
      throw new ValidationException(WorkRequestConstants.NULL_COUNTRY);

    final int length = 2;
    if (createWorkRequestDTO.getAddress().getCountry().length() != length)
      throw new ValidationException(WorkRequestConstants.COUNTRY_LENGTH);

    if (!createWorkRequestDTO.getAddress().getCountry().matches("^[a-z]*$"))
      throw new ValidationException(WorkRequestConstants.COUNTRY_ALPHABET);

  }

  private void
      validateCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {

    if (createWorkRequestDTO.getCustomerId() < 0)
      throw new ValidationException(WorkRequestConstants.NEGATIVE_CUSTOMERID);

  }

}
