import com.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

       /* try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");*/

           /* while (true)
                try (
                        Socket socket = server.accept();
                        BufferedWriter writer =
                                new BufferedWriter(
                                        new OutputStreamWriter(
                                                socket.getOutputStream()));
                        BufferedReader reader =
                                new BufferedReader(
                                        new InputStreamReader(
                                                socket.getInputStream()));
                ) {
                    String request = reader.readLine();
                    System.out.println("request = " + request);
                    //    String response = "HELLO FROM SERVER " + request.length();
                    String response = (int) Math.random() * 30 - 10 + "";
                    writer.write(response);
                    System.out.println("Response = " + response);
                    writer.newLine();
                    writer.flush();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
*/

//////////////////////////////////////////////////////////////
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");

            while (true) {

                Phone phone = new Phone(server);

                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("request = " + request);
                    String response = (int) (Math.random() * 30 - 10) + "";
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {

                    }
                    phone.writeLine(response);
                    System.out.println("Response = " + response);
                    try {
                        phone.close();
                    } catch (IOException e) {
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
