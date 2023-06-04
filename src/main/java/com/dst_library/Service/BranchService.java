package com.dst_library.Service;

import com.dst_library.Entity.Branch;
import com.dst_library.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Async
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Async
    public Branch getById(Long idBranch) {
        return branchRepository.findById(idBranch).orElse(null);
    }

    @Async
    public void create(Branch branch) {
        branchRepository.save(branch);
    }

    @Async
    public void delete(Long idBranch) {
        branchRepository.deleteById(idBranch);
    }

    @Async
    public void update(Branch branch) {
        Branch _branch = getById(branch.getIdBranch());
        _branch.setAddress(branch.getAddress());
        _branch.setActualBookNumber(branch.getActualBookNumber());
        _branch.setNominalBookNumber(branch.getNominalBookNumber());
        branchRepository.save(_branch);
    }


}
