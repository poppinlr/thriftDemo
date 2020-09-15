package com.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class DemoClient {

    public static void main(String[] args) throws TException {
        // 创建client
        TTransport transport = new TSocket("localhost", 7912);
        TProtocol protocol = new TBinaryProtocol(transport);
        DoWork.Client client = new DoWork.Client(protocol);
        transport.open();

        client.ping();
        Work work = new Work(1,2,Operation.ADD);
        work.comment = "comment";//optional property is not in the construct

        System.out.println(client.doWork(work));

        transport.close();
    }
}
