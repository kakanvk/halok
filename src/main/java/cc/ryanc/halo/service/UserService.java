package cc.ryanc.halo.service;

import cc.ryanc.halo.exception.NotFoundException;
import cc.ryanc.halo.model.entity.User;
import cc.ryanc.halo.service.base.CrudService;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * User service.
 *
 * @author johnniang
 */
public interface UserService extends CrudService<User, Integer> {

    /**
     * Login failure count key.
     */
    String LOGIN_FAILURE_COUNT_KEY = "login.failure.count";

    /**
     * Max login try count.
     */
    int MAX_LOGIN_TRY = 5;

    int LOCK_MINUTES = 10;

    /**
     * Gets user by username.
     *
     * @param username username must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByUsername(@NonNull String username);

    /**
     * Gets non null user by username.
     *
     * @param username username
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    @NonNull
    User getByUsernameOfNonNull(@NonNull String username);

    /**
     * Gets user by email.
     *
     * @param email email must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByEmail(@NonNull String email);

    /**
     * Gets non null user by email.
     *
     * @param email email
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    User getByEmailOfNonNull(@NonNull String email);

    /**
     * Logins by username and password.
     *
     * @param key      username or email must not be blank
     * @param password password must not be blank
     * @return user info
     */
    @NonNull
    User login(@NonNull String key, @NonNull String password);
}