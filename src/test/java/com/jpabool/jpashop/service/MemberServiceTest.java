package com.jpabool.jpashop.service;

import com.jpabool.jpashop.domain.Member;
import com.jpabool.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceTest {
//    Given: 테스트를 위한 사전 조건과 데이터 설정
//    When: 테스트하고자 하는 행동/기능 실행
//    Then: 예상되는 결과 검
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    //같은 트랜잭션 안에서 pk값이 같으면 같은 영속성 컨텍스트에 하나로 관린된다
    @Test
//    @Rollback(value = false)//??
    public void 회원가입() throws Exception{
        Member member = new Member();

        member.setName("이광현");
        Long id = memberService.join(member);
        assertEquals(member,memberService.findOne(id));


//        Long findId = memberService.findOne(id).getId();
//        org.assertj.core.api.Assertions.assertThat(id).isEqualTo(findId);


    }
    @Test
    public void 중복_회원_예외() throws Exception{
        Member member = new Member();
        member.setName("이광현");

        Member member2 = new Member();
        member2.setName("이광현");
        memberService.join(member);
        memberService.join(member2);

        fail("예외가 발생해야한다.");
    }
}
