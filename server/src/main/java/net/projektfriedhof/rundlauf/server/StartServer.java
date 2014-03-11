package net.projektfriedhof.rundlauf.server;


class StartServer {

	NetworkSubsystem network;
	
	public static void main(String[] args) {
		new StartServer().run();
	}

	private void run() {
		
		//Init all the subsystems
		network = new NetworkSubsystem();
		
		//start all the subsystems
		network.startUp();

	}

}
