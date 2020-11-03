package samplewebsite.server;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Server {
    
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(9876);
        //created a socket at server side on port 9876.now 9876 port is busy with this socket
        //no one in this machine can use this port.
        Socket clientSocket = serverSocket.accept();
        // now client tries to connect, ones it is connect
        // accept that connection
        OutputStream outputStream = clientSocket.getOutputStream();
        
        //getting the o/p stream of the client socket.
        // output stream represents data that comes from the client to server
        // it gives data in byte form
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //data os represents data in java's data types like java's string , int...
        Scanner scanner = new Scanner(System.in);
        // now we have initialized the scanner to take input .
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        for(int i = 0 ; i<50 ; i++ ){
            System.out.print("your message:-");
            // String message = String.valueOf(scanner.nextLine());
            dataOutputStream.writeUTF(scanner.nextLine());
            dataOutputStream.flush(); 
            String serverInput = dataInputStream.readUTF();
            System.out.println(serverInput);
        }
        clientSocket.close();
        dataInputStream.close();
        serverSocket.close();
        dataOutputStream.close();  
    }
}
