package com.nirvanapass;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Main {

    public static void main(String[] args) {
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(2, 65536, 1, args[0]);
        System.out.println(hash);
    }
}
