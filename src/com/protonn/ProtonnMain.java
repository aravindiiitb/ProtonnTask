package com.protonn;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProtonnMain {

    public static void main(String[] args) {

        // Serialization code
        MyCustomObj mcoS = new MyCustomObj("aravind", "aravind785@gmail.com", "24-07-1996", 24, 185);
        List<ByteArrayOutputStream> bos = new ArrayList<>();
        mcoS.serializeMe(bos);

        //Deserialization code
        MyCustomObj mcoD = new MyCustomObj();
        mcoD.deserializeMe(bos);

        //Validation
        assertEquals(mcoS.getName(), mcoD.getName());
        assertEquals(mcoS.getDob(), mcoD.getDob());
        assertEquals(mcoS.getEmail(), mcoD.getEmail());
        assertEquals(mcoS.getAge(), mcoD.getAge());
        assertEquals(mcoS.getHeight(), mcoD.getHeight());

        System.out.println("All tests passed!");

    }
}
