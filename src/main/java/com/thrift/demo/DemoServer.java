package com.thrift.demo;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import java.net.ServerSocket;

public class DemoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(7912);
        TServerSocket serverTransport = new TServerSocket(socket);
        DoWork.Processor processor = new DoWork.Processor(new DoWorkImpl());

        TSimpleServer.Args tArgs = new TSimpleServer.Args(serverTransport);
        tArgs.processor(processor);

        TServer server = new TSimpleServer(tArgs);
        System.out.println("Running server...");
        server.serve();
    }
}


