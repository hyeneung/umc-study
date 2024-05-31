package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.MissionDTO request){
        return Mission.builder()
                .reward(request.getScore())
                .deadline(LocalDate.of(request.getDeadlineYear(), request.getDeadlineMonth(), request.getDeadlineDate()))
                .missionSpec(request.getSpec())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 미션 도전
    public static MissionResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(Mission mission){
        return MissionResponseDTO.ChallengeMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
