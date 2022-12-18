package org.example.tutorial.backing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tutorial.model.Author;
import org.example.tutorial.service.AuthorService;
import org.example.tutorial.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.*;

@Data
@NoArgsConstructor
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Date createTime = new Date();

    private String locale;

    private Map<String,Locale> countries = Map.of("English", Locale.ENGLISH, "French", Locale.FRENCH, "German", Locale.GERMAN);

    private MessageService messageService;

    private AuthorService authorService;

    @Autowired
    public UserData(MessageService messageService, AuthorService authorService) {
        this.messageService = messageService;
        this.authorService = authorService;
    }

    public String getWelcomeMessage() {
        return "Hello " + name;
    }

    public String getGreetingMessage() {
        return messageService.getGreetingMessage();
    }

    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public void localeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();

        countries.entrySet()
                .stream()
                .filter(entry -> entry.getValue().toString().equals(newLocaleValue))
                .findFirst()
                .ifPresent(entry -> FacesContext.getCurrentInstance().getViewRoot().setLocale(entry.getValue()));
    }
}
