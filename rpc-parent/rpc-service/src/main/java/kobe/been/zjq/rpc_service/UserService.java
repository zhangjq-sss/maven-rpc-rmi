package kobe.been.zjq.rpc_service;

import java.util.List;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_utils.generic.GenericService;


public interface UserService extends GenericService<User, Long>{
	List<User> listAll();
}
