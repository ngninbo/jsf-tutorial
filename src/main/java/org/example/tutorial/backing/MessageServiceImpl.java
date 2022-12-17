package org.example.tutorial.backing;

import lombok.Data;
import org.example.tutorial.service.MessageService;

@Data
public class MessageServiceImpl implements MessageService {

    private String message;

    @Override
    public String getGreetingMessage() {
        return message;
    }

    @Override
    public void setGreetingMessage(String msg) {
        this.setMessage(msg);
    }
}
