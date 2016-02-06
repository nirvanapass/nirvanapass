package com.nirvanapass;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Main {

    public static void main(String[] args) {
//        try {
//            System.out.println(Arrays.toString(SCrypt.scrypt("hello world".getBytes(), "pratyush nalam".getBytes(),
// 16, 8, 1, 64)));
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(2, 65536, 1, "password");
        System.out.println(hash);
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
    }
}
