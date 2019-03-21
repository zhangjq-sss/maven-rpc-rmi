package kobe.been.zjq.rpc_producter.impl;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_service.IRemoteService;

public class IRemoteServiceImpl implements IRemoteService{

	@Override
	public User getUserById(Long id){
		User user = new User();
		user.setId(id);
		user.setUserName("zjq_" + id);
		user.setPassword("123456_" + id);
		return user;
	}

}
