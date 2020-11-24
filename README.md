# ProtonnTask
In this repository we will implement a custom  Serialization and Deserialization in Java.

ProtonnMain.java is the driver class. <br />
MyCustomObj.java is the custom pojo which consists of 3 string attrs and 2 Integer atts. <br />
ProtonnUtils.java contains all the utility methods required for this task. <br />


# How to run
Run the ProtonnMain.java

# Serialization Logic
Step 1: Init MyCustomObj with any values of your choice. <br />
Step 2: Init List<ByteArrayOutputStream> object. <br>
Step 3: First convert serialVersionUID to bytes and add write it to ByteArrayOutputStream. Then Add that object to List<ByteArrayOutputStream> <br/>
Step 4: Repeat the same above step for rest of the attributes. <br/>

# Deserialization Logic
Step 1: Loop through the List<ByteArrayOutputStream> that is received from the above serialization step. <br/>
Step 2: First check if this.serialVersionUID is same as what is received. <br/>
Step 3: If above step is success, then deserailize the rest of the attrs, in the same way they were serialized. <br/>  
