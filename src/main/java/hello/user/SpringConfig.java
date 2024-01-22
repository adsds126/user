package hello.user;

import hello.user.repository.MemberRepository;
import hello.user.repository.MemoryMemberRepository;
import hello.user.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//controller는 @Autowired, 나머진 자바코드로 직접 스프링 빈 등록이 가능하다 아래와같이.
//하지만 그냥 @Service @Repository 로 쓰는게 더 편함.
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return  new MemoryMemberRepository();
//    }
//}
