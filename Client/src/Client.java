import com.Phone;

import java.io.*;
import java.net.Socket;

/*
public class Client {
    public static void main(String[] args) {

        try (
                Socket socket = new Socket("127.0.0.1", 8000);
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
        ) {
            System.out.println("Connected to server");
            String request = "Moscow";
            System.out.println("Request:" + request);
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("response = " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

////////////////////////////////////////////////////////////////////////////////////
public class Client {
    public static void main(String[] args) {

        try (Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");

            String request = "Moscow";
            System.out.println("Request:" + request);
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println("response = " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
