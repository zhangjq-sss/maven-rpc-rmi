package kobe.been.zjq.rpc_user.config.mybatis;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbContextHolder {
	// 列举数据源的key

	public enum DbType {

		WRITE, READ1, READ2

	}

	private static final AtomicInteger counter = new AtomicInteger(-1);

	private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>() {

		@Override

		protected DbType initialValue() {

			return DbType.WRITE;

		}

	};

	public static void setDbType(DbType dbType) {

		if (dbType == null)

			throw new NullPointerException();

		contextHolder.set(dbType);

	}

	public static DbType getDbType() {

		return contextHolder.get() == null ? DbType.WRITE : contextHolder.get();

	}

	public static void resetDbType() {

		contextHolder.set(DbType.WRITE);

	}

	public static void clearDbType() {

		contextHolder.remove();

	}
	
	public static void write() {
		setDbType(DbType.WRITE);
        log.info("切换到write");
    }

    public static void read() {
        //  轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
        	setDbType(DbType.READ1);
        	log.info("切换到read1");
        }else {
        	setDbType(DbType.READ2);
        	log.info("切换到read2");
        }
    }


}
