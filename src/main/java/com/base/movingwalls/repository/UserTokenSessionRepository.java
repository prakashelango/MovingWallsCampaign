package com.base.movingwalls.repository;

import com.base.movingwalls.model.user.UserTokenSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenSessionRepository extends CrudRepository<UserTokenSession, Long> {

    /**
     * Find {@link UserTokenSession} for the given username.
     *
     * @param username
     * @return @{@link UserTokenSession}
     */
    UserTokenSession findOneByUsername(String username);

}