package javaapplication41;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaApplication41 {

    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(1500);
        while(true){
        System.out.println("Server is listening...");
        Socket socket =server.accept();
        new Calculator(socket).start();
       
        
    }
    }
    
}
