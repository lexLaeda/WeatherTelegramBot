package jason;

import exception.download.DownloadException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyDownLoader {


    public static String getContent(String adress){
        StringBuilder sb = new StringBuilder();
        InputStream stream = getInputStream(adress);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            while (reader.ready()){
                sb.append(reader.readLine());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    private static InputStream getInputStream(String adress){
        InputStream stream = null;
        try {
            URL url = new URL(adress);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            stream = con.getInputStream();
        } catch (MalformedURLException e) {
            throw new DownloadException(adress);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stream;
    }
}
