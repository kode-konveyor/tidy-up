package com.kodekonveyor.work_request;

import java.util.ArrayList;
import java.util.List;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestDTO;

public class WorkRequestTestData { // NOPMD
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_WORKTYPE;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_DESCRIPTION;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_ADDRESS;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_CUSTOMERID;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_ADDRESS_STRING;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_COUNTRY;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NULL_CITY;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_INVALID_WORKTYPE;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_COUNTRY_LENGTH;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_COUNTRY_ALPHABET;
	public final CreateWorkRequestDTO CREATE_WORK_REQUEST_ADDRESS_LENGTH;

	public final WorkRequestDTO WORK_REQUEST_DTO;
	public WorkRequestListDTO WORK_REQUEST_LIST_DTO;
	public final WorkRequestEntity WORK_REQUEST_ENTITY;
	public List<WorkRequestEntity> WORK_REQUEST_ENTITY_LIST;
	public final List<Object> EMPTY_LIST = new ArrayList<>();

	public final String NULL_DESCRIPTION = "Blank Description";
	public final String NULL_WORKTYPE = "Blank Work Type";
	public final String OWNER_ID = "4242";
	public final String WORK_TYPE = "CLEANING";
	public final Long WORK_REQUEST_ID = (long) 4242;
	public final String DESCRIPTION = "Clean up the mess";
	public final boolean IS_ACTIVE = true;
	public final String INVALID_OWNERID = "Invalid OwnerId";
	public final String NO_WORKREQUESTS = "No Work Request";
	public final String NEGATIVE_OWNERID = "Negative Owner Id";
	public final String NEGATIVE_OWNERID_ID = "-4536";
	public final String INVALID_OWNERID_ID = "4245";
	public final String NO_WORKREQUESTS_ID = "4243";
	public final String ALPHACHAR_OWNERID = "Contains Alphabet or Special Character";
	public final String ALPHACHAR_OWNERID_ID = "34g&";
	public final String LENGTHEXCEED_OWNERID = "Contains more than 4 digits";
	public final String LENGTHEXCEED_OWNERID_ID = "4356734";
	public final Long CUSTOMER_ID = (long) 4242;
	public final Long NEGATIVE_CUSTOMER_ID = (long) -4242;
	public final String NULL_OWNERID = "No OwnerId";
	public final String NULL_ADDRESS = "Blank Address";
	public final String NULL_CUSTOMERID = "Blank Customer Id";
	public final String NULL_ADDRESS_STRING = "Blank Address Field";
	public final String NEGATIVE_CUSTOMERID_ERROR_MESSAGE = "Negative Customer Id";
	public final String LENGTH_CUSTOMERID = "Length of Customer Id cannot be more be 4 digit";
	public final String DIGIT_SPECIAL_CHARACTER_WORKTYPE_ERROR = "Work Type contains digits or special characters";
	public final String WORK_TYPE_DIGIT_SPECIAL = "456$%$";
	public final String INVALID_WORKTYPE = "CARPENTRY";
	public final String INVALID_WORKTYPE_ERROR_MESSAGE = "Invalid Work Type";
	public final long NEGATIVE_WORK_REQUEST_ID = -42;
	public final String NEGATIVE_WORK_REQUEST_ID_EXCEPTION = "Work Request Id cannot be negative";
	public final long DECIMAL_WORK_REQUEST_ID = (long) 47.55;
	public final String DECIMAL_WORK_REQUEST_ID_EXCEPTION = "Work Request Id should be an integer";

	public final UserTestData userTestData;
	public final AddressTestData addressTestData;

