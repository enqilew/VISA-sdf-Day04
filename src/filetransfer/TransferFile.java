package filetransfer;

import java.io.*;

public class TransferFile {
    
    public static void main(String[] args) throws Exception {
        if (args.length <= 0) {
            System.err.println("Missing file name");
            System.exit(-1);
        }

        // Create a file object with the input argument
        File file = new File(args[0]);

        //File name
        String fileName = file.getName();
        // Size
        //long fileSize = file.length();

        System.out.printf("Transferring file %s\n", fileName);

        SendFile sendFile = new SendFile("localhost", Constants.PORT, file);
        sendFile.send();
    }

}
