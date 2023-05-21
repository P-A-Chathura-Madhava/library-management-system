package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Member;
import lk.ctech.librarymanagementsystem.repo.MemberRepo;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepo memberRepo;

    @Override
    public String saveMember(Member member) {
        if (memberRepo.existsById(member.getMemberId())){
            return VarList.RSP_DUPLICATED;
        }else {
            memberRepo.save(member);
            return VarList.RSP_SUCCESS;
        }
    }
    @Override
    public String updateMember(Member member) {
        if (memberRepo.existsById(member.getMemberId())){
            memberRepo.save(member);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Member searchMemberById(int id) {
        if (memberRepo.existsById(id)){
            Member member = memberRepo.findById(id).orElse(null);
            return member;
        }else {
            return null;
        }
    }

    @Override
    public String deleteMemberById(int id) {
        if (memberRepo.existsById(id)){
            memberRepo.deleteById(id);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
