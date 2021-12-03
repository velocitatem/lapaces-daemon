package velo.ladaalpha.fields.internet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

// TODO: Auto-generated Javadoc
/**
 * The Class APIreq.
 */
public class APIreq {
	
	/** The Constant USER_AGENT. */
	private static final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * Image.
	 *
	 * @param path the path
	 * @param name the name
	 * @return the string
	 */
	public static String IMAGE(String path, String name) {
		URL url = null;
		try {
			url = new URL(path);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InputStream in = null;
		try {
			in = new BufferedInputStream(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		try {
			while (-1!=(n=in.read(buf)))
			{
			   out.write(buf, 0, n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] response = out.toByteArray();
		FileOutputStream fos = null;
		String outPath = name+".jpg";				
		try {
			fos = new FileOutputStream(outPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outPath;
	}
	
	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @return the http response
	 */
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
	
	/**
	 * Post.
	 *
	 * @param url the url
	 * @param params the params
	 * @return the http response
	 */
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
