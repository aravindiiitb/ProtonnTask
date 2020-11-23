package com.protonn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyCustomObj {
    private String name;
    private String email;
    private String dob;
    private Integer age;
    private Integer height;

    public MyCustomObj() {
    }

    public MyCustomObj(String name, String email, String dob, Integer age, Integer height) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }


    public void serializeMe(FileOutputStream fout) {
        try {
            fout.write(ProtonnUtils.convertStringToBinary(name).getBytes());
            fout.write(ProtonnUtils.convertStringToBinary("&").getBytes()); //Delimiter after every attribute is written

            fout.write(ProtonnUtils.convertStringToBinary(email).getBytes());
            fout.write(ProtonnUtils.convertStringToBinary("&").getBytes()); //Delimiter after every attribute is written

            fout.write(ProtonnUtils.convertStringToBinary(dob).getBytes());
            fout.write(ProtonnUtils.convertStringToBinary("&").getBytes()); //Delimiter after every attribute is written

            fout.write(ProtonnUtils.convertIntegerToBinary(age).getBytes());
            fout.write(ProtonnUtils.convertStringToBinary("&").getBytes()); //Delimiter after every attribute is written

            fout.write(ProtonnUtils.convertIntegerToBinary(height).getBytes());
        } catch (IOException e) {
            System.out.println("Something went wrong here " + e.getMessage());
        }
    }

    public void deserializeMe(FileInputStream fin) {
        try {
            byte[] buffer = new byte[8];
            StringBuilder sb = new StringBuilder();
            while (fin.read(buffer) != -1) {
                String temp = new String(buffer);
                String charVal = ProtonnUtils.convertBinaryToString(temp);
                sb.append(charVal);
            }

            String res = sb.toString();
            String[] vals = res.split("&"); //Splitting at the delimiter and assigning the values

            name = vals[0];
            email = vals[1];
            dob = vals[2];
            age = ProtonnUtils.binaryToDecimal(ProtonnUtils.convertStringToBinary(vals[3]));
            height = ProtonnUtils.binaryToDecimal(ProtonnUtils.convertStringToBinary(vals[4]));

        } catch (IOException e) {
            System.out.println("Something went wrong here " + e.getMessage());
        }
    }
}
