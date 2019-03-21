package kobe.been.zjq.rpc_consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
