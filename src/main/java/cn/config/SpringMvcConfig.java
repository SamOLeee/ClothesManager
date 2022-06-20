package cn.config;

import cn.interceptor.ResourcesInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
////等同于<context:component-scan base-package="controller"/>
@ComponentScan({"cn.controller"})
//@Import({MyWebMvcConfig.class})
@EnableWebMvc
public class SpringMvcConfig  implements WebMvcConfigurer {

    /*
     * 在注册的拦截器类中添加自定义拦截器
     * addPathPatterns()方法设置拦截的路径
     * excludePathPatterns()方法设置不拦截的路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResourcesInterceptor()).addPathPatterns("/**").excludePathPatterns("/css/**","/js/**","/img/**","/admin/**");
    }

    /*
     *开启对静态资源的访问
     * 类似在Spring MVC的配置文件中设置<mvc:default-servlet-handler/>元素
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/admin/",".jsp");
    }

}




