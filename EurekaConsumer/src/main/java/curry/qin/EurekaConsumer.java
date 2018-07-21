package curry.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
/*启用服务发现*/
@EnableDiscoveryClient
/*该注解表示启用feign调用远程服务*/
@EnableFeignClients
/*启用熔断器功能*/
@EnableHystrix
public class EurekaConsumer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer.class,args);
    }
}
