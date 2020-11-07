package com.godnan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
/*
@Component*/
public class TokenFilter extends ZuulFilter {


    //过滤器类型
    @Override
    public String filterType() {
        // pre 表示请求之前执行

        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //过滤器是否生效
        return true;
    }

    /**
     * 过滤器的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //拦截所有的服务接口
           RequestContext context= RequestContext.getCurrentContext();
           HttpServletRequest request= context.getRequest();
           String token=request.getParameter("token");
            if(null==token){
                context.setSendZuulResponse(false);
                context.setResponseBody("userToken is not null");
                context.setResponseStatusCode(401);
                return  null;
            }



        return null;
    }
}
