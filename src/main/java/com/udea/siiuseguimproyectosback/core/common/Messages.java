package com.udea.siiuseguimproyectosback.core.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Helper class to simplify the access of internationalized messages (i18n) in the code.
 * <p>
 * This class provides a method to retrieve messages based on message codes from a message source.
 * It supports fallback to a default message if the requested message is not found.
 * </p>
 */
@Component
public class Messages {

    // The message source to load messages from properties or other sources
    private final MessageSource messageSource;

    // The accessor to retrieve messages in a specific locale
    private MessageSourceAccessor accessor;

    /**
     * Constructor to inject the MessageSource bean for accessing messages.
     * <p>
     * This constructor is used by Spring to inject the message source bean, which contains the
     * messages for different locales.
     * </p>
     *
     * @param messageSource the message source for loading i18n messages.
     */
    @Autowired
    public Messages(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Initializes the MessageSourceAccessor with the default locale (English).
     * <p>
     * This method is called after the bean is created and is used to set up the accessor, which is
     * responsible for retrieving messages in the configured locale.
     * </p>
     */
    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    /**
     * Retrieves a message based on the provided message code.
     * <p>
     * This method uses the message code to look up the corresponding message from the message source.
     * If the message is not found, it returns a default message indicating that the message could not
     * be found.
     * </p>
     *
     * @param code the message code for which the message is to be retrieved.
     * @return the message corresponding to the code, or a default message if not found.
     */
    public String get(String code) {
        try {
            return accessor.getMessage(code);
        } catch (NoSuchMessageException exception) {
            return "No message available to show.";
        }
    }
}
