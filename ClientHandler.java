import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandlers =new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String Username;

    public ClientHandler(Socket socket){
        try{
            this.socket=socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.Username=bufferedReader.readline();
            clientHandlers.add(this);
            message(Username +"has joined chat.");
        }catch(IOException e){
            closeAll(socket, bufferedReader,bufferedWriter);
        }
    }
    @Override
    public void run() {
        String clientmessage;
        while (socket.isConnected()){
            try{
                clientmessage=bufferedReader.readLine();
                message(clientmessage);
            }catch(IOException e){
                closeAll
            }
        }
    }
}
