package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Member;

import java.util.List;

public interface MemberService {
    String saveMember(Member member);
    String updateMember(Member member);
    List<Member> getAllMembers();
}
