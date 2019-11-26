
package com.kodekonveyor.work_request;

public class AddressTestData {

	public final AddressEntity ADDRESS_ENTITY;

	public final AddressDTO ADDRESS_DTO;
	public final AddressDTO ADDRESS_DTO_NULL_STRING;
	public final AddressDTO ADDRESS_DTO_NULL_COUNRTY;
	public final AddressDTO ADDRESS_DTO_NULL_CITY;
	public final AddressDTO ADDRESS_DTO_COUNTRY_LENGTH;
	public final AddressDTO ADDRESS_DTO_COUNRTY_ALPHABET;
	public final AddressDTO ADDRESS_DTO_ADDRESS_LENGTH;

	public final String COUNTRY_LENGHT = "eefg";
	public final String COUNTRY_ALPHABET = "3e";
	public final String ADDRESS_LENGTH = "123, sdfgokwerwttigfgldsgdfgeryytusdfghrethewrwergtweryfdgb45wertwertwehgfdgsdgertgdfgerygjgxgfhghjfyuert456ghfdgu79ukgytutu";
	public final String ADDRESS_ID = "4242";
	public final String ADDRESS = "Männimäe, 74626";

	public final String CITY = "Pudisoo";
	public final String COUNTRY = "ee";

	public final String NULL_CITY = "City cannot be empty";
	public final String NULL_COUNTRY = "Country cannot be empty";
	public String COUNTRY_LENGTH_ERROR_MESSAGE = "Country cannot be more or less than 2 letter";
	public String COUNTRY_CODE_ALPHABET = "Country can contains only alphahets";
	public final String ADDRESS_LENGTHEXCEED = "Address can contains only 120 characters";

	public AddressTestData() {

		ADDRESS_ENTITY = createAddressEntity();

		ADDRESS_DTO = createAddressDTO();
		ADDRESS_DTO_NULL_STRING = createADDRESS_DTO_NULL_STRING();
		ADDRESS_DTO_NULL_COUNRTY = createADDRESS_DTO_NULL_COUNRTY();
		ADDRESS_DTO_NULL_CITY = createADDRESS_DTO_NULL_CITY();
		ADDRESS_DTO_COUNTRY_LENGTH = createADDRESS_DTO_COUNTRY_LENGTH();
		ADDRESS_DTO_COUNRTY_ALPHABET = createADDRESS_DTO_COUNRTY_ALPHABET();
		ADDRESS_DTO_ADDRESS_LENGTH = createADDRESS_DTO_ADDRESS_LENGTH();

	}

	private AddressDTO createADDRESS_DTO_ADDRESS_LENGTH() {
		final AddressDTO dto = createAddressDTO();
		dto.setAddress(ADDRESS_LENGTH);
		return dto;
	}

	private AddressDTO createADDRESS_DTO_COUNRTY_ALPHABET() {
		final AddressDTO dto = createAddressDTO();
		dto.setCountry(COUNTRY_ALPHABET);
		return dto;
	}

	private AddressDTO createADDRESS_DTO_COUNTRY_LENGTH() {
		final AddressDTO dto = createAddressDTO();
		dto.setCountry(COUNTRY_LENGHT);
		;
		return dto;
	}

	private AddressDTO createADDRESS_DTO_NULL_CITY() {
		final AddressDTO dto = createAddressDTO();
		dto.setCity(null);
		return dto;
	}

	private AddressDTO createADDRESS_DTO_NULL_COUNRTY() {
		final AddressDTO dto = createAddressDTO();
		dto.setCountry(null);
		return dto;
	}

	private AddressDTO createADDRESS_DTO_NULL_STRING() {
		final AddressDTO dto = createAddressDTO();
		dto.setAddress(null);
		return dto;
	}

	private AddressDTO createAddressDTO() {
		final AddressDTO dto = new AddressDTO();
		dto.setAddress(ADDRESS);
		dto.setCity(CITY);
		dto.setCountry(COUNTRY);
		return dto;
	}

	private AddressEntity createAddressEntity() {
		final AddressEntity entity = new AddressEntity();
		entity.setId(ADDRESS_ID);
		entity.setAddress(ADDRESS);
		entity.setCity(CITY);
		entity.setCountry(COUNTRY);
		return entity;
	}

}
