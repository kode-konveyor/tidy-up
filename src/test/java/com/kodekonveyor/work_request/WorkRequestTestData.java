package com.kodekonveyor.work_request;

import java.util.List;

import com.kodekonveyor.authentication.UserTestData;
import com.kodekonveyor.work_request.create.CreateWorkRequestDTO;

public class WorkRequestTestData {
	public final String OWNER_ID = "4242";
	public final String WORK_TYPE = "CLEANING";
	public final Long WORK_REQUEST_ID = (long) 42;
	public final WorkRequestDTO WORK_REQUEST_DTO;
	public final WorkRequestListDTO WORK_REQUEST_LIST_DTO;
	public final String DESCRIPTION = "Clean up the mess";
	public final boolean IS_ACTIVE = true;
	public final WorkRequestEntity WORK_REQUEST_ENTITY;
	public List<WorkRequestEntity> WORK_REQUEST_ENTITY_LIST;
	public final String NULL_OWNERID = "No OwnerId";
	public final UserTestData userTestData;

	public final String BAD_CUSTOMER_ID = "";
	public final String BAD_WORK_TYPE = "ENGINEERING";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO;
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID;
	public final AddressDTO ADDRESS;
	public final AddressDTO BAD_ADDRESS;
	public final AddressDTO BAD_CITY;
	public final AddressDTO BAD_COUNTRY;
	public final String BAD_DESCRIPTION = "";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_WORKTYPE;
	public final String INVALID_WORK_TYPE = "Invalid work type";
	public final String INVALID_CUSTOMER_ID = "Invalid customer id";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION;
	public final String INVALID_DESCRIPTION = "Invalid description";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_ADDRESS;
	public final String INVALID_ADDRESS = "Invalid address";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_CITY;
	public final String INVALID_CITY = "Invalid city";
	public final CreateWorkRequestDTO CREATE_REQUEST_DTO_WITH_BAD_COUNTRY;
	public final String INVALID_COUNTRY = "Invalid country";

	public WorkRequestTestData(final UserTestData userTestData) {
		this.userTestData = userTestData;
		WORK_REQUEST_ENTITY = new WorkRequestEntity();
		WORK_REQUEST_ENTITY.setCustomer(userTestData.USER);
		WORK_REQUEST_ENTITY.setWorkType(WORK_TYPE);
		WORK_REQUEST_ENTITY.setId(WORK_REQUEST_ID);
		WORK_REQUEST_DTO = new WorkRequestDTO();
		WORK_REQUEST_DTO.setWorkRequestId(WORK_REQUEST_ID);
		WORK_REQUEST_DTO.setWorkType(WORK_TYPE);
		WORK_REQUEST_LIST_DTO = new WorkRequestListDTO();
		WORK_REQUEST_LIST_DTO.setRequests(List.of(WORK_REQUEST_DTO));
		WORK_REQUEST_ENTITY_LIST = List.of(WORK_REQUEST_ENTITY);
		CREATE_REQUEST_DTO = createCREATE_REQUEST_DTO();
		CREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID = createCREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID();
		CREATE_REQUEST_DTO_WITH_BAD_WORKTYPE = createCREATE_REQUEST_DTO_WITH_BAD_WORKTYPE();
		CREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION = createCREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION();
		ADDRESS = new AddressDTO();
		BAD_ADDRESS = new AddressDTO();
		BAD_ADDRESS.setId(WORK_REQUEST_ID);
		BAD_ADDRESS.setAddress("");
		BAD_ADDRESS.setCity("city");
		BAD_ADDRESS.setCountry("country");
		BAD_CITY = new AddressDTO();
		BAD_CITY.setId(WORK_REQUEST_ID);
		BAD_CITY.setAddress("address");
		BAD_CITY.setCity("");
		BAD_CITY.setCountry("country");
		BAD_COUNTRY = new AddressDTO();
		BAD_COUNTRY.setId(WORK_REQUEST_ID);
		BAD_COUNTRY.setAddress("address");
		BAD_COUNTRY.setCity("city");
		BAD_COUNTRY.setCountry("");
		CREATE_REQUEST_DTO_WITH_BAD_ADDRESS = createCREATE_REQUEST_DTO_WITH_BAD_ADDRESS(BAD_ADDRESS);
		CREATE_REQUEST_DTO_WITH_BAD_CITY = createCREATE_REQUEST_DTO_WITH_BAD_CITY(BAD_CITY);
		CREATE_REQUEST_DTO_WITH_BAD_COUNTRY = createCREATE_REQUEST_DTO_WITH_BAD_COUNTRY(BAD_COUNTRY);
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_ADDRESS(final AddressDTO address) {
		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setAddress(address);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_CITY(final AddressDTO address) {
		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setAddress(address);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_COUNTRY(final AddressDTO address) {

		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setAddress(address);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO() {
		final CreateWorkRequestDTO createWorkRequestDTO = new CreateWorkRequestDTO();
		createWorkRequestDTO.setCustomerId(OWNER_ID);
		createWorkRequestDTO.setWorkType(WORK_TYPE);
		createWorkRequestDTO.setDescription(DESCRIPTION);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_CUSTOMER_ID() {
		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setCustomerId(BAD_CUSTOMER_ID);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_WORKTYPE() {
		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setWorkType(BAD_WORK_TYPE);
		return createWorkRequestDTO;
	}

	private CreateWorkRequestDTO createCREATE_REQUEST_DTO_WITH_BAD_DESCRIPTION() {
		final CreateWorkRequestDTO createWorkRequestDTO = createCREATE_REQUEST_DTO();
		createWorkRequestDTO.setDescription(BAD_DESCRIPTION);
		return createWorkRequestDTO;
	}

}
