package curry.qin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote remote;

    @Autowired
    private RestTemplate restTemplate;

    /***
     * 使用Feign的方式进行远程服务调用，Feign默认集成了ribbon进行负载均衡
     * @param name
     * @return
     */
    @RequestMapping(value = "/consumeHello/{name}",method = RequestMethod.GET)
    public String consumerHello(@PathVariable("name") String name){
        return "调用"+ remote.hello(name);
    }

    /***
     * 使用ribbon+RestTemplate方式进行负载均衡调用（通过IRULE，IPing进行服务路由和检测）
     * EUREKAPROVIDER 为服务提供者名称
     * @return
     */
    @RequestMapping(value = "/consumeHello/ribbon",method = RequestMethod.GET)
    public String consumerHello(){
        return restTemplate.getForObject("http://EUREKAPROVIDER/hello?name=123", String.class);
    }
}
