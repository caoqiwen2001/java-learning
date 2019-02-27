package com.brianway.learning.java.base.dymicTest;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class Test {

    public static void main(String[] args) {
        String testStr = "testcun";
        Hasher hasher = Hashing.md5().newHasher().putString(testStr, Charsets.UTF_8);
        System.out.println(hasher.hash().toString());

    }

    public void testman(Man person) {
        Person man = (Person) person;
        System.out.println(man.getName());
    }


}
