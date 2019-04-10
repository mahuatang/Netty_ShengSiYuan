package com.shengsiyuan.netty.protobuf;

import com.shengsiyuan.netty.sixthexample.MyDataInfo;

public class ProtoBufTest {
    public static void main(String[] args) throws Exception{
        MyDataInfo.Person studnet = MyDataInfo.Person.newBuilder().
                setName("张三").setAge(20).setAddress("北京").build();

        byte[] student2ByteArray = studnet.toByteArray();

        MyDataInfo.Person student2 = MyDataInfo.Person.parseFrom(student2ByteArray);

        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}
