package com.jpabool.jpashop.service;


import com.jpabool.jpashop.domain.Member;
import com.jpabool.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository  memberRepository;

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }


    /**
     * 회원가입
     * */
     @Transactional
    public Long join (Member member){
        validateDuplicateMember(member);
        Long id = memberRepository.save(member);
        return id;
    }

    private void validateDuplicateMember(Member member) {
          List<Member> findMembers  = memberRepository.findByName(member.getName());
          if(!findMembers.isEmpty()){
              throw new IllegalStateException("이미 존재하는 회원");
          }
    }
    @Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Member findOne(Long memeberId){
         return memberRepository.findOne(memeberId);
    }
}
