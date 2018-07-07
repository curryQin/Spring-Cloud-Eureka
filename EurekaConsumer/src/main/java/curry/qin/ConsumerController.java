package curry.qin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController {
    @Autowired
    HelloRemote remote;

    @RequestMapping(value = "/consumeHello/{name}",method = RequestMethod.GET)
    public String consumerHello(@PathVariable("name") String name){
        return "调用"+ remote.hello(name);
    }
}
