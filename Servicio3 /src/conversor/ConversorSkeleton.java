/**
 * ConversorSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package conversor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *  ConversorSkeleton java skeleton for the axisService
 */
public class ConversorSkeleton{
    /**
     * Auto generated method signature
     *
     * @param getConversion
     * @return getConversionResponse
     */
    public conversor.GetConversionResponse getConversion(
        conversor.GetConversion getConversion) throws IOException, JSONException{
        String from = getConversion.getArgs0();
        String cantidad = getConversion.getArgs1();
        String to = getConversion.getArgs2();

        GetConversionResponse resposta = new GetConversionResponse();

        InputStream is = new URL("https://api.exchangeratesapi.io/latest?base="+from).openStream();
                try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                StringBuilder sb = new StringBuilder();
                int cp;
                while ((cp = rd.read()) != -1) {
                    sb.append((char) cp);
                }
                String jsonText =  sb.toString();
                JSONObject json = new JSONObject(jsonText);
                //System.out.println("1 "+from+" => "+json.getJSONObject("rates").get(to)+" "+to);
                String result = json.getJSONObject("rates").get(to).toString();


                String resp = ("1 "+from+" = >"+result+" "+to);
                System.out.println(resp);
                float desde = Float.parseFloat(cantidad);
                float resultado = Float.parseFloat(result);
                


                String URLCalculadora = "http://localhost:8080/axis2/services/Calculadora/";

                try {
                    URL url1 = new URL(URLCalculadora + "multiplicar?args0="+desde+"&args1="+resultado);

                    URLConnection conn = url1.openConnection();
                    //System.out.println(conn.getInputStream().toString());
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                                                conn.getInputStream()));
                    String inputLine;
                    String total="";
                    while ((inputLine = in.readLine()) != null) 
                        if(inputLine!=null){
                            //System.out.println(inputLine);
                            total = total + inputLine;
                        }
                    in.close();
                    resposta.set_return(cantidad + " " + from + " => "+total.replaceAll("[^0-9.]", "").substring(3) + " " + to);
                    return resposta;
                } catch (IOException e) {
                    e.printStackTrace();
                    resposta.set_return("ERROR");
                    return resposta;
                    }
            } finally {
                is.close();
            }



    }
}
