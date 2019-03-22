package kobe.been.zjq.rpc_consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import kobe.been.zjq.rpc_service.H2CService;
import kobe.been.zjq.rpc_service.IRemoteService;
import kobe.been.zjq.rpc_service.IRemoteServiceRest;

@RestController
public class SofaController {

	@Resource(name="boltSyncServiceReference")
	IRemoteService boltSyncService;
	@Resource(name="restSyncServiceReference")
	IRemoteServiceRest restSyncService;
	@Resource(name="dubboSyncServiceReference")
	IRemoteService dubboSyncService;
	
	@SofaReference(binding = @SofaReferenceBinding(bindingType = "h2c"), jvmFirst = false)
	H2CService h2cSyncService;
	
	@RequestMapping("/bolt")
	public String getByBindingBolt() {
		
		return boltSyncService.getUserById(1L).toString();
	}
	
	@RequestMapping("/rest")
	public String getByBindingRest() {
		
		return restSyncService.getUserById(2l).toString();
	}
	
	@RequestMapping("/dubbo")
	public String getByBindingDubbo() {
		
		return dubboSyncService.getUserById(3l).toString();
	}
	
	@RequestMapping("/h2c")
	public String getByBindingH2c() {
		
		return h2cSyncService.getUserById(4l).toString();
	}
}
