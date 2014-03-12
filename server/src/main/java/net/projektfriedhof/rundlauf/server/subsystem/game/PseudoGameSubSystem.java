package net.projektfriedhof.rundlauf.server.subsystem.game;

import net.projektfriedhof.rundlauf.server.ClientManager;


public class PseudoGameSubSystem extends Thread{

	boolean running = true;
	
	ClientManager clients;
	
	public PseudoGameSubSystem(ClientManager clientManager) {
		this.clients = clientManager;
	}
	
	@Override
	public void run() {
		System.out.println("Game Thread started");
		while(running){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Broadcast!");
			clients.broadcast("Wassup Client Wanna Play a game?");
			
		}
		
	}
	
}
