//package com.jpabool.jpashop.repository;
//
//import com.jpabool.jpashop.domain.Member;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@SpringBootTest
//class MemberRepositoryTest {
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional
////    @Rollback(value = false)
//    public void testMember () throws Exception {
//        //GIVENT
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//
//        Assertions.assertThat(findMember).isEqualTo(member);
//        //저장한것과 조회한것은 다를까 ? -> ture다
//        // 같은 트랜잭션안에서 저장하고 조회하면 영속성 컨텍스트가 똑같기 때문 같은 영속성 컨텍스트안에서 식별자 값이 같으면 같다 1차캐시
//
//
//    }
//
//
//}
//
