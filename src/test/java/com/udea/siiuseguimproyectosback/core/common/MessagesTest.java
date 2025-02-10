package com.udea.siiuseguimproyectosback.core.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {

    private Messages messages;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    public void setUp() {
        // Initialize the mock objects
        MockitoAnnotations.openMocks(this);

        // Initialize the Messages object with the mocked MessageSource
        messages = new Messages(messageSource);
        messages.init(); // Ensure the init method is called after construction
    }

    @Test
    public void testGetMessage_Success() {
        // Arrange
        String code = "greeting";
        String expectedMessage = "Hello, World!";
        when(messageSource.getMessage(code, null, Locale.ENGLISH)).thenReturn(expectedMessage);

        // Act
        String result = messages.get(code);

        // Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void testGetMessage_NotFound() {
        // Arrange
        String code = "unknown_code";
        when(messageSource.getMessage(code, null, Locale.ENGLISH)).thenThrow(NoSuchMessageException.class);

        // Act
        String result = messages.get(code);

        // Assert
        assertEquals("No message available to show.", result);
    }

    @Test
    public void testGetMessage_Fallback() {
        // Arrange
        String code = "fallback_code";
        when(messageSource.getMessage(code, null, Locale.ENGLISH)).thenThrow(NoSuchMessageException.class);

        // Act
        String result = messages.get(code);

        // Assert
        assertEquals("No message available to show.", result);
    }
}
