package com.gulsahduzgun.todo.annotation;

import com.gulsahduzgun.todo.data.repository.ITaskRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

// <A,T> A=Annotation T=Type
    public class UniqueTaskStatusValidation implements ConstraintValidator<AUniqueTask, String> {

        private final ITaskRepository iTaskStatusRepository;

        //isValid
        @Override
        public boolean isValid(String statusName, ConstraintValidatorContext constraintValidatorContext) {
            // 1.YOL
            // BlogCategoryEntity isSameCategoryName=iBlogCategoryRepository.findByCategoryName(categoryName).orElseThrow(()->new NotFound404Exception(categoryName+" Bulunmadı"));
            // 2.YOL
            boolean isSameCategoryName = iTaskStatusRepository.findByStatusName(statusName).isPresent();
            boolean isSameTaskName = iTaskStatusRepository.findByTaskName(statusName).isPresent();

            // Eğer Aynı blogCategoryName varsa return false döndersin
            if (isSameCategoryName || isSameTaskName) {
                System.out.println(statusName + " Aynı isimde Database bulunmaktadır. Farklı bir database giriniz");
                return false;
            } else {
                System.out.println(statusName + " Harika bu category ismini yazabilirsiniz");
                return true;
            }


    }

}
