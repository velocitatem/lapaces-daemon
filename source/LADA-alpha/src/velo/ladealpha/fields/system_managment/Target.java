package velo.ladealpha.fields.system_managment;

import java.util.ArrayList;

public class Target {
	private String ip, hostname;
	private ArrayList<Integer> openPorts;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public ArrayList<Integer> getOpenPorts() {
		return openPorts;
	}
	public void setOpenPorts(ArrayList<Integer> openPorts) {
		this.openPorts = openPorts;
	}
	public Target(String ip, String hostname, ArrayList<Integer> openPorts) {
		super();
		this.ip = ip;
		this.hostname = hostname;
		this.openPorts = openPorts;
	}
	@Override
	public String toString() {
		return "[ip=" + ip + ", hostname=" + hostname + ", openPorts=" + openPorts + "]";
	}
	
}
