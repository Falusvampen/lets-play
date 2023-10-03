package falusvampen.letsplay.config;

import falusvampen.letsplay.exceptions.UserCollectionException;

public class ValidateUser {
    public static void validateRole(String role) throws UserCollectionException {
        if (role != null) {
            // check if role enum is either role is "ROLE_ADMIN" or "ROLE_USER"
            if (!(role.equals("ROLE_ADMIN") || role.equals("ROLE_USER"))) {
                throw new UserCollectionException("User role" + UserCollectionException.InvalidRoleException());
            }
        } else {
            throw new UserCollectionException("User role" + UserCollectionException.NullException());
        }
    }
}
