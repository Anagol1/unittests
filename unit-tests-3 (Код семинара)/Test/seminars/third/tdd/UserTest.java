package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    @BeforeEach
    public void setUp() {
        user = new User("Anna", "qwert123", false);
    }
    @Test
    void setNameTest() {
//        SomeService service = new SomeService();
        assertEquals(user.getName(), "Anna");
        // assertEquals...
    }
    @Test
    void setPassTest() {
//        SomeService service = new SomeService();
        assertEquals(user.getPassword(), "qwert123");
        // assertEquals...
    }
    @Test
    void authenticateTest() {
        assertTrue(user.authenticate(user.getName(),user.getPassword()));
    }
    @Test
    void isAdminTest(){
        user.setAdmin(true);
        assertTrue(user.isAdmin);
    }

    /**
     *@apiNote Test проверяет, дабавлен ли пользователь в userRepository
     */
    @Test
    void addUserRepositoryTest(){

        UserRepository userRepository = new UserRepository();
        List<User> data = userRepository.data;
        userRepository.addUser(user);
        assertTrue(data.contains(user));
    }
}