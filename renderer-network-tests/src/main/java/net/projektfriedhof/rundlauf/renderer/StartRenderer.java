package net.projektfriedhof.rundlauf.renderer;

import java.io.IOException;
import java.net.InetAddress;

import net.projektfriedhof.rundlauf.messages.ClientState;
import net.projektfriedhof.rundlauf.messages.CommandType;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

public class StartRenderer {
	
	Client client = new Client();
	
	private boolean isRunning = true;
	
	public static void main(String[] args) {
		
		int screenNum = Integer.parseInt(args[0]);
		
		new StartRenderer().run(screenNum);
	}

	private void run(Integer screenNum) {
		
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
		register.setScreenNum(screenNum);
		client.sendTCP(register);
		
		while(isRunning){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
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
