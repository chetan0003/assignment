package com.security.service;

import com.security.domain.UserCredential;

public interface IAuthenticationService {

    String saveUser(UserCredential credential);

    String generateToken(String username);

    void validateToken(String token);
}
