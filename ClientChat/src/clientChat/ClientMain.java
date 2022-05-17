package clientChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	
	 public static void main(String[] args){
		 Socket clientSocket; 
		 
		 try {
			clientSocket = new Socket("127.0.0.1",5500);
			Thread invioThread = new Thread(new ThreadInvio(clientSocket));
			Thread riceviThread = new Thread(new ThreadRicevi(clientSocket));
			invioThread.start();
			riceviThread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
     
	 }
}
