package com.capg.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.Test;

import com.addressbookdb.AddressBookService.IOService;
import com.addressbookdb.AddressBookService;
import com.addressbookdb.Contact;
import com.addressbookdb.DatabaseException;

public class AddressBookTest {
	/**
	 * Usecase16: Retrieve data from the database
	 * 
	 * @throws DatabaseException
	 */
	@Test
	public void givenContactDataInDB_WhenRetrieved_ShouldMatchContactCount() throws DatabaseException {
		AddressBookService addressBookService = new AddressBookService();
		List<Contact> contactData = addressBookService.readContactData(IOService.DB_IO);
		assertEquals(4, contactData.size());
	}
}