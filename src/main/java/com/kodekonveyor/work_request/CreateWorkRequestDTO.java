package com.kodekonveyor.work_request;

public class CreateWorkRequestDTO {

	private AddressDTO address;
	private String workType;
	private String customerId;
	private String description;

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(final AddressDTO address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkTye(final String workType) {
		this.workType = workType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
	}

}
