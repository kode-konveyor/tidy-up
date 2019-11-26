package com.kodekonveyor.work_request.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodekonveyor.webapp.ValidationException;
import com.kodekonveyor.work_request.AddressDTO;
import com.kodekonveyor.work_request.WorkRequestConstants;
import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class OpenWorkRequestController {

	@Autowired
	private WorkRequestRepository workRequestRepository;

	@GetMapping("workRequest/own/@workRequestId")
	public WorkRequestDTO call(@RequestParam final long workRequestId) {
		inputValidation(workRequestId);

		final WorkRequestEntity workRequestEntity = workRequestRepository.findByWorkRequestId(workRequestId).get(0);
		final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
		workRequestDTO.setWorkRequestId(workRequestEntity.getId());
		workRequestDTO.setWorkType(workRequestEntity.getWorkType());
		final AddressDTO address = new AddressDTO();
		address.setAddress(workRequestEntity.getAddress().getAddress());
		address.setCity(workRequestEntity.getAddress().getCity());
		address.setCountry(workRequestEntity.getAddress().getCountry());
		workRequestDTO.setAddress(address);
		workRequestDTO.setDescription(workRequestEntity.getDescription());

		return workRequestDTO;
	}

	public void inputValidation(final long workRequestId) {
		if (workRequestId < 1)
			throw new ValidationException(WorkRequestConstants.NEGATIVE_WORK_REQUEST_ID_EXCEPTION);

	}

}
