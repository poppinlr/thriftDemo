package com.thrift.demo;

import org.apache.thrift.TException;

public class DoWorkImpl implements DoWork.Iface {
    @Override
    public void ping() throws TException {
        System.out.println("ping success");
    }

    @Override
    public String doWork(Work work) throws TException {
        System.out.println("work.num1" + work.num1);
        System.out.println("work.num2" + work.num2);
        System.out.println("work.op" + work.op);
        System.out.println("work.comment" + work.comment);
        return work.comment;
    }
}
