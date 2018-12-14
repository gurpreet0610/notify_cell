import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class sendSMS {
    public String sendSms(String mess,String number) {
        try {
            String apiKey = "apikey=" + "Vzw3ZL8CVX8-ql97jtceMBhzqLD1ShXhEYDTmqZ8t8";
            String message = "&message=" + mess;
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "91"+number;

            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
    public static void main(String args[])
    {
        sendSMS sd=new sendSMS();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number you want to send message (Don't enter Country code):");
        String number = sc.next();
        System.out.println("Enter the message :");
        String message = sc.next();

        String response=sd.sendSms(message,number);
        System.out.println(response);


    }
}