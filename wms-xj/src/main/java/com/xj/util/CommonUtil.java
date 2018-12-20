package com.xj.util;


/**
 * 日志工具
 */
public class CommonUtil {

    /*private static final Logger logger = LogManager.getLogger(CommonUtil.class);

    public String responseJson(String jsonToResponse,HttpServletResponse response) {
        basicJsonResponse(response);
        try {
            response.getWriter().println(jsonToResponse);
        } catch (IOException e) {
            logger.error("e", e);
        }
        return null;
    }

    *//**
     * 设置json型的输出流
     * @param response
     *//*
    protected void basicJsonResponse(HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Charset", "utf-8");
        response.setHeader("Cache-Control", "no-cache");
    }*/
}
