package io.univartois.cameldemo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GettingStarted extends RouteBuilder {
    @Override
    public void configure() {
        //from("timer:monSuperTimer?period=100")
               // .log("Hello World !");
    }
}
