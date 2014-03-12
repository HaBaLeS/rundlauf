package net.projektfriedhof.rundlauf.server;

import java.util.HashMap;
import java.util.Map;

import net.projektfriedhof.rundlauf.messages.ClientState;
import net.projektfriedhof.rundlauf.messages.CommandType;
import net.projektfriedhof.rundlauf.server.beans.Renderer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

/**
 * This class keeps track of all Renderer (also network connections)
 * 
 * @author falko
 *
 */
public class ClientManager extends Listener{

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
	}

	public void broadcast(String string) {
		for(Renderer r: renderer.values()){
			ClientState st =r.getClientState();
			st.setCmdType(CommandType.log_message);
			st.setData(string);
			r.getConnection().sendUDP(st);
		}
	};
	
	
	//getRendererByScreenNr
	
	//getRendererByConnection
	
	 public void received (Connection connection, Object object) {
		 Renderer cl = renderer.get(connection);
		 
         if (object instanceof ClientState) {
        	 ClientState clientState = (ClientState)object;
        	 if(clientState.getCmdType() == CommandType.client_register_request){
        		 cl.setScreenNum(clientState.getScreenNum());
        		 broadcast("We have a New Screen With Number: " + cl.getScreenNum() + " All screen will revice a new Position");
        	 }
        	 CommandDispatcher.put(Commands.reorderScreens);
         }
      }
	
	
}
