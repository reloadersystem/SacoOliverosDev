package pe.sacooliveros.apptablet.NewsPaper;

import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceNoticia {

    public String gmaildatos;
    public static String urlRequest = "";
    private ProgressBar progressBar;
    static String urldatavisor;
    static String urlfinal;


    private String host = "192.168.1.4";
    private Integer port = 8080;
    public static String emailrecibido;
    public static final String WEB_SERVICE_NOT_CONNECTED = "Not Connected";


    public static void urljson(String urlinfo) {
        urlfinal = urlinfo;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public static String requestFromWebService(String host, Integer port, String method, String... params) {
        String rString = "";
        int response;
        StringBuilder resSBuilder;
        try {

            URL wsURL = new URL(urlfinal);
            HttpURLConnection conn = (HttpURLConnection) wsURL.openConnection();
            response = conn.getResponseCode();
            Log.e("response", String.valueOf(response));
            resSBuilder = new StringBuilder();
            if (response == HttpURLConnection.HTTP_OK) {
                InputStream iStream = new BufferedInputStream(conn.getInputStream());
                BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
                String rowString;
                int cnt = 0;
                while ((rowString = bReader.readLine()) != null) {
                    cnt += 1;
                    resSBuilder.append(rowString);
                }
                rString = resSBuilder.toString();
            }
        } catch (IOException e) {
            rString = WEB_SERVICE_NOT_CONNECTED;
        } catch (Exception errString) {
            rString = WEB_SERVICE_NOT_CONNECTED;
        }
        return rString;
    }

    public static void urldata(String urlRequest) {
        emailrecibido = urlRequest;
    }

    static Boolean isValidResponse(String rString) {
        if (rString == null) {
            return false;
        }
        if (rString.isEmpty()) {
            return false;
        }
        return !rString.equals(WEB_SERVICE_NOT_CONNECTED);
    }
}