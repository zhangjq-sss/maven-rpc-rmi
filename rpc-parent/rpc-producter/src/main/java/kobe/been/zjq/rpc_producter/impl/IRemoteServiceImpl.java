package kobe.been.zjq.rpc_producter.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_service.IRemoteService;

public class IRemoteServiceImpl extends UnicastRemoteObject implements IRemoteService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IRemoteServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public User getUserById(Long id) throws RemoteException {
		User user = new User();
		user.setId(id);
		user.setUserName("zjq_" + id);
		user.setPassword("123456_" + id);
		return user;
	}

}
