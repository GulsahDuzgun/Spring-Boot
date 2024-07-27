package com.gulsahduzgun.todo.utils.profiles;

import org.springframework.stereotype.Component;

// Spring nesnesi olmasını sağlamak için Component ekledik
@Component
public interface IChooseProfile {
    public String message(String name);
}
