package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.Member;
import lk.ctech.librarymanagementsystem.repo.MemberRepo;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
