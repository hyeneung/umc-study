package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.annotation.NonDuplicatedMission;
import umc.spring.web.dto.*;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/missions/{missionId}")
    @NonDuplicatedMission
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDTO> challengeMission(@ExistMember @PathVariable(name = "memberId") Long memberId,
                                                                                   @PathVariable(name = "missionId") Long missionId){
        Mission mission = memberMissionService.addMission(missionId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(mission));
    }

}
