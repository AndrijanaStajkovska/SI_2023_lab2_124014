package mk.finki.ukim;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        List<User> users = new ArrayList<>();

        // тест1
        String password1 = "12345";
        String email1 = "john.doe@hotmail.com";
        User user1 = new User(null, password1, email1);
        users.add(user1);
        assertFalse(SILab2.function(user1, users));

        // тест2
        String username2 = "Alice";
        String password2 = "pass123@";
        String email2 = null;
        User user2 = new User(username2, password2, email2);
        users.add(user2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // тест3
        String username3 = "Jane";
        String password3 = "jane123AC!$";
        String email3 = "jane@yahoo.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3);
        assertFalse(SILab2.function(user3, users));

        // тест4
        String username4 = "Ani";
        String password4 = "987";
        String email4 = "ani@gmail.com";
        User user4 = new User(username4, password4, email4);
        users.add(user4);
        assertFalse(SILab2.function(user4, users));

        // тест5
        String username5 = "David";
        String password5 = "532$bvcprw";
        String email5 = "adavid@gmail.com";
        User user5 = new User(username5, password5, email5);
        assertTrue(SILab2.function(user5, users));
    }

    @Test
    void multipleConditionsTest(){
        List<User> users = new ArrayList<>();

        // тест1
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // тест2
        User user2 = new User("John", null, "john.doe@hotmail.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // тест3
        User user3 = new User("John", "pass123", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // тест4
        User user4 = new User("John", "Pass123#!", "john@gmail.com");
        assertTrue(SILab2.function(user4, users));
    }
}
