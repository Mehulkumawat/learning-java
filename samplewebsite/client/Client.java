package samplewebsite.client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 9876);
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream DataInputStream = new DataInputStream(inputStream);
        for(int i=0 ;i<50 ; i++){
            String inputfromserver = DataInputStream.readUTF();
            System.out.println(inputfromserver);
        }
        clientSocket.close();
        inputStream.close();
        DataInputStream.close();
        
        
    }
    
}
