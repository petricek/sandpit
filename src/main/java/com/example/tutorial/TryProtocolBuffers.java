package com.example.tutorial;
import com.example.tutorial.AddressBookProtos.Person;
/**
 * Created by petricek on 4/26/14.
 * ho
 */
public class TryProtocolBuffers {

        public static void main(String[] args)
        {

            Person john =
                    Person.newBuilder()
                            .setId(1234)
                            .setName("John Doe")
                            .setEmail("jdoe@example.com")
                            .addPhone(
                                    Person.PhoneNumber.newBuilder()
                                            .setNumber("555-4321")
                                            .setType(Person.PhoneType.HOME))
                            .build();



        }
}
