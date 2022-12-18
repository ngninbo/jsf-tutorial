package org.example.tutorial.backing;

import lombok.extern.slf4j.Slf4j;

import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

@Slf4j
public class Message {

    public String getMessage() {
        logger.info("Reading greeting message from resource");
        ResourceBundle bundle = ResourceBundle.getBundle("org.example.tutorial.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return bundle.getString("greeting");
    }
}
