package application;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Model implements Runnable {


    Socket MyClient = null;
    DataInputStream input = null;
    String ip = "unknown";
    String remoteHostName = "unknown";
    String clientIPAddr = "unknown";
    String clientPortNum = "unknown";
    String success = "0";
    int failure = 0;

    //hanyszor kapcsolodjon
    int loop = 0;

    //szerver
    String host = null;
    String port = "11111";


    public void connect(String host, int port) {

        try {
            MyClient = new Socket(host, port);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        try {
            input = new DataInputStream(MyClient.getInputStream());
            ip = input.readLine();
            remoteHostName = input.readLine();
            clientIPAddr = input.readLine();
            success = input.readLine();

            input.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {

        for (int i=0; i<loop; i++){
            try {
                MyClient = new Socket(host, Integer.parseInt(port));
            }
            catch (IOException e) {
                System.out.println(e);
            }

            try {
                input = new DataInputStream(MyClient.getInputStream());
                ip = input.readLine();
                remoteHostName = input.readLine();
                clientIPAddr = input.readLine();
                success = input.readLine();

                input.close();
            }
            catch (IOException e) {
                System.out.println(e.toString());
                failure++;
            }
        }

    }
}
