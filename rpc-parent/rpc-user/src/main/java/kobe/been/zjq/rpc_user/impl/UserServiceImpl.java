package kobe.been.zjq.rpc_user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_service.UserService;
import kobe.been.zjq.rpc_user.config.mybatis.DbContextHolder.DbType;
import kobe.been.zjq.rpc_user.config.mybatis.ReadOnlyConnection;
import kobe.been.zjq.rpc_user.dao.UserMapper;
import kobe.been.zjq.rpc_utils.generic.GenericDao;
import kobe.been.zjq.rpc_utils.generic.GenericServiceImpl;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	
	
	@Autowired 
	private UserMapper userMapper;

	@Override
	public GenericDao<User, Long> getDao() {
		return userMapper;
	}

	@Override
	@ReadOnlyConnection(DbType.READ1)
	public User getById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(User user) {
		int id = -1;
		if (checkoutInsert(user)) {
			user.setCreateTime(new Date());
			user.setDeleted(false);
			user.setVersion(0);
			userMapper.insert(user);
			id = (int) user.getId();
		}
		return id;
	}

}
