package com.godnan.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class SwaggerUI implements SwaggerResourcesProvider {


    @Override
    public List<SwaggerResource> get() {

        //服提供的服务
        List<SwaggerResource> list=new ArrayList<>();
        list.add(addResource("会员服务","/api-member/v2/api-docs","2.0"));
        list.add(addResource("订单服务","/api-order/v2/api-docs","2.0"));
        return list;
    }

    public SwaggerResource addResource(String showApiName,String apiLocation,String version){
        SwaggerResource resource=new SwaggerResource();
        resource.setName(showApiName);
        resource.setLocation(apiLocation);
        resource.setSwaggerVersion(version);
        return  resource;
    }

}
