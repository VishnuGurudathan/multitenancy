package com.example.configuration;

import com.example.multitenant.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author vishnu.g
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    private final RequestInterceptor tenantRequestInterceptor;

    public WebConfiguration(RequestInterceptor tenantRequestInterceptor) {
        this.tenantRequestInterceptor = tenantRequestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantRequestInterceptor)
                // '/api' is set as context path, so here we need to consider only path after that.
                .addPathPatterns("/v1/*")
                .excludePathPatterns("/v1/common/**");
    }
}
