package com.kodekonveyor.work_request;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;
import com.kodekonveyor.webapp.ValidationException;

@Controller
public class CustomerGetWorkRequestsController {

  @Autowired
  public WorkRequestRepository workRequestRepository;
  @Autowired
  public UserEntityRepository userEntityRepository;

  public WorkRequestListDTO call(final String ownerId) {
    inputValidation(ownerId);

    final Optional<UserEntity> user =
        userEntityRepository.findById(Long.parseLong(ownerId));
    if (user.isEmpty())
      throw new ValidationException(WorkRequestConstants.INVALID_OWNERID);

    final List<WorkRequestEntity> requests =
        workRequestRepository.findByCustomer(user.get());

    if (requests.isEmpty())
      throw new ValidationException(WorkRequestConstants.NO_WORKREQUESTS);

    final WorkRequestListDTO workRequestListDTO = new WorkRequestListDTO();

    final AddressDTO address = new AddressDTO();
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    for (final WorkRequestEntity workRequestEntity : requests) {

      workRequestDTO.setWorkType(workRequestEntity.getWorkType());

      workRequestDTO.setWorkRequestId(workRequestEntity.getId());
      address.setAddress(workRequestEntity.getAddress().getAddress());
      address.setCity(workRequestEntity.getAddress().getCity());
      address.setCountry(workRequestEntity.getAddress().getCountry());
      address.setId(workRequestEntity.getAddress().getId());
      workRequestDTO.setAddress(address);
      workRequestDTO.setDescription(workRequestEntity.getDescription());
      workRequestListDTO.getRequests().add(workRequestDTO);
    }

    return workRequestListDTO;
  }

  private void inputValidation(final String ownerId) {
    if (null == ownerId)
      throw new ValidationException(WorkRequestConstants.NULL_OWNERID);

    final char minusSign = '-';
    if (minusSign == ownerId.charAt(0))
      throw new ValidationException(WorkRequestConstants.NEGATIVE_OWNERID);

    if (!ownerId.matches("[0-9]+"))
      throw new ValidationException(WorkRequestConstants.ALPHACHAR_OWNERID);

  }

}
