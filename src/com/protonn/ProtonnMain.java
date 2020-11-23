package com.protonn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ProtonnMain {

    public static void main(String[] args) {

        try {
            // Serialization code
            MyCustomObj mcoS = new MyCustomObj("aravind", "aravind785@gmail.com", "24-07-1996", 24, 185);
            FileOutputStream fileOut = new FileOutputStream("User.ser");
            mcoS.serializeMe(fileOut);

            fileOut.close();

            //Deserialization code
            MyCustomObj mcoD = new MyCustomObj();
            FileInputStream fis = new FileInputStream("User.ser");
            mcoD.deserializeMe(fis);

            fis.close();

            //Validation
            assertEquals(mcoS.getName(), mcoD.getName());
            assertEquals(mcoS.getAge(), mcoD.getAge());
            assertEquals(mcoS.getEmail(), mcoD.getEmail());
            assertEquals(mcoS.getAge(), mcoD.getAge());
            assertEquals(mcoS.getHeight(), mcoD.getHeight());

        } catch (IOException i) {
            System.out.println("Something went wrong here " + i.getMessage());
        }
    }
}
