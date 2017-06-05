package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 04.06.2017.
 */
public interface MVCController {

    MVCModel processRequestGet(HttpServletRequest request,
                               HttpServletResponse response);
    MVCModel processRequestPost(HttpServletRequest request,
                               HttpServletResponse response);
}
