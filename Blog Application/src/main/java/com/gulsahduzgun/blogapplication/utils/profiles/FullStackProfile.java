package com.gulsahduzgun.blogapplication.utils.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("fullstack")
public class FullStackProfile implements IChooseProfile{
    @Override
    public  String message(String name) {
        return FullStackProfile.class+" Profile: "+name;
    }
}
