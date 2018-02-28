package com.example.demo.config;

import com.example.demo.annotation.BaseController;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BaseControllerHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle....");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class handlerClass = handlerMethod.getBeanType();
        if(AnnotatedElementUtils.hasAnnotation(handlerClass, BaseController.class)) {
            BaseController baseController = AnnotatedElementUtils.getMergedAnnotation(handlerClass,
                    BaseController.class);
            System.out.println(baseController.name());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
        super.afterCompletion(request, response, handler, ex);
    }
}
