package org.example.tutorial.backing;

import lombok.Data;
import org.example.tutorial.model.Author;
import org.example.tutorial.service.AuthorService;
import org.example.tutorial.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.*;

@Data
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Date createTime = new Date();

    private String locale;

    private Map<String,Object> countries = Map.of("English", Locale.ENGLISH, "French", Locale.FRENCH);

    @Autowired
    private MessageService messageService;

    @Autowired
    private AuthorService authorService;

    public String getWelcomeMessage() {
        return "Hello " + name;
    }

    public String getGreetingMessage() {
        return messageService.getGreetingMessage();
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    //value change event listener
    public void localeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }
}
