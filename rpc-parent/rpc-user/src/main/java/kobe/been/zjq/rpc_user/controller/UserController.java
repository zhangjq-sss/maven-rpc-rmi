package kobe.been.zjq.rpc_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.sofa.rpc.common.json.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kobe.been.zjq.rpc_domain.common.RequestContent;
import kobe.been.zjq.rpc_domain.common.ResultBody;
import kobe.been.zjq.rpc_domain.user.User;
import kobe.been.zjq.rpc_service.UserService;

@Api(value = "用户-调用第三方和回调接API")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "通过userId查询", notes = "通过userId查询",  response = Object.class)
	@RequestMapping(value="/getUserById", method=RequestMethod.GET)
	public ResultBody getUserById(Long userId) {
		ResultBody resultBody = new ResultBody();
		resultBody.success();
		resultBody.setData(userService.getById(userId));
		return resultBody;
	}
	
	@ApiOperation(value = "用户信息插入", notes = "用户信息插入",  response = ResultBody.class)
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="body", name = "userBody", value = "用户基本信息", required = true,  dataType = "RequestContent")
	 })
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResultBody insert(@RequestBody  RequestContent userBody) {
		User user = JSON.parseObject(JSON.toJSONString(userBody.getBody()), User.class);
		ResultBody resultBody = new ResultBody();
		resultBody.success();
		resultBody.setData(userService.insert(user));
		return resultBody;
	}
	
	@ApiOperation(value = "用户信息更新", notes = "用户信息更新",  response = ResultBody.class)
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="body", name = "userBody", value = "用户基本信息", required = true,  dataType = "RequestContent")
	 })
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResultBody update(@RequestBody  RequestContent userBody) {
		User user = JSON.parseObject(JSON.toJSONString(userBody.getBody()), User.class);
		ResultBody resultBody = new ResultBody();
		resultBody.success();
		resultBody.setData(userService.update(user));
		return resultBody;
	}
	
	@ApiOperation(value = "查询所有用户", notes = "查询所有用户",  response = Object.class)
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public ResultBody listAll() {
		ResultBody resultBody = new ResultBody();
		resultBody.success();
		resultBody.setData(userService.listAll());
		return resultBody;
	}
}
