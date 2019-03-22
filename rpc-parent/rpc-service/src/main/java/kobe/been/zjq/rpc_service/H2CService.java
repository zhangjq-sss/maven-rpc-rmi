package kobe.been.zjq.rpc_service;

import kobe.been.zjq.rpc_domain.user.User;

public interface H2CService{
	User getUserById(Long id);
}
