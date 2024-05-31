package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.Utils;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.NonDuplicatedMission;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class MissionNonDuplicatedValidator implements ConstraintValidator<NonDuplicatedMission, Object[]> {


    private final Utils utils;

    @Override
    public void initialize(NonDuplicatedMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        Long memberId = (Long)value[0];
        Long missionId = (Long)value[1];
        boolean isValid = !utils.isExist(memberId, missionId);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_DUPLICATED.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
