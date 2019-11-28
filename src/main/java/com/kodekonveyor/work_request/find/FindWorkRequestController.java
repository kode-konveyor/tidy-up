package com.kodekonveyor.work_request.find;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestListDTO;
import com.kodekonveyor.work_request.WorkRequestRepository;
import com.kodekonveyor.work_request.WorkRequestUtil;
import com.kodekonveyor.work_request.WorkTypeEnum;

public class FindWorkRequestController {

  @Autowired
  private WorkRequestRepository workRequestRepository;

  public WorkRequestListDTO call(
      final String country, final String city,
      final String workType
  ) {
    final List<WorkRequestEntity> entities = workRequestRepository
        .findByTypeAndCountryAndCity(WorkTypeEnum.valueOf(workType),
            country, city
        );
    final WorkRequestListDTO dtoList = new WorkRequestListDTO();
    for (final WorkRequestEntity entity : entities) {
      final WorkRequestDTO dto = WorkRequestUtil
          .convertWorkRequestEntityToDTO(entity);
      dtoList.getRequests().add(dto);
    }
    return dtoList;
  }
}
