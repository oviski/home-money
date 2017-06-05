package lv.javaguru.java2.servlet.mvc;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 04.06.2017.
 */
public class MVCFilter implements Filter {
    private Map<String, MVCController> controllerMapping;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        controllerMapping = new HashMap<String, MVCController>();
        controllerMapping.put("/allChecksList", new AllChecksListController());
        controllerMapping.put("/newCheck", new NewChecksController());

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
