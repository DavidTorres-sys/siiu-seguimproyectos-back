package com.udea.siiuseguimproyectosback.core.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MessagesTest {

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private Messages messages;

    @BeforeEach
    void setUp() {
        // Initialize the Messages object with the mocked MessageSource
        messages = new Messages(messageSource);
    }

    @Test
    void testGetMessage_Success() {
        // Arrange
        String messageCode = "greeting";
        String expectedMessage = "Hello, World!";
        // Mock the behavior of MessageSource to return the expected message for the "greeting" code
        when(messageSource.getMessage(messageCode, null, Locale.ENGLISH)).thenReturn(expectedMessage);
        // Act
        String result = messages.get(messageCode);
        // Assert
        assertEquals(expectedMessage, result);  // Assert that the result matches the expected message
    }

    @Test
    void testGetMessage_NotFound() {
        // Arrange
        String messageCode = "nonexistent";
        // Mock the behavior of MessageSource to throw NoSuchMessageException for the "nonexistent" code
        when(messageSource.getMessage(messageCode, null, Locale.ENGLISH)).thenThrow(NoSuchMessageException.class);
        // Act
        String result = messages.get(messageCode);
        // Assert
        assertEquals("No message available to show.", result);  // Assert that the fallback message is returned
    }

    @Test
    void testGetMessage_Fallback() {
        // Arrange
        String messageCode = "fallback";
        // Mock the behavior of MessageSource to return null (or a behavior that results in the fallback message)
        when(messageSource.getMessage(messageCode, null, Locale.ENGLISH)).thenReturn(null);
        // Act
        String result = messages.get(messageCode);
        // Assert
        assertEquals("No message available to show.", result);  // Assert that the fallback message is returned
    }
}
