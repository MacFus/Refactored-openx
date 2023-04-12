package pl.fus;

import org.junit.jupiter.api.Test;
import pl.fus.Entity.User.Address;
import pl.fus.Entity.User.Geolocation;
import pl.fus.Entity.User.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void shouldReturnDoubleValue() {
        double distance = Utils.distance(20.0, 1.1, 1.1, 2.2);
        assertInstanceOf(Double.class, distance);
    }

    @Test
    void shouldEqualsZero() {
        double distance = Utils.distance(0, 0, 0, 0);
        assertEquals(0, distance, 0.0001);
    }


    @Test
    void checkIfThrowsExeption() throws Exception {
        assertThrows(Exception.class, () -> {
            String url = Utils.readUrl("www.google.com");
        });
    }

    @Test
    void checkIfReturnsString() throws Exception {
        String url = Utils.readUrl("https://www.szlaki.net.pl/");
        assertInstanceOf(String.class, url);
    }

    @Test
    void shouldReturnUsersOneAndThree() {
        User user1 = new User(new Address(new Geolocation("-60.0", "-60.0")), 0);
        User user2 = new User(new Address(new Geolocation("0.0", "0.0")), 1);
        User user3 = new User(new Address(new Geolocation("60.0", "60.0")), 2);
        ArrayList<User> users = new ArrayList<User>() {{
            add(user1);
            add(user2);
            add(user3);
        }};
        ArrayList<User> list = Utils.findLongestDistanceBetweenUsers(users);
        assertSame(user1, list.get(0));
        assertSame(user3, list.get(1));

    }

    @Test
    void distance() {
    }
}