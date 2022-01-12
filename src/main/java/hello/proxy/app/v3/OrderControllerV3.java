package hello.proxy.app.v3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class OrderControllerV3 {
    private final OrderServiceV3 orderServiceV3;

    public OrderControllerV3(OrderServiceV3 orderServiceV3) {
        this.orderServiceV3 = orderServiceV3;
    }

    @GetMapping("/v3/request")
    public String requestV3(String itemId) {
        orderServiceV3.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v3/no-log")
    public String noLogV3() {
        return "ok";
    }
}
