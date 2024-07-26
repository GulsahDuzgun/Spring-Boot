package com.gulsahduzgun.blogapplication.utils.roles;

//Enum
//1- The instance of class can not be created from out
//2- No setter method

public enum ERole {
    SUPER_ADMIN(1L, "super_admin"),
    ADMIN(2L,"admin"),
    ACCOUNTING(3L,"accounting"),
    WRITER(4L,"writer"),
    USER(4l,"user");

    private final Long key;
    private final String value;

    private ERole(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Long getKey() {
        return key;
    }
}
