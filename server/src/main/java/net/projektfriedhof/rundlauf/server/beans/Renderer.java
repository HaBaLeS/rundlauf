package net.projektfriedhof.rundlauf.server.beans;

import net.projektfriedhof.rundlauf.messages.ClientState;

import com.esotericsoftware.kryonet.Connection;

/**
 * 
 * @author falko
 *
 */
public class Renderer implements Comparable<Renderer>{

	private Connection connection;
	private Integer screenNum = -1;
	//ScreenType //medium largen, smal -- enum in shared!
	
	private ClientState state = new ClientState();
	
	/**
	 * Create new Renderer
	 * @param con
	 * @param screen
	 */
	public Renderer(Connection con) {
		this.connection = con;
		state.setScreenNum(screenNum);
		
	}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
		state.setScreenNum(screenNum);
	}
	
	public Integer getScreenNum() {
		return screenNum;
	}
	
	@Override
	public int compareTo(Renderer o) {
		return screenNum.compareTo(o.getScreenNum());
	}
	
	public Connection getConnection() {
		return connection;
	}

	public ClientState getClientState() {
		return state;
	}
	
	
}
