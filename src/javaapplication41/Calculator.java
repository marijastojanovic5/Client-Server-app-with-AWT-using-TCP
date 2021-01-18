package javaapplication41;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Calculator extends Thread{
    

    Socket socket;
    
    public Calculator(Socket socket){
        this.socket=socket;
       
    
    }
    
    @Override
    public void run() {
        super.run(); 
        
        try{
        DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
       
            System.out.println("Client's nums");
            int num1 = inFromClient.readInt();
            System.out.println(num1);
            int num2 = inFromClient.readInt();
            System.out.println(num2);
            int answer = num1 + num2;
            System.out.println("Answer is: "+ answer);

            outToClient.writeInt(answer);
        }catch(Exception ex){
            
        }
        
    
    }

}
