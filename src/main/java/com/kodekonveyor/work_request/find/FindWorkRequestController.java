package com.kodekonveyor.work_request.find;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestListDTO;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestStatusEnum;
import com.kodekonveyor.work_request.WorkRequestUtil;
import com.kodekonveyor.work_request.WorkTypeEnum;
import com.kodekonveyor.work_request.create.CountryAndCityValidationUtil;

@RestController
public class FindWorkRequestController {

  @Autowired
  WorkRequestRepository workRequestRepository;

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @GetMapping("workRequest/{country}/{city}/{workType}")
  public WorkRequestListDTO call(
      final String country, final String city,
      final String workType
  ) {
    WorkTypeValidationUtil.validateWorkType(workType);
    CountryAndCityValidationUtil.validateCountry(country);

    CountryAndCityValidationUtil.validateCity(city);

    final UserEntity loginEntity = authenticatedUserService.call();
    final List<WorkRequestEntity> entities = workRequestRepository
        .findByTypeAndCountryAndCity(WorkTypeEnum.valueOf(workType),
            country, city
        );
    final WorkRequestListDTO dtoList = new WorkRequestListDTO();
    for (final WorkRequestEntity entity : entities)
      if (
        !entity.getStatus().equals(WorkRequestStatusEnum.POSTED) &&
            (!ObjectUtils.isEmpty(entity.getCustomer()) && entity.getCustomer().getLogin().equals(loginEntity.getLogin()) ||
                !ObjectUtils.isEmpty(entity.getProvider()) && entity.getProvider().getLogin().equals(loginEntity.getLogin()))
      ) {
        final WorkRequestDTO dto = WorkRequestUtil
            .convertWorkRequestEntityToDTO(entity);
        dtoList.getRequests().add(dto);
      }
    return dtoList;
  }
}
