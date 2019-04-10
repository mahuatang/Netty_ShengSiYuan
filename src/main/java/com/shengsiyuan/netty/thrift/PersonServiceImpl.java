package com.shengsiyuan.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * Created by YuRui on 2017/7/28.
 */

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws TException {
        System.out.println("Get Client Param: " + username);
        Person person = new Person();

        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws TException {
        System.out.println("Got Client Param: ");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
