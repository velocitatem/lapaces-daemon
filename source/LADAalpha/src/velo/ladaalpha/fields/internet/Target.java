package velo.ladaalpha.fields.internet;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc

/**
 * The Class Target.
 */
public class Target {

    /**
     * The hostname.
     */
    private String ip, hostname;

    /**
     * The open ports.
     */
    private ArrayList<Integer> openPorts;

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip.
     *
     * @param ip the new ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Gets the hostname.
     *
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the hostname.
     *
     * @param hostname the new hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Gets the open ports.
     *
     * @return the open ports
     */
    public ArrayList<Integer> getOpenPorts() {
        return openPorts;
    }

    /**
     * Sets the open ports.
     *
     * @param openPorts the new open ports
     */
    public void setOpenPorts(ArrayList<Integer> openPorts) {
        this.openPorts = openPorts;
    }

    /**
     * Instantiates a new target.
     *
     * @param ip        the ip
     * @param hostname  the hostname
     * @param openPorts the open ports
     */
    public Target(String ip, String hostname, ArrayList<Integer> openPorts) {
        super();
        this.ip = ip;
        this.hostname = hostname;
        this.openPorts = openPorts;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "[ip=" + ip + ", hostname=" + hostname + ", openPorts=" + openPorts + "]";
    }

}
