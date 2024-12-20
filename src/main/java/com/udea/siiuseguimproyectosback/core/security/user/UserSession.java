package com.udea.siiuseguimproyectosback.core.security.user;

import lombok.Data;
import java.util.List;

/**
 * Represents the session information for a user currently authenticated in the system.
 * <p>
 * This class encapsulates the essential user-related details needed for authorization,
 * role-based access control, and personalization during the session.
 * <p>
 * Typical usage:
 * <pre>{@code
 * UserSession userSession = new UserSession();
 * userSession.setUsername("john.doe");
 * userSession.setRoles(Arrays.asList("ADMIN", "REVIEWER"));
 * }</pre>
 */
@Data
public class UserSession {

    /**
     * The unique username of the authenticated user.
     * <p>
     * This is typically the user's login identifier, such as an email address or a custom username.
     */
    private String username;

    /**
     * The full name of the user, including first name and both surnames.
     * <p>
     * Example: "John Michael Doe".
     */
    private String fullName;

    /**
     * The first name of the user.
     * <p>
     * Example: "John".
     */
    private String firstName;

    /**
     * The primary surname of the user.
     * <p>
     * Example: "Doe".
     */
    private String lastName;

    /**
     * The secondary surname of the user, if applicable.
     * <p>
     * Example: "Smith". May be null if the user does not have a second surname.
     */
    private String secondLastName;

    /**
     * The unique document number associated with the user.
     * <p>
     * This is typically a national identification number, passport number, or similar identifier.
     */
    private String documentNumber;

    /**
     * The type of document associated with the user.
     * <p>
     * Example values: "ID_CARD", "PASSPORT".
     */
    private String documentType;

    /**
     * The user's primary email address for communication.
     * <p>
     * This is also often used for account recovery or notifications.
     */
    private String email;

    /**
     * The list of roles assigned to the user.
     * <p>
     * Roles are used to determine the user's access level and permissions within the system.
     */
    private List<String> roles;

    /**
     * Indicates whether the user's current role is authorized to perform specific actions.
     * <p>
     * This is typically determined during the login or session validation process.
     */
    private boolean isRoleAuthorized;

    /**
     * Indicates whether the user has the role of "Document Coordinator."
     * <p>
     * This role usually involves managing and overseeing document-related processes.
     */
    private boolean isDocumentCoordinator;

    /**
     * Indicates whether the user has the role of "Reviewer."
     * <p>
     * Reviewers are typically responsible for evaluating or approving specific processes.
     */
    private boolean isReviewer;

    /**
     * Indicates whether the user has the role of "Social Worker."
     * <p>
     * Social workers may have specialized access and responsibilities in the system.
     */
    private boolean isSocialWorker;

    /**
     * The base URL of the application that the user is accessing.
     * <p>
     * This can be used for context-specific operations, such as constructing links or redirecting.
     */
    private String applicationUrl;
}
