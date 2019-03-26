package kobe.been.zjq.rpc_user.config.mybatis;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;

import kobe.been.zjq.rpc_user.config.mybatis.DbContextHolder.DbType;

@Target({ ElementType.METHOD, ElementType.TYPE })

@Retention(RetentionPolicy.RUNTIME)

public @interface ReadOnlyConnection {

	DbType value() default DbContextHolder.DbType.READ1;

}
