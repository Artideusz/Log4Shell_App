package com.vuln;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App 
{
    final static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args ) throws IOException
    {
        Integer port;

        if(args.length >= 1) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                port = 8888;
            }
        } else {
            port = 8888;
        }

        ServerSocket serverSocket = new ServerSocket(port);

        logger.info("Server is running on port " + port);

        while(true) {
            Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    
            writer.println("Write your name: ");
    
            String name = reader.readLine();
    
            writer.println("Hello " + name);
            logger.info("Hello " + name);
    
            socket.close();

            if(name.equals("QUIT")) {
                serverSocket.close();
                break;
            }
        }
    }
}
