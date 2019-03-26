package kobe.been.zjq.rpc_domain.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//重要 重要 重要 一定要实现序列化
@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String password;
	private Date createTime;
    private Integer version;
    private Date lastUpdateTime;
    private Boolean deleted;
}
