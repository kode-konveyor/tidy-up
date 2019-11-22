package com.kodekonveyor.work_request.create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kodekonveyor.webapp.ValidationException;

public class CreateWorkRequestController {

	public void call(final CreateWorkRequestDTO createWorkRequestDTO) {
		checkCustomerId(createWorkRequestDTO);
		checkDescription(createWorkRequestDTO);
		checkWorkType(createWorkRequestDTO);
		CreateWorkRequestValidationHelper.checkAddress(createWorkRequestDTO);
		CreateWorkRequestValidationHelper.checkCity(createWorkRequestDTO);
		CreateWorkRequestValidationHelper.checkCountry(createWorkRequestDTO);
	}

	private void checkCustomerId(final CreateWorkRequestDTO createWorkRequestDTO) {
		final String customerId = createWorkRequestDTO.getCustomerId();
		if (customerId == null || customerId.isEmpty())
			throw new ValidationException(CreateConstants.INVALID_CUSTOMER_ID);
	}

	private void checkDescription(final CreateWorkRequestDTO createWorkRequestDTO) {
		final String description = createWorkRequestDTO.getDescription();
		if (description == null || description.isEmpty())
			throw new ValidationException(CreateConstants.INVALID_DESCRIPTION);
	}

	private void checkWorkType(final CreateWorkRequestDTO createWorkRequestDTO) {
		final List<WorkType> workTypes = new ArrayList<>(Arrays.asList(WorkType.values()));
		final String workType = createWorkRequestDTO.getWorkType();
		for (final WorkType work : workTypes) {
			final String name = work.name();
			if (name.equalsIgnoreCase(workType))
				return;
		}
		throw new ValidationException(CreateConstants.INVALID_WORK_TYPE);
	}

}
