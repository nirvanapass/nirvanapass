package com.nirvanapass;

import com.lambdaworks.crypto.SCrypt;

import java.security.GeneralSecurityException;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        try {
            String hash = Base64.getEncoder().encodeToString(SCrypt.scrypt("password".getBytes(), "salt".getBytes(), 16384, 16, 2, 128));
            System.out.println(hash);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
