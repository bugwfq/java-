package net.netCommunication.com.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import net.netCommunication.com.fuqiang.entity.User;

public class Servers {
	private static HashMap<User,Socket> sockets;
	private static ServerSocket servers;
	
	public Servers() throws IOException{
		this(8888);
	}
	public Servers(int port) throws IOException{
		servers = new ServerSocket(port);
		sockets = new HashMap<User,Socket>();
	}
	public void close() throws IOException{
		servers.close();
	}
	
	public HashMap<User, Socket> getSockets() {
		return sockets;
	}
	
	public Socket getSocket(User user) {
		return sockets.get(user);
	}
	
	public ServerSocket getServers() {
		return servers;
	}
	
}
