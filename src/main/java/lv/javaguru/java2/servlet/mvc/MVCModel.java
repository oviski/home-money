package lv.javaguru.java2.servlet.mvc;

/**
 * Created by admin on 04.06.2017.
 */
public class MVCModel {
    private String view;
    private Object data;

    public MVCModel (String view, Object data){
        this.view = view;
        this.data = data;
    }

    public MVCModel (String view){
        this.view = view;
        this.data = null;
    }

    public String getView(){
        return view;
    }

    public Object getData(){
        return data;
    }
}
