package net.projektfriedhof.rundlauf.server.subsystem.networking;

import java.io.IOException;

import net.projektfriedhof.rundlauf.messages.ClientState;
import net.projektfriedhof.rundlauf.messages.CommandType;
import net.projektfriedhof.rundlauf.server.ClientManager;

import com.esotericsoftware.kryonet.Server;

/**
 * The network subsystem handles state/connection tracking and exposes the 
 * {@link ClientManager} for other subsystem to be able to communicate with the clients 
 * 
 * @author falko
 *
 */
public class NetworkSubsystem {

	private Server server;
	private ClientManager clientManager;
	
	
	public NetworkSubsystem(ClientManager clientManager) {
		this.clientManager = clientManager;
	}


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
		server.addListener(clientManager);
	}


	private void registerClasses() {
		server.getKryo().register(ClientState.class);
		server.getKryo().register(CommandType.class);
	}


	public void shutdown(){
		server.stop();
	}
	
}
