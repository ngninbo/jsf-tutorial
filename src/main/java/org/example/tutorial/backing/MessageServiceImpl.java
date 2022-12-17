package org.example.tutorial.backing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tutorial.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class MessageServiceImpl implements MessageService {

    private Message message;

    @Autowired
    public MessageServiceImpl(Message message) {
        this.message = message;
    }

    @Override
    public String getGreetingMessage() {
        return message.getMessage();
    }
}
