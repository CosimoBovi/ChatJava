package clientChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadInvio implements Runnable{
	
	private Scanner sc ;
	private PrintWriter out;
	private Socket socket;
	 
	public ThreadInvio (Socket socket) throws IOException {
		this.socket=socket;
		sc = new Scanner(System.in);
		out = new PrintWriter(socket.getOutputStream());
	}
	
	public void run() {
		String message;
		boolean primo=true;
		while(!Thread.interrupted()){
			if (primo) {
				System.out.println("dammi il nome utente");
				primo=false;
			}
			message = sc.nextLine();
			out.println(message);
			out.flush();
        }
	}
}
