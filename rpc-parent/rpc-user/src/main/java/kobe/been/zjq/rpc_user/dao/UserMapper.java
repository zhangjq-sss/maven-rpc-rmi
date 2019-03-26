package kobe.been.zjq.rpc_user.dao;

import java.util.List;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_utils.generic.GenericDao;

public interface UserMapper extends GenericDao<User, Long>{
    
    List<User> listAll();
}