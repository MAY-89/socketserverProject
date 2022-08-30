package server.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketService {
    
    public static final int PORT = 9000;

    public ServerSocket serverSocket;
    public Socket client;
    private ExecutorService pool;

    public  ServerSocketService() {

        serverBind();
    }

    private void serverBind() {
        System.out.println("서버 오픈...............");
        
        Thread thread = new Thread(()->{
            try {
                pool = Executors.newFixedThreadPool(30);
                serverSocket = new ServerSocket(PORT);
                while(true){
                    client = serverSocket.accept();
                    pool.submit(new SocketThread(client));
                }
            } catch (IOException e) {
    
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