	public WorkRequestTestData(final UserTestData userTestData, final AddressTestData addressTestData) {

		this.userTestData = userTestData;
		this.addressTestData = addressTestData;

		CREATE_WORK_REQUEST = createCREATE_WORK_REQUEST();
		CREATE_WORK_REQUEST_NULL_CITY = createCREATE_WORK_REQUEST_NULL_CITY();
		CREATE_WORK_REQUEST_COUNTRY_LENGTH = createCREATE_WORK_REQUEST_COUNTRY_LENGTH();
		CREATE_WORK_REQUEST_NULL_ADDRESS = createCREATE_WORK_REQUEST_NULL_ADDRESS();
		CREATE_WORK_REQUEST_NULL_CUSTOMERID = createCREATE_WORK_REQUEST_NULL_CUSTOMERID();
		CREATE_WORK_REQUEST_NULL_DESCRIPTION = createCREATE_WORK_REQUEST_NULL_DESCRIPTION();
		CREATE_WORK_REQUEST_NULL_WORKTYPE = createCREATE_WORK_REQUEST_NULL_WORKTYPE();
		CREATE_WORK_REQUEST_ADDRESS_LENGTH = createCREATE_WORK_REQUEST_ADDRESS_LENGTH();
		CREATE_WORK_REQUEST_COUNTRY_ALPHABET = createCREATE_WORK_REQUEST_COUNTRY_ALPHABET();
		CREATE_WORK_REQUEST_INVALID_WORKTYPE = createCREATE_WORK_REQUEST_INVALID_WORKTYPE();
		CREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE = createCREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE();
		CREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID = createCREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID();
		CREATE_WORK_REQUEST_NULL_ADDRESS_STRING = createCREATE_WORK_REQUEST_NULL_ADDRESS_STRING();
		CREATE_WORK_REQUEST_NULL_COUNTRY = createCREATE_WORK_REQUEST_NULL_COUNTRY();

		WORK_REQUEST_ENTITY = createWORK_REQUEST_ENTITY();
		WORK_REQUEST_DTO = createWORK_REQUEST_DTO();
		WORK_REQUEST_LIST_DTO = createWORK_REQUEST_LIST_DTO();
		WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);

	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_COUNTRY() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_NULL_COUNRTY);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST() {
		final CreateWorkRequestDTO createWorkRequest = new CreateWorkRequestDTO();
		createWorkRequest.setCustomerId(CUSTOMER_ID);
		createWorkRequest.setWorkType(WORK_TYPE);
		createWorkRequest.setDescription(DESCRIPTION);
		createWorkRequest.setAddress(addressTestData.ADDRESS_DTO);
		return createWorkRequest;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_ADDRESS_STRING() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_NULL_STRING);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NEGATIVE_CUSTOMERID() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setCustomerId(NEGATIVE_CUSTOMER_ID);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_DIGIT_SPECIAL_CHARACTER_WORKTYPE() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setWorkType(WORK_TYPE_DIGIT_SPECIAL);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_INVALID_WORKTYPE() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setWorkType(INVALID_WORKTYPE);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_COUNTRY_ALPHABET() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_COUNRTY_ALPHABET);

		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_ADDRESS_LENGTH() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_ADDRESS_LENGTH);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_WORKTYPE() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setWorkType(null);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_DESCRIPTION() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setDescription(null);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_CUSTOMERID() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setCustomerId(null);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_ADDRESS() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(null);
		return dto;

	}

	private WorkRequestListDTO createWORK_REQUEST_LIST_DTO() {
		final WorkRequestListDTO dto = new WorkRequestListDTO();
		dto.setRequests(List.of(WORK_REQUEST_DTO));

		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_NULL_CITY() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_NULL_CITY);
		return dto;
	}

	private CreateWorkRequestDTO createCREATE_WORK_REQUEST_COUNTRY_LENGTH() {
		final CreateWorkRequestDTO dto = createCREATE_WORK_REQUEST();
		dto.setAddress(addressTestData.ADDRESS_DTO_COUNTRY_LENGTH);
		return dto;
	}

	private WorkRequestEntity createWORK_REQUEST_ENTITY() {
		final WorkRequestEntity workRequestEntity = new WorkRequestEntity();
		workRequestEntity.setCustomer(userTestData.USER);
		workRequestEntity.setWorkType(WORK_TYPE);
		workRequestEntity.setId(WORK_REQUEST_ID);
		workRequestEntity.setDescription(DESCRIPTION);
		workRequestEntity.setAddress(addressTestData.ADDRESS_ENTITY);
		return workRequestEntity;
	}

	private WorkRequestDTO createWORK_REQUEST_DTO() {
		final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
		workRequestDTO.setWorkRequestId(WORK_REQUEST_ID);
		workRequestDTO.setWorkType(WORK_TYPE);
		workRequestDTO.setAddress(addressTestData.ADDRESS_DTO);
		workRequestDTO.setDescription(DESCRIPTION);
		return workRequestDTO;

	}
}
