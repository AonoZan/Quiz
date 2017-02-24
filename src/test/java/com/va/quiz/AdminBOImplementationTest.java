package com.va.quiz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.va.quiz.bo.AdminBOImplementation;
import com.va.quiz.dao.AdminDAO;
import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class AdminBOImplementationTest {
	AdminDAO daoMock = Mockito.mock(AdminDAO.class);
	AdminBOImplementation bo = new AdminBOImplementation();

	Admin admin;

	final String NAME = "Dejo", PASS = "Pass";

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		admin = new Admin(NAME, PASS);
	}

	@Test
	public void shouldReturnAdminWhenAdminExists() {
		Mockito.when(daoMock.getAdmin(admin)).thenReturn(admin);

		Admin resultAdmin = bo.getAdmin(admin);

		assertSame(admin, resultAdmin);
		Mockito.verify(daoMock).getAdmin(admin);
	}
	@Test
	public void shouldReturnNullWhenAdminDontExists() {
		Mockito.when(daoMock.getAdmin(admin)).thenReturn(null);

		Admin resultAdmin = bo.getAdmin(admin);

		assertNull(resultAdmin);
		Mockito.verify(daoMock).getAdmin(admin);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButArgumentIsNull() {
		Admin resultAdmin = bo.getAdmin(null);

		assertNull(resultAdmin);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButNameIsNull() {
		Admin admin = new Admin(null, PASS);

		Admin resultAdmin = bo.getAdmin(admin);

		assertNull(resultAdmin);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButPassIsNull() {
		Admin admin = new Admin(NAME, null);

		Admin resultAdmin = bo.getAdmin(admin);

		assertNull(resultAdmin);
		Mockito.verifyZeroInteractions(daoMock);
	}

	@Test
	public void shouldReturnTrueWhenAddingAdminThatDoesNotExists() {
		Mockito.when(daoMock.addAdmin(admin)).thenReturn(true);

		boolean result = bo.addAdmin(admin);

		assertTrue(result);
		Mockito.verify(daoMock).addAdmin(admin);
	}
	@Test
	public void shouldReturnFalseWhenAddingAdminThatExists() {
		Mockito.when(daoMock.addAdmin(admin)).thenReturn(false);

		boolean result = bo.addAdmin(admin);

		assertFalse(result);
		Mockito.verify(daoMock).addAdmin(admin);
	}
	@Test
	public void shouldReturnFalseWhenAddingButArgumentIsNull() {
		boolean result = bo.addAdmin(null);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingAdminButNameIsNull() {
		Admin admin = new Admin(null, PASS);

		boolean result = bo.addAdmin(admin);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenAddingAdminButPassIsNull() {
		Admin admin = new Admin(NAME, null);

		boolean result = bo.addAdmin(admin);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
}

