package lk.ctech.librarymanagementsystem.service;

import lk.ctech.librarymanagementsystem.model.IssueItem;
import lk.ctech.librarymanagementsystem.repo.IssueItemRepo;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueItemServiceImpl implements IssueItemService {
    @Autowired
    private IssueItemRepo issueItemRepo;

    @Override
    public String addIssueItem(IssueItem issueItem) {
        if (issueItemRepo.existsById(issueItem.getIssueId())){
            return VarList.RSP_DUPLICATED;
        }else {
            issueItemRepo.save(issueItem);
            return VarList.RSP_SUCCESS;
        }
    }


}
