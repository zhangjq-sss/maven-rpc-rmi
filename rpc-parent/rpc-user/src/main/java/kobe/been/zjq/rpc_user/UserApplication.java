package kobe.been.zjq.rpc_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ImportResource({ "classpath:sofa-producter.xml" })
@SpringBootApplication
@EnableSwagger2
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(UserApplication.class);
        springApplication.run(args);
        log.info("启动用户模块项目成功！");
    }
    
    @Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("kobe.been.zjq.rpc_user.controller"))
					.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("用户中心-用户微服务API说明文档").description("2019.03.25").build());
	}
}
