package fr.epita.etl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * The Contact Row Mapper
 * @author LienKT
 */

public class ContactRowMapper implements RowMapper<Contact> {
    public static final String EMAIL_COLUMN = "contact_email";
    public static final String FIRST_NAME_COLUMN = "contact_first_name";
    public static final String LAST_NAME_COLUMN = "contact_last_name";
    public static final String ADDRESS_COLUMN = "contact_address";
    public static final String CITY_COLUMN = "contact_city";
    public static final String COUNTRY_COLUMN = "contact_country";
    public static final String BIRTHDATE_COLUMN = "contact_birthdate";

	@Override
	public Contact mapRow(ResultSet rs, int i) throws SQLException {
		Contact contact = new Contact();
		contact.setEmail(rs.getString(EMAIL_COLUMN));
		contact.setFirstName(rs.getString(FIRST_NAME_COLUMN));
		contact.setLastName(rs.getString(LAST_NAME_COLUMN));
		contact.setAddress(rs.getString(ADDRESS_COLUMN));
		contact.setCity(rs.getString(CITY_COLUMN));
		contact.setCountry(rs.getString(COUNTRY_COLUMN));
		contact.setBirthdate(rs.getDate(BIRTHDATE_COLUMN));

        return contact;
	}
}
