package server.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import constant.BizConstant;
import database.UserDao;
import server.vo.MessageVo;
import server.vo.user.UserVo;

public class SocketThread implements Runnable{

    private Socket socket;
    public ObjectInputStream ois;
	public ObjectOutputStream oos;
	public BufferedOutputStream bos; 
	public BufferedInputStream bis;
    private UserDao userDao = null;


    public SocketThread(Socket socket) {

        System.out.println("Client 접속 ..........");
        System.out.println("Port : " + socket.getPort());
        System.out.println("IP : "+ socket.getInetAddress().getHostAddress());
        this.socket = socket;
        
    }

    @Override
    public void run() {
        
        // Socket에 넘겨줄 In Out Stream 객체 생성
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
       

             while(true){
                userDao = new UserDao();
                 Object obj = ois.readObject();
                 if(obj != null){

                    MessageVo msg = (MessageVo)obj;

                    if(msg.getMessage() == BizConstant.JOIN){
                        UserVo user = msg.getUserVo();
                        userDao.joinMember(user);

                    }
                    System.out.println("사용자가 보낸 메시지를 해독하질 못했습니다.");
                 }
             }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
    }
    
}
