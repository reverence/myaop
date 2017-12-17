package com.my.aop;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by tufei on 2017/12/13.
 */
public class IocServlet implements Servlet {

    /**
     * 这里本不应该硬编码的，应该作为一项配置放在web.xml中,为了方便测试,在此先写死
     */
    private static final String APPLICATION_CONTEXT_XML = "applicationContext.xml";

    private AbastractApplicationContext abastractApplicationContext;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try{
            abastractApplicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
            BeanUtils.setAbastractApplicationContext(abastractApplicationContext);//供外部调用时用
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException("init failed");
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        if(null != abastractApplicationContext){
            abastractApplicationContext.close();
        }
        abastractApplicationContext = null;
    }
}
