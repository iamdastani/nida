import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestExample {
    public static void main(String[] args) {
        try {
            String NIN = "YOUR NIDA ID";
            String url = "https://ors.brela.go.tz/um/load/load_nida/" + NIN;
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Length", "0");
            con.setRequestProperty("Content-Type", "application/json");
            
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            if (responseCode == 200) {
                System.out.println("Request was successful");
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("Failed to make request. Status code: " + responseCode);
                System.out.println("Response: " + response.toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
