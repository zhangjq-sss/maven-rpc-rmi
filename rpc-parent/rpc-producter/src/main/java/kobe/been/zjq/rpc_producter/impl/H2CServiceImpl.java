package kobe.been.zjq.rpc_producter.impl;

import org.springframework.stereotype.Service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;

import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_service.H2CService;

@Service
@SofaService(bindings = {@SofaServiceBinding(bindingType = "h2c")})
public class H2CServiceImpl implements H2CService{

	@Override
	public User getUserById(Long id) {
		User user = new User();
		user.setId(id);
		user.setUserName("zjq_" + id);
		user.setPassword("123456_" + id);
		return user;
	}

}
