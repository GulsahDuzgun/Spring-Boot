package com.gulsahduzgun.blogapplication.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RequiredArgsConstructor
@Log4j2
@RestController
@CrossOrigin

public class ErrorControllerHandleWebRequest  implements ErrorController {
    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public  ApiResult handleError(WebRequest webRequest) {
        return  null;
    }
}
