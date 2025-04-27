package mylab.user.di.xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testDependencyInjection() {
        assertNotNull(userService, "UserService should not be null");
        assertNotNull(userService.getUserRepository(), "UserRepository should not be null");
        assertEquals("MySQL", userService.getUserRepository().getDbType(), "DB type should be MySQL");
        assertNotNull(userService.getSecurityService(), "SecurityService should not be null");
    }

    @Test
    public void testRegisterUser() {
        boolean result = userService.registerUser("user1", "John Doe", "password123");
        assertTrue(result, "registerUser should return true");
    }
}
