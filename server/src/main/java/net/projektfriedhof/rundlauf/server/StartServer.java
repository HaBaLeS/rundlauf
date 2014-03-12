package net.projektfriedhof.rundlauf.server;

import net.projektfriedhof.rundlauf.server.subsystem.game.PseudoGameSubSystem;
import net.projektfriedhof.rundlauf.server.subsystem.networking.NetworkSubsystem;


class StartServer {

	NetworkSubsystem network;
	ClientManager clientManager;
	
	public static void main(String[] args) {
		new StartServer().run();
	}

	private void run() {
		
		//Init all the subsystems
		clientManager = new ClientManager();
		network = new NetworkSubsystem(clientManager);
		
		//start all the subsystems
		network.startUp();

		PseudoGameSubSystem game = new PseudoGameSubSystem(clientManager);
		game.start();
	}

}
