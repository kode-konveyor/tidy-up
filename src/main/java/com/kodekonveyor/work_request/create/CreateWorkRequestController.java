package com.kodekonveyor.work_request.create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.AddressEntity;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

public class CreateWorkRequestController {

  @Autowired
  private AuthenticatedUserService authenticatedUserService;

  @Autowired
  private WorkRequestRepository workRequestRepository;

  @PostMapping("/work-request")
  public void call(final CreateWorkRequestDTO createWorkRequestDTO) {
    checkCustomerId(createWorkRequestDTO);
    checkDescription(createWorkRequestDTO);
    checkWorkType(createWorkRequestDTO);
    CreateWorkRequestValidationHelper.checkAddress(createWorkRequestDTO);
    CreateWorkRequestValidationHelper.checkCity(createWorkRequestDTO);
    CreateWorkRequestValidationHelper.checkCountry(createWorkRequestDTO);
    final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
    workRequestEntity.setWorkType(createWorkRequestDTO.getWorkType());
    final UserEntity userEntity = authenticatedUserService.call();
    final AddressEntity addressEntity = new AddressEntity();
    addressEntity.setAddress(createWorkRequestDTO.getAddress().getAddress());
    addressEntity.setCity(createWorkRequestDTO.getAddress().getCity());
    addressEntity.setCountry(createWorkRequestDTO.getAddress().getCountry());
    workRequestEntity.setCustomer(userEntity);
    workRequestEntity
        .setId(createWorkRequestDTO.getCustomerId());
    workRequestEntity.setDescription(createWorkRequestDTO.getDescription());
    workRequestEntity.setAddress(addressEntity);

    workRequestRepository.save(workRequestEntity);
  }

  private void
      checkCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {
    final long customerId = createWorkRequestDTO.getCustomerId();
    if (customerId < 0)
      throw new ValidationException(CreateConstants.INVALID_CUSTOMER_ID);

  }

  /*private void
      checkCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {
    final String customerId = createWorkRequestDTO.getCustomerId();
    if (customerId == null || customerId.isEmpty())
      throw new ValidationException(CreateConstants.INVALID_CUSTOMER_ID);
  
  }*/

  private void
      checkDescription(final CreateWorkRequestDTO createWorkRequestDTO) {
    final String description = createWorkRequestDTO.getDescription();
    if (description == null || description.isEmpty())
      throw new ValidationException(CreateConstants.INVALID_DESCRIPTION);
  }

  private void checkWorkType(final CreateWorkRequestDTO createWorkRequestDTO) {
    final List<WorkType> workTypes =
        new ArrayList<>(Arrays.asList(WorkType.values()));
    final String workType = createWorkRequestDTO.getWorkType();
    for (final WorkType work : workTypes) {
      final String name = work.name();
      if (name.equalsIgnoreCase(workType))
        return;
    }
    throw new ValidationException(CreateConstants.INVALID_WORK_TYPE);
  }

}
