package com.kodekonveyor.work_request.create;

import com.kodekonveyor.work_request.AddressDTO;

import lombok.Data;

@Data
public class CreateWorkRequestDTO {

	private String customerId;
	private String workType;
	private AddressDTO address;
	private String description;

}
