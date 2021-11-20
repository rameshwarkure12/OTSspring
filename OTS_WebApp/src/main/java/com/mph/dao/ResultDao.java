package com.mph.dao;

import java.util.List;

import com.mph.entity.Result;

public interface ResultDao {
	
	  public List<Result> getResultList();    
    public void addResult(Result result);
    
    public List<Result> deleteResult(int rid);
    public Result getResultID(int rid);
    public List<Result> searchResultById(int rid);

}
