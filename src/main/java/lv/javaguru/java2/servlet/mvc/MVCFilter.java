package lv.javaguru.java2.servlet.mvc;


import lv.javaguru.java2.configs.SpringConfig;
import lv.javaguru.java2.smvc.SpringMvcConfig;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 04.06.2017.
 */

/*
public class MVCFilter implements Filter {
    private ApplicationContext springContext;

    private Map<String, MVCController> controllerMapping;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        springContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        controllerMapping = new HashMap();
        controllerMapping.put("/allChecksList", getBean(AllChecksListController.class));
        controllerMapping.put("/newCheck", getBean(NewChecksController.class));

    }

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }


    @Override
    public void doFilter(ServletRequest request,
                      ServletResponse response,
                      FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();

        System.out.println("contextURI " + contextURI);
        if(controllerMapping.keySet().contains(contextURI)) {
            MVCController controller = controllerMapping.get(contextURI);
            MVCModel model = null;

            String method = req.getMethod();
            if ("GET".equalsIgnoreCase(method)) {
                model = controller.processRequestGet(req, resp);
            }
            if ("POST".equalsIgnoreCase(method)) {
                model = controller.processRequestPost(req, resp);
            }


            //MVCModel model = controller.processRequestGet(req, resp);
            if (model.getData() != null) {
                Map<String, String> params = (Map<String, String>) model.getData();

                for (Map.Entry entry : params.entrySet()) {
                    req.setAttribute((String) entry.getKey(), entry.getValue());
                }
            }


            ServletContext context = req.getServletContext();

            RequestDispatcher requestDispacher =
                    context.getRequestDispatcher(model.getView());
            requestDispacher.forward(req, resp);
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }

}
*/