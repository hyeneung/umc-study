package umc.spring.service.MemberMissionService;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberMissionService {
    Mission addMission(Long missionId, Long memberId);
}
