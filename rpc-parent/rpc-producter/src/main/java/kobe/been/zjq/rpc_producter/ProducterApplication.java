package kobe.been.zjq.rpc_producter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:sofa-producter.xml" })
@SpringBootApplication
public class ProducterApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProducterApplication.class);
        springApplication.run(args);
    }
}
