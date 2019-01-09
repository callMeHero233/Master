package com.wpsoft.resmaster.core.utils;


import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: WP
 * @Description: 继承servlet重写404异常方法
 * @Date: 10:33 2019/1/7
 * @Modified By:
 */
public class NohandlerFoundServlet extends DispatcherServlet {

    private static final long serialVersionUID = 1L;

    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    private String fileNotFoundUrl = "";

    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (pageNotFoundLogger.isWarnEnabled()) {
            String requestUri = urlPathHelper.getRequestUri(request);
            pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri +
                    "] in DispatcherServlet with name ‘" + getServletName() + "‘");
        }

        response.sendRedirect(request.getContextPath() + fileNotFoundUrl);
    }

    public String getileNotFoundUrl() {
        return fileNotFoundUrl;
    }

    public void setFileNotFoundUrl(String fileNotFoundUrl) {
        this.fileNotFoundUrl = fileNotFoundUrl;
    }
}
