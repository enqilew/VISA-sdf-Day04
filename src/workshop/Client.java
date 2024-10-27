package workshop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        int port =12345;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            System.err.println("Invalid arguments input");
        }

        try {
            System.out.println("Connecting to the server");
            Socket sock = new Socket("localhost", port);
            System.out.println("Connected!");

            // Get the outputstream
            OutputStream os = sock.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            // Get the inputstream
            InputStream is = sock.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            Console cons = System.console();
            String cookie = "";
            String keyboardInput = "";
            while (!keyboardInput.toLowerCase().equals("quit")) {
                keyboardInput = cons.readLine("Enter any key to request for a cookie ('quit' to terminate)");

                dos.writeUTF(keyboardInput);
                dos.flush();

                cookie = dis.readUTF();
                System.out.println(cookie);
            }

            dos.close();
            bos.close();
            os.close();

            dis.close();
            bis.close();
            is.close();

        } catch (EOFException eofException) { 

        } 

    }

    
}
