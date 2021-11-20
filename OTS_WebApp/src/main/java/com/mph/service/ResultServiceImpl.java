package com.mph.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ResultDao;
import com.mph.entity.Result;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {
	
	@Autowired
    ResultDao resultDao;
    
    @Override
    public List<Result> getResultList() {
        
        return resultDao.getResultList();
    }
    @Override
    public void addResult(Result result) {
        resultDao.addResult(result);
	
}
    @Override
    public List<Result> deleteResult(int rid) {
        return resultDao.deleteResult(rid);
    }
    @Override
    public Result getResultID(int rid) {
        return resultDao.getResultID(rid);
    }
    @Override
    public List<Result> searchResultById(int rid) {
        return resultDao.searchResultById(rid);
    }
    
    
    
    
    
    
    
}
