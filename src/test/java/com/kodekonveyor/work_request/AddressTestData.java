
package com.kodekonveyor.work_request;

public class AddressTestData {

	public final AddressEntity ADDRESS_ENTITY;
	public final String ID = "1";
	public final String ADDRESS = "Männimäe, 74626";
	public final AddressDTO ADDRESS_DTO;
	public final String CITY = "Pudisoo";
	public final String COUNTRY = "ee";

	public final AddressDTO ADDRESS_DTO_NULL_STRING;
	public final AddressDTO ADDRESS_DTO_NULL_COUNRTY;
	public final AddressDTO ADDRESS_DTO_NULL_CITY;
	public final AddressDTO ADDRESS_DTO_COUNTRY_LENGTH;
	public final String COUNTRY_LENGHT = "eefg";
	public final AddressDTO ADDRESS_DTO_COUNRTY_ALPHABET;
	public final String COUNTRY_ALPHABET = "3e";
	public final AddressDTO ADDRESS_DTO_ADDRESS_LENGTH;
	public final String ADDRESS_LENGTH = "123, sdfgokwerwttigfgldsgdfgeryytusdfghrethewrwergtweryfdgb45wertwertwehgfdgsdgertgdfgerygjgxgfhghjfyuert456ghfdgu79ukgytutu";

	public final String NULL_CITY = "City cannot be empty";
	public final String NULL_COUNTRY = "Country cannot be empty";
	public String COUNTRY_LENGTH = "Country cannot be more or less than 2 letter";
	public String COUNTRY_CODE_ALPHABET = "Country can contains only alphahets";
	public final String ADDRESS_LENGTHEXCEED = "Address can contains only 120 characters";

	public AddressTestData() {

		ADDRESS_ENTITY = new AddressEntity();

		ADDRESS_DTO = new AddressDTO();
		ADDRESS_DTO.setAddress(ADDRESS);
		ADDRESS_DTO.setCity(CITY);
		ADDRESS_DTO.setCountry(COUNTRY);

		ADDRESS_ENTITY.setId(ID);
		ADDRESS_ENTITY.setAddress(ADDRESS);
		ADDRESS_ENTITY.setCity(CITY);
		ADDRESS_ENTITY.setCountry(COUNTRY);

		ADDRESS_DTO_NULL_STRING = new AddressDTO();
		ADDRESS_DTO_NULL_STRING.setAddress(null);
		ADDRESS_DTO_NULL_STRING.setCity(CITY);
		ADDRESS_DTO_NULL_STRING.setCountry(COUNTRY);

		ADDRESS_DTO_NULL_COUNRTY = new AddressDTO();
		ADDRESS_DTO_NULL_COUNRTY.setAddress(ADDRESS);
		ADDRESS_DTO_NULL_COUNRTY.setCity(CITY);
		ADDRESS_DTO_NULL_COUNRTY.setCountry(null);

		ADDRESS_DTO_NULL_CITY = new AddressDTO();
		ADDRESS_DTO_NULL_CITY.setAddress(ADDRESS);
		ADDRESS_DTO_NULL_CITY.setCity(null);
		ADDRESS_DTO_NULL_CITY.setCountry(COUNTRY);

		ADDRESS_DTO_COUNTRY_LENGTH = new AddressDTO();
		ADDRESS_DTO_COUNTRY_LENGTH.setAddress(ADDRESS);
		ADDRESS_DTO_COUNTRY_LENGTH.setCity(CITY);
		ADDRESS_DTO_COUNTRY_LENGTH.setCountry(COUNTRY_LENGHT);

		ADDRESS_DTO_COUNRTY_ALPHABET = new AddressDTO();
		ADDRESS_DTO_COUNRTY_ALPHABET.setAddress(ADDRESS);
		ADDRESS_DTO_COUNRTY_ALPHABET.setCity(CITY);
		ADDRESS_DTO_COUNRTY_ALPHABET.setCountry(COUNTRY_ALPHABET);

		ADDRESS_DTO_ADDRESS_LENGTH = new AddressDTO();
		ADDRESS_DTO_ADDRESS_LENGTH.setAddress(ADDRESS_LENGTH);
		ADDRESS_DTO_ADDRESS_LENGTH.setCity(CITY);
		ADDRESS_DTO_ADDRESS_LENGTH.setCountry(COUNTRY);

	}

}
