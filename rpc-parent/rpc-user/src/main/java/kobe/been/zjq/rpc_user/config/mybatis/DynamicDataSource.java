package kobe.been.zjq.rpc_user.config.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	protected Object determineCurrentLookupKey() {

		return DbContextHolder.getDbType();

	}
}
