package curry.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/*该注解表示这个可以被服务注册中心发现（服务提供者）*/
@EnableDiscoveryClient
public class EurekaProvider {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider.class,args);
    }
}
