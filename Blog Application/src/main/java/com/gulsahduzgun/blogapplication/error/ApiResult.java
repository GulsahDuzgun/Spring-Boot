package com.gulsahduzgun.blogapplication.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2


@JsonInclude(JsonInclude.Include.NON_NULL)  // Not Null Guard
public class ApiResult {
    //field
    private Integer status;
    private String message;
    private String error;
    private String path;
    private Map<String,String> validationErrors;
    private String createdDate = nowDate();
    // private Date createdDate = new Date(System.currentTimeMillis());


    public ApiResult(Integer status, String message, String path) {//constructor
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ApiResult(Integer status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        // this.createdDate = new Date(System.currentTimeMillis());
    }

    private String nowDate() {
        Locale locale = new Locale("tr","TR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        Date date = new Date();
        return  dateFormat.format(date);
    }
}


