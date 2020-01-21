package com.login.webapp.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

//encoder that does not encode at all to avoid cases of BCrypt that
//don't include the necessary regexp format for password

public class PlainPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}

