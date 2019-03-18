package kobe.been.zjq.rpc_producter.product.provider;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kobe.been.zjq.rpc_producter.impl.IRemoteServiceImpl;
import kobe.been.zjq.rpc_service.IRemoteService;

public class IRemoteTest {
	public static void main(String[] args) throws RemoteException, NamingException {
		IRemoteService service = new IRemoteServiceImpl();
		Context context = new InitialContext();
		LocateRegistry.createRegistry(8088);
		context.bind("rmi://localhost:8088/remote", service);
	}
}
