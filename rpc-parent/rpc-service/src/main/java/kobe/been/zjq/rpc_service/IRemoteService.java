package kobe.been.zjq.rpc_service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import kobe.been.zjq.rpc_domain.user.User;

public interface IRemoteService extends Remote{
	//重要 重要 重要 一定要抛出RemoteException异常
	User getUserById(Long id) throws RemoteException;
}
