package org.example.tutorial.backing;

import javax.faces.context.FacesContext;
import java.util.ResourceBundle;


public class Message {

    public String getMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("org.example.tutorial.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return bundle.getString("greeting");
    }
}
