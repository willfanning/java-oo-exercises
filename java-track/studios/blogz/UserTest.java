package blogz;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUsernameValidation() {
		assertFalse(User.isValidUsername("1trueusername"));
		assertTrue(User.isValidUsername("myname___"));
	}
	
	@Test
	public void testUsernameException() {
		try {
			User u = new User("-invalid", "password");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testIsValidPassword() {
		User u = new User("username", "password");
		assertTrue(u.isValidPassword("password"));
	}

}
