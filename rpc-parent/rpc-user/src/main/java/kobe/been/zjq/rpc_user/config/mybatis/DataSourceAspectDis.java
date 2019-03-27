package kobe.been.zjq.rpc_user.config.mybatis;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import kobe.been.zjq.rpc_user.config.mybatis.DbContextHolder.DbType;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class DataSourceAspectDis {
	
	@Pointcut("!@annotation(kobe.been.zjq.rpc_user.config.mybatis.ReadOnlyConnection) " +
            "&& (execution(* kobe.been.zjq.rpc_user.impl..*.select*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.get*(..))"+
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.find*(..))"+
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.list*(..))"+
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.query*(..)))")
    public void readPointcut() {

    }

    @Pointcut("!@annotation(kobe.been.zjq.rpc_user.config.mybatis.ReadOnlyConnection) " +
            "&& (execution(* kobe.been.zjq.rpc_user.impl..*.insert*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.add*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.save*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.update*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.edit*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.delete*(..)) " +
            "|| execution(* kobe.been.zjq.rpc_user.impl..*.remove*(..)))")
    public void writePointcut() {

    }
    
    @Before("readPointcut()")
    public void read() {
    	DbContextHolder.read();
    }

    @Before("writePointcut()")
    public void write() {
    	DbContextHolder.write();
    }

	@Pointcut("@annotation(kobe.been.zjq.rpc_user.config.mybatis.ReadOnlyConnection)")
	public void dataSourcePointcut() {

	}

	@Around("dataSourcePointcut()")
	public Object doAround(ProceedingJoinPoint pjp) {

		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

		Method method = methodSignature.getMethod();

		ReadOnlyConnection typeAnno = method.getAnnotation(ReadOnlyConnection.class);

		DbType sourceEnum = typeAnno.value();

		if (sourceEnum == DbType.WRITE) {

			DbContextHolder.setDbType(DbType.WRITE);
			log.info("切换到write");

		} else if (sourceEnum == DbType.READ1) {

			DbContextHolder.setDbType(DbType.READ1);
			log.info("切换到read1");

		}else if (sourceEnum == DbType.READ2) {

			DbContextHolder.setDbType(DbType.READ2);
			log.info("切换到read2");

		}

		Object result = null;

		try {

			result = pjp.proceed();

		} catch (Throwable throwable) {

			throwable.printStackTrace();

		} finally {

			DbContextHolder.resetDbType();

		}

		return result;

	}
}
