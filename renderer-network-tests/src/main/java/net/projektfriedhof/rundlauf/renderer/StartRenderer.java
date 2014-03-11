package net.projektfriedhof.rundlauf.renderer;

import java.io.IOException;
import java.net.InetAddress;

import net.projektfriedhof.rundlauf.messages.ClientState;
import net.projektfriedhof.rundlauf.messages.CommandType;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

public class StartRenderer {
	
	Client client = new Client();
	
	public static void main(String[] args) {
		new StartRenderer().run();
	}

	private void run() {
		
		initSubsystems();
		
		registerListeners();
		
		InetAddress address = client.discoverHost(54777, 5000);
		if(address == null){
			System.out.println("Error could not find Server on Lan!");
			System.exit(0);
		}
		System.out.println("Connecting to " + address);
		client.start();
		try {
			client.connect(5000, address, 54555, 54777);
		} catch (IOException e) {
			throw new RuntimeException("Failed to connect to Server");
		}
		
		ClientState register = new ClientState();
		register.setCmdType(CommandType.client_register_request);
		client.sendTCP(register);
		
		
		
	}

	private void registerListeners() {
		client.addListener(new ClientStateListener());
		
	}

	private void initSubsystems() {
		Kryo kryo = client.getKryo();
		kryo.register(ClientState.class);
		kryo.register(CommandType.class);
		
	}
}
