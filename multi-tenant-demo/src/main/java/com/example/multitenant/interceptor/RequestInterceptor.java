package com.example.multitenant.interceptor;

import com.example.multitenant.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vishnu.g
 */
@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    public static final String X_TENANT_ID = "X-Tenant-Id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader(X_TENANT_ID);
        if(null == tenantId) {
            response.getWriter().write("X-Tenant-Id not present in the Request Header");
            response.setStatus(400);
            return false;
        }
        TenantContext.setCurrentTenant(tenantId);
        log.info("RequestURI:{} with X-Tenant-Id:{}", request.getRequestURI(), tenantId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
