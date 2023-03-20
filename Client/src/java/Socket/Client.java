package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
    public static void main(String[] args) {
        try {
            
            Socket connectSocket = new Socket("localhost", 3000);
            
            BufferedReader request = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
            PrintStream send = new PrintStream(connectSocket.getOutputStream());
            
            while(true){
                String message = request.readLine();
                System.out.println(message);
            
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                String letter = console.readLine();
                send.println(letter);
            }
        } 
        
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}