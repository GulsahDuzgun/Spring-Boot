package com.gulsahduzgun.blogapplication.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Log4j2
@RestController
@CrossOrigin

public class ErrorControllerHandleWebRequest  implements ErrorController {
    private final ErrorAttributes errorAttributes;

    private Integer status;
    private String path;
    private String message;
    private Map<String,String> validationErrors;
    private ApiResult apiResult;


    @RequestMapping("/error")
    public  ApiResult handleError(WebRequest webRequest) {
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of( ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        status = (Integer)attributes.get("status");
        path = (String)attributes.get("path");
        message = attributes.get("path").toString();
        apiResult = new ApiResult(status,message, path);

        if(attributes.containsKey("error")) {
            List<FieldError> fieldErrorList = (List<FieldError>) attributes.get("error");

            for(FieldError fieldError : fieldErrorList) {
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

            apiResult.setValidationErrors(validationErrors);
        }
        return  apiResult;
    }
}
