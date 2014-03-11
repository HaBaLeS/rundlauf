package net.projektfriedhof.rundlauf.server.beans;

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
	
	/**
	 * Create new Renderer
	 * @param con
	 * @param screen
	 */
	public Renderer(Connection con) {
		this.connection = con;
	}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
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
	
	
}
