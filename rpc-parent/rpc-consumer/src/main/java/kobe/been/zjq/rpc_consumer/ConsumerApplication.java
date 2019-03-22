package kobe.been.zjq.rpc_consumer;

import java.rmi.RemoteException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:sofa-consumer.xml" })
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) throws RemoteException {
    	SpringApplication springApplication = new SpringApplication(ConsumerApplication.class);
        springApplication.run(args);

//        IRemoteService boltSyncService = (IRemoteService) applicationContext.getBean("boltSyncServiceReference");
//        IRemoteService restSyncService = (IRemoteService) applicationContext.getBean("restSyncServiceReference");
//        IRemoteService dubboSyncService = (IRemoteService) applicationContext.getBean("dubboSyncServiceReference");

//        System.out.println("Bolt result:" + boltSyncService.getUserById(1l));
//        System.out.println("Rest result:" + restSyncService.getUserById(2l));
//        System.out.println("Dubbo result:" + dubboSyncService.getUserById(3l));
    }
}
