package serverChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {

	public static void main(String[] args) {
		final int PORT = 5500;
        try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			ArrayList<Thread> listaThreadConnessioni = new ArrayList<Thread>();
			ListaClient listaClient = new ListaClient();
        
			System.out.println("Server started...");
			System.out.println("Wating for clients...");
			
			
			while(true) {
				Socket nuovoClient = serverSocket.accept();
				listaClient.addClient(nuovoClient);
				Thread connessioneThread = new Thread( new ThreadConnessione(nuovoClient, listaClient));
				listaThreadConnessioni.add(connessioneThread);
				listaThreadConnessioni.get(listaThreadConnessioni.size()-1).start();
			}
			
        
        } catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
