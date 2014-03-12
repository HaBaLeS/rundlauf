package net.projektfriedhof.rundlauf.server;

import java.util.HashMap;
import java.util.Map;

import net.projektfriedhof.rundlauf.server.beans.Renderer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

/**
 * This class keeps track of all Renderer (also network connections)
 * 
 * @author falko
 *
 */
public class RendererManager extends Listener{

	Map<Connection,Renderer> renderer = new HashMap<>(100);
	
	@Override
	public void connected(Connection connection) {
		Renderer newRrend = new Renderer(connection);
		renderer.put(connection,newRrend);
		//announce upcoming client to game Subsystem
	}
	
	public void disconnected(Connection connection) {
		renderer.remove(connection);
		//announce disconnected Client to game subsystem
	};
	
	
	//getRendererByScreenNr
	
	//getRendererByConnection
	
	
}
