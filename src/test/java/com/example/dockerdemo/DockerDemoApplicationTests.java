package com.example.dockerdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//@SpringBootTest
class DockerDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void send() throws Exception {
        for (int i = 0; i < 10; i++) {
            
        }{
            new Thread(() -> {
                Socket socket = null;
                try {
                    socket = new Socket("localhost",8888);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String msg = "hello world!";
                while (true){
                    try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                        out.write(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
            Thread.sleep(1000);
        }
    }

    @Test
    void receive() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            char[] buf = new char[255];
            int len;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()))){
                len = reader.read(buf);
            }
            System.out.println(new String(buf,0,len));
        }
    }

}
