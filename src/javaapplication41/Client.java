package javaapplication41;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client  {
        public static void main(String[] args) throws IOException  {

    
        Socket socket =new Socket("localhost",1500);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        
        Frame f =new Frame();
        Label l1=new Label("First number");
        Label l2=new Label("Second number");
        Label l3=new Label("Result");
        
        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();

        Button b=new Button("Add");
        Button b1=new Button("Cancel");
        
        l1.setBounds(50,100,100,20);
        l2.setBounds(50,140,100,20);
        l3.setBounds(50,180,100,20);
        
        t1.setBounds(200,100,100,20);
        t2.setBounds(200,140,100,20);
        t3.setBounds(200,180,100,20);
        
        b.setBounds(50,250,50,20);
        b1.setBounds(290,250,50,20);
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        
        f.add(t1);
        f.add(t2);
        f.add(t3);
       
        
        f.add(b);
        f.add(b1);
        f.setLayout(null);
        f.setSize(400,300);
        f.setLocation(500,200);
        f.setVisible(true);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                        
                System.out.println("Client's nums to be send to the server");
                int num1 = Integer.parseInt(t1.getText());
                System.out.println(num1);
                int num2 = Integer.parseInt(t2.getText());
                System.out.println(num2);

                try {

                    toServer.writeInt(num1);
                    toServer.writeInt(num2);

                    int answer;
                    answer = fromServer.readInt();
                    System.out.println("Server returned the result of: "+answer);
                    

                    t3.setText(Integer.toString(answer));

                } catch (IOException ex) {
                }
                
            }

        });
        
         b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               System.exit(0);
            }
         });
         
    }
}
         
 
    
    


