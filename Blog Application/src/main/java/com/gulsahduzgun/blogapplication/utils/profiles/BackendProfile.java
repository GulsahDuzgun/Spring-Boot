package com.gulsahduzgun.blogapplication.utils.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("backend")
public class BackendProfile implements IChooseProfile {
    @Override
    public String message(String name) {
        return BackendProfile.class + "Profile:" + name;
    }
}
