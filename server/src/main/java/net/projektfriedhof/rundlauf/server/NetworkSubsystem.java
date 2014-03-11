package net.projektfriedhof.rundlauf.server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

public class NetworkSubsystem {

	private Server server;
	
	public void startUp() {
		server = new Server();
		server.start();
		try {
			server.bind(54555, 54777);
		} catch (IOException e) {
			throw new RuntimeException("Could not Bind Server to Ports!", e);
		}
	}

	
	public void shutdown(){
		server.stop();
	}
	
}
