package net.projektfriedhof.rundlauf.messages;

/**
 * All message classes are held intentionally smal!
 * @author falko
 *
 */
public class ClientState {

	private int screenNum;
	private CommandType cmdType;
	private String data;
	
	public int getScreenNum() {
		return screenNum;
	}
	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
	}
	public CommandType getCmdType() {
		return cmdType;
	}
	public void setCmdType(CommandType cmdType) {
		this.cmdType = cmdType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
