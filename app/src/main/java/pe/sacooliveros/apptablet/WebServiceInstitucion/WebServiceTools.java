package pe.sacooliveros.apptablet.WebServiceInstitucion;

import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceTools {


    public String gmaildatos;

    public static String urlRequest = "";

    private ProgressBar progressBar;
    private String host = "192.168.1.4";


    private Integer port = 8080;


    public static String emailrecibido;


    public static final String WEB_SERVICE_NOT_CONNECTED = "Not Connected";


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

            //String   urlRequestdata= String.format("http://pruebasiiaa.sacooliveros.edu.pe:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/obtenerDatos/%s", params[0]);
         String urlRequestdata = String.format("http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/obtenerDatos/%s", params[0]);
         //String   urlRequestdata= String.format("http://http://172.16.2.53:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/obtenerDatos/%s", params[0]);

            URL wsURL = new URL(urlRequestdata);


            //URL wsURL= new URL(emailrecibido);  .. enviado desde SAcoWSConsulta


            HttpURLConnection conn = (HttpURLConnection) wsURL.openConnection();

            response = conn.getResponseCode();

            Log.d("response", String.valueOf(response));

            resSBuilder = new StringBuilder();

            if (response == HttpURLConnection.HTTP_OK) {
                InputStream iStream = new BufferedInputStream(conn.getInputStream());
                BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));


                String rowString;

                int cnt = 0;
                while ((rowString = bReader.readLine()) != null)
                //hasta que haya llenado todo
                {
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