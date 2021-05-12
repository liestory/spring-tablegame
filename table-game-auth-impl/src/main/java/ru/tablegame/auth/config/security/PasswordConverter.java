package ru.tablegame.auth.config.security;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author nemykin 23.03.2021
 */
@Component
public class PasswordConverter extends BidirectionalConverter<String, String> {
    private final PasswordEncoder passwordEncoder;

    public PasswordConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String convertTo(String source, Type<String> destinationType, MappingContext mappingContext) {
        return passwordEncoder.encode(source);
    }

    @Override
    public String convertFrom(String source, Type<String> destinationType, MappingContext mappingContext) {
        return null;
    }
}
