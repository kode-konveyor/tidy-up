package com.kodekonveyor.work_request;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AddressEntity {
	@Id
	private String id;
	private String country;
	private String city;
	private String Address;
}
