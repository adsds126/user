package hello.user.service;

import hello.user.domain.Member;
import hello.user.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void Join() {
        //given : 상황이 주어질때
        Member member = new Member();
        member.setName("spring");

        //when : 이걸 실행(검증)했을때
        Long saveId = memberService.join(member);

        //then : 결과는 이렇게 나와야함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given : 상황이 주어질때
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when : 이걸 실행(검증)했을때
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then : 결과는 이렇게 나와야함
    }

    @Test
    void findMembers() {
        //given : 상황이 주어질때

        //when : 이걸 실행(검증)했을때

        //then : 결과는 이렇게 나와야함

    }

    @Test
    void findOne() {
        //given : 상황이 주어질때

        //when : 이걸 실행(검증)했을때

        //then : 결과는 이렇게 나와야함

    }
}
