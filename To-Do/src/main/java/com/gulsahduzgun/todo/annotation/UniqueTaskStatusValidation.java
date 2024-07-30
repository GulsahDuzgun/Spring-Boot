package com.gulsahduzgun.todo.annotation;

import com.gulsahduzgun.todo.data.repository.ITaskStatusRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

// <A,T> A=Annotation T=Type
    public class UniqueTaskStatusValidation implements ConstraintValidator<AUniqueTaskStatusName, String> {

        private final ITaskStatusRepository iTaskStatusRepository;

        //isValid
        @Override
        public boolean isValid(String taskStatusName, ConstraintValidatorContext constraintValidatorContext) {
            // 1.YOL
            // BlogCategoryEntity isSameCategoryName=iBlogCategoryRepository.findByCategoryName(categoryName).orElseThrow(()->new NotFound404Exception(categoryName+" Bulunmadı"));
            // 2.YOL
            boolean isSameCategoryName = iTaskStatusRepository.findByStatusName(taskStatusName).isPresent();
            // Eğer Aynı blogCategoryName varsa return false döndersin
            if (isSameCategoryName) {
                System.out.println(taskStatusName + " Aynı isimde Database bulunmaktadır. Farklı bir database giriniz");
                return false;
            } else {
                System.out.println(taskStatusName + " Harika bu category ismini yazabilirsiniz");
                return true;
            }
        } //isValid

}
