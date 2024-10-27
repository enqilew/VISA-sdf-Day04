package workshop;

public class Server {

    public static void main(String[] args) {
        
        int port = 12345;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            System.out.println("Invalid arguments input");
        }


    }
    
}
