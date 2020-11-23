# ProtonnTask
In this repository we will implement a custom  Serialization and Deserialization in Java.

ProtonnMain.java is the driver class.
MyCustomObj.java is the custom pojo which consists of 3 string attrs and 2 Integer atts.
ProtonnUtils.java contains all the utility methods required for this task.


# How to run
Run the ProtonnMain.java

# Serialization Logic
Step 1: Init MyCustomObj with any values of your choice. <br />
Step 2: Convert every attr of the object created in the above step to 8-bit binary and write it to a file. Also, insert a 8-bit binary version of delimiter. 

# Deserialization Logic
Step 1: Read the file in chunks on 8bits. <br />
Step 2: convert the 8bits to string. <br />
Step 3: Split the derived string at &. <br /> 
Step 4: Assign them in the same order as serialized. <br />  
