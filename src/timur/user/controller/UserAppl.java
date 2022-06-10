package timur.user.controller;

import timur.user.model.User;

public class UserAppl {

    public static void main(String[] args) {
        User user = new User("peter@gmail.com", "a1!Qaaaaaa1!Aa");
        System.out.println(user);
        user.setEmail("peter@yah@oo.com");
        user.setPassword("12345678A%");
        System.out.println(user);

    }

}
