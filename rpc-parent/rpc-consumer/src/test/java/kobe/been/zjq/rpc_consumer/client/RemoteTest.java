package kobe.been.zjq.rpc_consumer.client;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kobe.been.zjq.rpc_service.IRemoteService;

public class RemoteTest {
	public static void main(String[] args) throws NamingException, RemoteException{
		Context context = new InitialContext();
		IRemoteService service = (IRemoteService) context.lookup("rmi://localhost:8088/remote");
		System.out.println(service.getUserById(1l));		
	}
}
