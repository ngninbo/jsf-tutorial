package org.example.tutorial.backing;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
@Slf4j
public class HelloWorld {

    @Setter
    @ManagedProperty(value = "#{message}")
    private Message messageBean;
    private String message;

    public HelloWorld() {
        logger.info("HelloWorld started!");
    }

    public String getMessage() {

        if(messageBean != null) {
            message = messageBean.getMessage();
        }
        return message;
    }
}
