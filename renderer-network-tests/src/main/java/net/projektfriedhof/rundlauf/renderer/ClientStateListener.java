package net.projektfriedhof.rundlauf.renderer;

import net.projektfriedhof.rundlauf.messages.ClientState;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientStateListener extends Listener {

	 public void received (Connection connection, Object object) {
         if (object instanceof ClientState) {
        	 ClientState clientState = (ClientState)object;
        	 
        	 System.out.println(clientState.getCmdType() + " - " + clientState.getData());
        	 
         }
      }
	
}
