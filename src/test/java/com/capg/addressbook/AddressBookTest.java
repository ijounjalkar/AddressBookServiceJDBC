package com.capg.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.capg.addressbook.AddressBookMain.IOService;
import com.capg.addressbook.AddressBookService;
import com.capg.addressbook.Contact;
import com.capg.addressbook.DatabaseException;



public class AddressBookTest {
	/**
	 * Usecase16: Retrieve data from the database
	 * 
	 * @throws DatabaseException
	 * @throws SQLException 
	 */
	@Test
	public void givenContactDataInDB_WhenRetrieved_ShouldMatchContactCount() throws DatabaseException, SQLException {
		AddressBookService addressBookService = new AddressBookService();
		List<Contact> contactData = addressBookService.readContactData(IOService.DB_IO);
		assertEquals(4, contactData.size());
	}
	/**Usecase17: Updating phone number of a persons in contact table
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	@Test
	public void givenNewDataForContact_WhenUpdated_ShouldBeInSync() throws DatabaseException, SQLException {
		AddressBookService addressBookService = new AddressBookService();
		List<Contact> contactData = addressBookService.readContactData(IOService.DB_IO);
		addressBookService.updatePersonsPhone("Aditya", "8850273350");
		addressBookService.readContactData(IOService.DB_IO);
		boolean result = addressBookService.checkContactDataSync("Aditya");
		assertEquals(true, result);
	} 
}