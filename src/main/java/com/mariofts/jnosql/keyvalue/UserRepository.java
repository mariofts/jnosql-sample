package com.mariofts.jnosql.keyvalue;

import java.util.Optional;

import javax.inject.Inject;

import org.jnosql.artemis.key.KeyValueTemplate;

public class UserRepository {

    @Inject
    private KeyValueTemplate template;

    public User save(User user) {
        return template.put(user);
    }

    public Optional<User> findById(String userName) {
        return template.get(userName, User.class);
    }
}
