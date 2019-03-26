package kobe.been.zjq.rpc_producter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JasyptTest.class)
@WebAppConfiguration 
public class JasyptTest extends TestCase {

	@Test
	public void testEnvironmentProperties() {
		//jasypt方式
		//对称加密方式
		//对称请求加密地址 http://localhost:2222/encrypt 解密地址 http://localhost:2222/decrypt 
	}
	
	public static void main(String[] args) {
//		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//        //加密所需的salt(盐)
//        textEncryptor.setPassword("zjq");
//        //要加密的数据（数据库的用户名或密码）
//        String username = textEncryptor.encrypt("root");
//        String password = textEncryptor.encrypt("123456");
//        System.out.println("username:"+username);
//        System.out.println("password:"+password);
	}
}
