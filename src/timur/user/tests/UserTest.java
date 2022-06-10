package timur.user.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import timur.user.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    String email = "peter@gmail.com";
    String password = "aaaaaaaa1!Aa";

    @BeforeEach
    void setUp() {
        user = new User(email, password);

    }

    @Test
    void testCorrectEmail() {
        user.setEmail("peter@yahoo.com");
        assertEquals("peter@yahoo.com", user.getEmail());

    }

    @Test
    void testWithoutAt() {
        user.setEmail("peter.yahoo.com");
        assertEquals(email, user.getEmail());

    }


    @Test
    void testManyAt() {
        user.setEmail("peter@yah@oo.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testDotAfterAt() {
        user.setEmail("peter@yahoocom");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testLastDot() {
        user.setEmail("peter@yahoo.co.m");
        assertEquals(email, user.getEmail());
        user.setEmail("peter@yahoo.com.");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testIncorrectSymbol() {
        user.setEmail("pet!er@yahoocom");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testPwdLength() {
        user.setPassword("aa1!Aa");
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPwdUpperCase() {
        user.setPassword("aaaaaaaa1!aa");
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPwdLowerCase() {
        user.setPassword("AAAAAAAA1!AA");
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPwdDigit() {
        user.setPassword("aaaaaaaaB!aa");
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPwdSpecialChar() {
        user.setPassword("aaaaaaaaB1aa");
        assertEquals(password, user.getPassword());
    }




}