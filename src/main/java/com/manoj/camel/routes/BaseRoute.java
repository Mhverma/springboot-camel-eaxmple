package com.manoj.camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public abstract class BaseRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getContext().getGlobalOptions().put( "CamelJacksonEnableTypeConverter", "true" );
        getContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
        getContext().setUseMDCLogging(true);

        onException( Exception.class ).log( LoggingLevel.ERROR, "Global Exception Handler")
                .handled( true );
    }
}
