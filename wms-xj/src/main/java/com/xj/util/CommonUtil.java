package com.migu.aogs.manager.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志工具
 */
public class CommonUtil {

    private static final Logger logger = LogManager.getLogger(CommonUtil.class);

    public String responseJson(String jsonToResponse,HttpServletResponse response) {
        basicJsonResponse(response);
        try {
            response.getWriter().println(jsonToResponse);
        } catch (IOException e) {
            logger.error("e", e);
        }
        return null;
    }
}
