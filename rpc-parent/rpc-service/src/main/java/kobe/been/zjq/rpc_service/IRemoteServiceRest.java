package kobe.been.zjq.rpc_service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import kobe.been.zjq.rpc_domain.user.User;

@Path("/rest")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public interface IRemoteServiceRest{
	@GET
	@Path("/{id}")
	User getUserById(@PathParam("id") Long id);
}
