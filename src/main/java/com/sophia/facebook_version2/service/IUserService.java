package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.User;

public interface IUserService {
    User getUserByEmail(String email);
}
