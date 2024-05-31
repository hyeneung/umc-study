package umc.spring.validation.annotation;

import umc.spring.validation.validator.CategoriesExistValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {
    // RequestDTO에서 이 태그 닮. CategoriesExistValidator라는 클래스를 통해 @ExistCategories가 붙은 대상을 검증
    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
