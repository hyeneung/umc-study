package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

public class MissionRequestDTO {

    // 미션 추가
    @Getter
    public static class MissionDTO{
        @NotNull
        Integer score;
        @NotNull
        Integer deadlineYear;
        @NotNull
        Integer deadlineMonth;
        @NotNull
        Integer deadlineDate;
        @NotBlank
        String spec;

    }
    // 미션 도전
    @Getter
    public static class ChallengeMissionDTO{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
