package com.gulsahduzgun.blogapplication.controller.api.impl;
import com.gulsahduzgun.blogapplication.business.dto.BlogCategoryDto;
import com.gulsahduzgun.blogapplication.business.services.IBlogCategoriesServices;
import com.gulsahduzgun.blogapplication.controller.api.IBlogCategoriesApi;
import com.gulsahduzgun.blogapplication.utils.frontend.ReactFrontend;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Log4j2

// API
@RestController
//@CrossOrigin
@CrossOrigin(origins = ReactFrontend.REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/blog/categories/api/v100")
public class BlogCategoriesApiImpl implements IBlogCategoriesApi<BlogCategoryDto> {

    // INJECTION
    private final IBlogCategoriesServices iBlogCategoriesServices;


    /////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/blog/categories/api/v100/speed
    // http://localhost:4444/blog/categories/api/v100/speed/0
    // http://localhost:4444/blog/categories/api/v100/speed/5
    @Override
    @GetMapping(value={"/speed","/speed/{id}"})
    public ResponseEntity<String> blogCategoryApiSpeedData( @PathVariable(name="id",required = false) Integer data) {
        return ResponseEntity.ok(iBlogCategoriesServices.blogCategoryServiceSpeedData(data));
    }

    @Override
    @DeleteMapping(value="/delete/all")
    public ResponseEntity<String> blogCategoryApiDeleteAllData() {
        return ResponseEntity.ok(iBlogCategoriesServices.blogCategoryServiceDeleteAllData());
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogCategoryApiCreate(@Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        return ResponseEntity.ok().body(iBlogCategoriesServices.blogCategoryServiceCreate(blogCategoryDto));
    }

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<BlogCategoryDto>> blogCategoryApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iBlogCategoriesServices.blogCategoryServiceList());
    }

    @Override
    @GetMapping({"/find","/find/{id}"})
    public ResponseEntity<?> blogCategoryApiFindById(@PathVariable(name="id",required = false) Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iBlogCategoriesServices.blogCategoryServiceFindById(id));
    }

    @Override
    @PutMapping({"/update","/update/{id}"})
    public ResponseEntity<?> blogCategoryApiUpdateById(@PathVariable(name="id",required = false) Long id, @Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        return ResponseEntity.ok().body(iBlogCategoriesServices.blogCategoryServiceUpdateById(id,blogCategoryDto));
    }

    @Override
    @DeleteMapping({"/delete","/delete/{id}"})
    public ResponseEntity<?> blogCategoryApiDeleteById(@PathVariable(name="id",required = false) Long id) {
        return new ResponseEntity<>(iBlogCategoriesServices.blogCategoryServiceDeleteById(id), HttpStatus.OK);
    }

}