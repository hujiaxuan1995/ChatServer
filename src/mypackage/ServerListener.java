package mypackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread{


	public void run(){
		try {
			System.out.printf("ServerListener",0);
			ServerSocket serverSocket=new ServerSocket(30007);
			while(true){
				Socket socket=serverSocket.accept();
				JOptionPane.showMessageDialog(null,"有客户端连接到端口12345");
				ChatSocket chatsocket=new ChatSocket(socket);
				chatsocket.start();
				ChatManager.getChatManager().add(chatsocket);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
