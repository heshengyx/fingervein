package com.grgbanking.electric.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.grgbanking.fingervein.protobuf.PersonProtobuf;
import com.grgbanking.fingervein.protobuf.PersonProtobuf.Person;

public class ProtobufTest {
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		//模拟将对象转成byte[]，方便传输
		PersonProtobuf.Person.Builder builder = PersonProtobuf.Person.newBuilder();
	    builder.setId(1);
	    builder.setName("ant");
	    builder.setEmail("ghb@soecode.com");
	    PersonProtobuf.Person person = builder.build();
	    System.out.println("before :"+ person.toString());

	    System.out.println("===========Person Byte==========");
	    for(byte b : person.toByteArray()){
	        System.out.print(b);
	    }
	    System.out.println();
	    System.out.println(person.toByteString());
	    System.out.println("================================");

	    //模拟接收Byte[]，反序列化成Person类
	    byte[] byteArray =person.toByteArray();
	    Person p2 = Person.parseFrom(byteArray);
	    System.out.println("after :" +p2.toString());
	}
	
}
