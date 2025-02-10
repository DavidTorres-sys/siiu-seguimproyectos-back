package com.udea.siiuseguimproyectosback.core.security.user;

import com.udea.siiuseguimproyectosback.core.security.constants.UdeASystemStaticConstants;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class Session {

    private static final String MS_ERROR_GETTING_SESSION_INFO = "Error obteniendo los datos de sesión del usuario";

    public UserSessionDTO getCurrentUser(HttpServletRequest request) {
        UserSessionDTO user = null;
        try {
            Map<String, Object> userInSession = getSessionData(request);

            user = new UserSessionDTO();
            setUserSessionData(user, userInSession);
            setUserRoles(user, userInSession, request);

        } catch (Exception e) {
            throw new RuntimeException(MS_ERROR_GETTING_SESSION_INFO, e);
        }
        return user;
    }

    /**
     * Retrieves session data as a Map.
     */
    @SuppressWarnings("unchecked")
    private Map<String, Object> getSessionData(HttpServletRequest request) {
        return (Map<String, Object>) request
                .getSession()
                .getAttribute(UdeASystemStaticConstants.SESSION_HASHMAP_OBJECT);
    }

    /**
     * Sets the user session data from the session map.
     */
    private void setUserSessionData(UserSessionDTO user, Map<String, Object> userInSession) {
        user.setUsername((String) userInSession.get(UdeASystemStaticConstants.USER_LOGIN_SESSION_VARIABLE));
        user.setFullName((String) userInSession.get(UdeASystemStaticConstants.USER_FULL_NAME_SESSION_VARIABLE));
        user.setLastName((String) userInSession.get(UdeASystemStaticConstants.USER_FIRST_SURNAME_SESSION_VARIABLE));
        user.setSecondLastName((String) userInSession.get(UdeASystemStaticConstants.USER_SECOND_SURNAME_SESSION_VARIABLE));
        user.setFirstName((String) userInSession.get(UdeASystemStaticConstants.USER_FIRST_NAME_SESSION_VARIABLE));
        user.setDocumentNumber((String) userInSession.get(UdeASystemStaticConstants.USER_ID_CARD_SESSION_VARIABLE));
        user.setDocumentType((String) userInSession.get(UdeASystemStaticConstants.USER_DOCUMENT_TYPE_SESSION_VARIABLE));
        user.setEmail((String) userInSession.get(UdeASystemStaticConstants.USER_EMAIL_SESSION_VARIABLE));
    }

    /**
     * Sets the user roles from the session data.
     */
    private void setUserRoles(UserSessionDTO user, Map<String, Object> userInSession, HttpServletRequest request) {
        List<String> roles = getUserRolesFromSession(userInSession, request);
        user.setRoles(roles);
    }

    /**
     * Retrieves the roles from session data.
     */
    @SuppressWarnings("unchecked")
    private List<String> getUserRolesFromSession(Map<String, Object> userInSession, HttpServletRequest request) {
        Object rolesObj = userInSession.getOrDefault(UdeASystemStaticConstants.USER_ROLES_SESSION_VARIABLE, Collections.emptyList());

        if (rolesObj instanceof List) {
            return (List<String>) rolesObj;
        } else {
            return Collections.emptyList();
        }
    }
}
