package com.protonn;

import java.io.*;
import java.util.List;

public class MyCustomObj {
    private String name;
    private String email;
    private String dob;
    private Integer age;
    private Integer height;

    private final int serialVersionUID = 9876;

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


    public void serializeMe(List<ByteArrayOutputStream> bos) {
        try {
            ByteArrayOutputStream bosSUID = new ByteArrayOutputStream();
            bosSUID.write(String.valueOf(serialVersionUID).getBytes());
            bos.add(bosSUID);

            ByteArrayOutputStream bosName = new ByteArrayOutputStream();
            bosName.write(name.getBytes());
            bos.add(bosName);

            ByteArrayOutputStream bosEmail = new ByteArrayOutputStream();
            bosEmail.write(email.getBytes());
            bos.add(bosEmail);

            ByteArrayOutputStream bosDob = new ByteArrayOutputStream();
            bosDob.write(dob.getBytes());
            bos.add(bosDob);

            ByteArrayOutputStream bosAge = new ByteArrayOutputStream();
            bosAge.write(String.valueOf(age).getBytes());
            bos.add(bosAge);

            ByteArrayOutputStream bosHeight = new ByteArrayOutputStream();
            bosHeight.write(String.valueOf(height).getBytes());
            bos.add(bosHeight);

        } catch (IOException e) {
            System.out.println("Something went wrong here " + e.getMessage());
        }
    }

    public void deserializeMe(List<ByteArrayOutputStream> bisLst) {

        for(int i=0;i<bisLst.size();i++) {
            String str = ProtonnUtils.getStringFromBIS(bisLst.get(i));
            boolean flag = false;
            switch (i) {
                case 0:
                    if (serialVersionUID != Integer.parseInt(str)) {
                        flag = true;
                        System.out.println("Invalid Class Exception. Please contact serializer for updated class!");
                    }
                    break;
                case 1:
                    name = str;
                    break;
                case 2:
                    email = str;
                    break;
                case 3:
                    dob = str;
                    break;
                case 4:
                    age = Integer.parseInt(str);
                    break;
                case 5:
                    height = Integer.parseInt(str);
                    break;
                default:
                    System.out.println("Index out of bound. Please check the value");
                    break;
            }
            if(flag)
                break;
        }
    }
}
