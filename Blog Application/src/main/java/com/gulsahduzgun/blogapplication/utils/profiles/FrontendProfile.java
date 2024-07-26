package com.gulsahduzgun.blogapplication.utils.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("frontend")
public class FrontendProfile implements IChooseProfile{
@Override
    public String message(String name) {
    return  FrontendProfile.class + "Profile: " + name;

    }
}
