package org.example.tutorial.backing;

import org.example.tutorial.service.AuthorService;
import org.example.tutorial.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDataTest {

    private static final String TEST_NAME = "Beauclair";

    private MessageService messageService;

    private AuthorService authorService;

    private UserData cut;

    @Before
    public void setUp() {
        messageService = mock(MessageService.class);
        authorService = mock(AuthorService.class);
        cut = new UserData();
        cut.setMessageService(messageService);
        cut.setAuthorService(authorService);
    }

    @Test
    public void getWelcomeMessage() {
        cut.setName(TEST_NAME);
        final String welcomeMessage = String.format("Hello %s", TEST_NAME);
        assertEquals(welcomeMessage, cut.getWelcomeMessage());
    }

    @Test
    public void getGreetingMessage() {
        when(messageService.getGreetingMessage()).thenReturn("Hello World!");
        assertEquals("Hello World!", cut.getGreetingMessage());
        verify(messageService).getGreetingMessage();
    }

    @Test
    public void getAuthors() {
        when(authorService.getAuthors()).thenReturn(List.of());
        var list = cut.getAuthors();
        assertTrue(list.isEmpty());
        verify(authorService).getAuthors();
    }
}