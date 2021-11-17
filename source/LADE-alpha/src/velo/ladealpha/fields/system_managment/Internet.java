package velo.ladealpha.fields.system_managment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PortScanner {

	public static ArrayList<Integer> scan(String ip) throws InterruptedException, ExecutionException {
		final ExecutorService es = Executors.newFixedThreadPool(20);
		final int timeout = 200;
		final List<Future<ScanResult>> futures = new ArrayList<>();
		for (int port = 1; port <= 65535; port++) {
			futures.add(portIsOpen(es, ip, port, timeout));
		}
		ArrayList<Integer> ports = new ArrayList<Integer>();
		es.awaitTermination(200L, TimeUnit.MILLISECONDS);
		int openPorts = 0;
		for (final Future<ScanResult> f : futures) {
			if (f.get().isOpen()) {
				openPorts++;
				int port = f.get().getPort();				
				ports.add(port);
			}
		}		
		return ports;
	}

	public static Future<ScanResult> portIsOpen(final ExecutorService es, final String ip, final int port,
			final int timeout) {
		return es.submit(new Callable<ScanResult>() {
			@Override
			public ScanResult call() {
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(ip, port), timeout);
					socket.close();
					return new ScanResult(port, true);
				} catch (Exception ex) {
					return new ScanResult(port, false);
				}
			}
		});
	}

	public static class ScanResult {
		private int port;

		private boolean isOpen;

		public ScanResult(int port, boolean isOpen) {
			super();
			this.port = port;
			this.isOpen = isOpen;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public boolean isOpen() {
			return isOpen;
		}

		public void setOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}

	}
}

public class Internet {
	public static ArrayList<Integer> scanPorts(String ip) {
		try {
			return PortScanner.scan(ip);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getURLIP(String s) {
		String o = null;
		try {
			InetAddress ip = InetAddress.getByName(new URL(s).getHost());
			o = ip.getHostAddress();
		} catch (UnknownHostException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public static String getLocalIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;

		}
	}

	public static String getPublicIP() {
		String systemipaddress = "";
		try {
			URL url_name = new URL("http://bot.whatismyipaddress.com");
			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
			systemipaddress = sc.readLine().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return systemipaddress;
	}

	public static boolean reachHost(String ip) {
		InetAddress addr = null;
		try {
			addr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return addr.isReachable(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static Boolean isConnected() {
		try {
			URL url = new URL("http://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
