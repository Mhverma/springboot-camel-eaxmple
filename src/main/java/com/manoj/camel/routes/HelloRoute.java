package com.manoj.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Route;
import org.apache.camel.model.language.SimpleExpression;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends BaseRoute{

    @Override
    public void configure() throws Exception {
        super.configure( );

        from("direct:sayHello").routeId("hello")
                .log(LoggingLevel.INFO, "------Incoming Request Param : ${body}")
                .transform().method("myBean", "saySomething")
                .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
                .end()
                .to("direct:nextHello")
                                                ;


        from("direct:nextHello")
                .routeId("direct-nexthello")
                .tracing()
                .log(">>> ${body}")
                .bean("myBean", "sayHello(${body})")
                .log(">>>>Response : ${body}").end();
                ;

    }
}
