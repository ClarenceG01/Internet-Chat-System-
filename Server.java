import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket =serverSocket;
    }
    public void startServer(){
         try {
            
            while (!serverSocket.isClosed()){
                Socket socket =serverSocket.accept();
                System.out.println("New Client Connected");
                ClientHandler clientHandler =new ClientHandler(socket);

                Thread thread =new Thread(clientHandler);
                thread.start();
            }
         }catch (IOException e){

         }
    }
    public void closeServerSocket(){
        try{
            if(serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    } 
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(port 5000);
        Server server =new Server(serverSocket);
        server.startServer();
    }
}