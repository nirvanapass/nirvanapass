package com.nirvanapass;

import com.lambdaworks.crypto.SCrypt;

import java.security.GeneralSecurityException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(SCrypt.scrypt("hello world".getBytes(), "pratyush nalam".getBytes(), 16, 8, 1, 64)));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
