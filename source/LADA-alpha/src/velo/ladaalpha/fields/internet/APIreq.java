package velo.ladaalpha.fields.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class APIreq {
	private static final String USER_AGENT = "Mozilla/5.0";
	public static HttpResponse GET(String url) {
		HttpResponse res = new HttpResponse();
		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        HttpURLConnection httpURLConnection = null;
		try {
			httpURLConnection = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			httpURLConnection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        try {
			res.setResponseCode(httpURLConnection.getResponseCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(res.getResponseCode() == HttpURLConnection.HTTP_OK) {
        	BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String inputLine;
            StringBuffer response = new StringBuffer();

            try {
				while ((inputLine = in .readLine()) != null) {
				    response.append(inputLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} try {
				in .close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            res.setBody(response.toString());
        }
        
        for (int i = 1; i <= httpURLConnection.getHeaderFields().size(); i++) {
        	res.addHeader(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
		
		return res;
	}
	public static HttpResponse POST(String url, String params) {
		URL obj = null;
		HttpResponse res = new HttpResponse();
		try {
			obj = new URL(url);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        HttpURLConnection httpURLConnection = null;
		try {
			httpURLConnection = (HttpURLConnection) obj.openConnection();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			httpURLConnection.setRequestMethod("POST");
		} catch (ProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        httpURLConnection.setDoOutput(true);
        OutputStream os = null;
		try {
			os = httpURLConnection.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			os.write(params.getBytes());
			os.flush();
	        os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			res.setResponseCode(httpURLConnection.getResponseCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (res.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String inputLine;
            StringBuffer response = new StringBuffer();

            try {
				while ((inputLine = in.readLine()) != null) {
				    response.append(inputLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            try {
				in .close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            res.setBody(response.toString());

        }
        for (int i = 1; i <= httpURLConnection.getHeaderFields().size(); i++) {
        	res.addHeader(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return res;
	}
	
	
}
