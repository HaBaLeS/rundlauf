package net.projektfriedhof.rundlauf.renderer;

import java.io.IOException;
import java.net.InetAddress;

import com.esotericsoftware.kryonet.Client;

public class StartRenderer {
	
	public static void main(String[] args) {
		
		Client client = new Client();
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
		
	}
}
