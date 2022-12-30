/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verify;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author KHOA
 */
public class VerifyRecaptcha {
    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    
    
    //Input Your Secret key here
    public static final String secret = "6LccXXwjAAAAAEIceFeFlU1YHbPp8R1ZdqrnCGuo";
    
    
    public final static String USER_AGENT = "Mozilla/5.0";
    public static String response1;
    
    public static boolean verify(String gReacptchaResponse){
        if(gReacptchaResponse == null || "".equals(gReacptchaResponse)){
            return false;
        }
        try {
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            
            String postParams = "secret=" + secret + "&response=" + gReacptchaResponse;
            
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            
            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + postParams);
            System.out.println("Response Code: " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            
            response1 = response.toString();
            System.out.println(response.toString());
            
            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            return jsonObject.getBoolean("success");
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String returnResponse(){
        return response1;
    }
}
