package com.kodekonveyor.work_request.offer;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;

@RestController

public class AcceptOfferController {

  @Autowired
  OfferEntityRepository offerEntityRepository;
  @Autowired
  AuthenticatedUserService authenticatedUserService;
  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  Logger loggerService;

  @PutMapping("/accept/{offerId}")
  public WorkRequestDTO call(final long offerId) {

    loggerService.info(
        WorkRequestConstants.SERVICE_CALL_NAME, this.getClass().getName()
    );
    loggerService.info(WorkRequestConstants.FIND_OFFER, offerId);
    final OfferEntity offerEntity =
        offerEntityRepository.findById(offerId).get();
    loggerService.debug(
        WorkRequestConstants.FIND_OFFER_STATUS, offerEntity.getId(),
        WorkRequestConstants.SUCCESS
    );
    final WorkRequestEntity workRequest = offerEntity.getWorkRequest();
    loggerService.info(
        WorkRequestConstants.SET_WORK_REQUEST_ENUM, WorkRequestStatusEnum.AGREED
    );
    workRequest.setStatus(WorkRequestStatusEnum.AGREED);
    loggerService.debug(
        WorkRequestConstants.SET_WORK_REQUEST_ENUM_STATUS, workRequest,
        WorkRequestConstants.SUCCESS
    );
    loggerService.info(WorkRequestConstants.SAVE_WORK_REQUEST, workRequest);
    workRequestRepository.save(workRequest);

    final WorkRequestDTO workRequestDTO =
        getWorkRequestDTOStatusAgreed(workRequest);
    loggerService.debug(
        WorkRequestConstants.RETURN_WORK_REQUEST_DTO_STATUS, workRequestDTO,
        WorkRequestConstants.SUCCESS
    );
    return workRequestDTO;
  }

  private WorkRequestDTO
      getWorkRequestDTO(final WorkRequestEntity workRequest) {
    final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
    workRequestDTO
        .setDescription(workRequest.getDescription());
    workRequestDTO.setWorkRequestId(workRequest.getId());
    workRequestDTO.setWorkType(workRequest.getWorkType());

    final AddressDTO addressDTO = new AddressDTO();
    addressDTO
        .setAddress(workRequest.getAddress().getAddress());
    addressDTO.setCity(workRequest.getAddress().getCity());
    addressDTO.setId(workRequest.getAddress().getId());
    addressDTO
        .setCountry(workRequest.getAddress().getCountry());
    workRequestDTO.setAddress(addressDTO);
    return workRequestDTO;
  }

  private WorkRequestDTO
      getWorkRequestDTOStatusAgreed(final WorkRequestEntity workRequest) {
    final WorkRequestDTO workRequestDTO = getWorkRequestDTO(workRequest);
    workRequestDTO.setStatus(workRequest.getStatus());
    workRequestDTO.setProvider(workRequest.getProvider());
    loggerService
        .info(WorkRequestConstants.RETURN_WORK_REQUEST_DTO, workRequestDTO);
    return workRequestDTO;
  }

}
