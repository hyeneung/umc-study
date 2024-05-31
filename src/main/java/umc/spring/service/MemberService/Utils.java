package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Utils {
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    public boolean isValid(List<Long> foodCategoryIds){
        return foodCategoryIds.stream()
                .allMatch(id -> foodCategoryRepository.existsById(id));
    }
    public Boolean isExist(long memberId, long missionId){
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId);
        return memberMission != null;
    }
}