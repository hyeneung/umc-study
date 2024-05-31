package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Utils {
    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    public boolean isValid(List<Long> foodCategoryIds){
        return foodCategoryIds.stream()
                .allMatch(id -> foodCategoryRepository.existsById(id));
    }
}