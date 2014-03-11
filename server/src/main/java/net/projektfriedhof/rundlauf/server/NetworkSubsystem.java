package net.projektfriedhof.rundlauf.server;

import java.io.IOException;

import net.projektfriedhof.rundlauf.messages.ClientState;
import net.projektfriedhof.rundlauf.messages.CommandType;

import com.esotericsoftware.kryonet.Server;

public class NetworkSubsystem {

	private Server server;
	
	public void startUp() {
		server = new Server();
		registerClasses();
		
		registerListeners();
		
		server.start();
		try {
			server.bind(54555, 54777);
		} catch (IOException e) {
			throw new RuntimeException("Could not Bind Server to Ports!", e);
		}
	}

	
	private void registerListeners() {
		server.addListener(new ClientStateListener());
	}


	private void registerClasses() {
		server.getKryo().register(ClientState.class);
		server.getKryo().register(CommandType.class);
	}


	public void shutdown(){
		server.stop();
	}
	
}
