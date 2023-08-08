package com.cg.app.dao;

import java.util.List;

import com.cg.app.entities.Theatre;

public interface TheatreDao {

	public Theatre save(Theatre theatre);
	public List<Theatre> findAll();
	public Theatre find(Integer theatreId);
	public Theatre remove(Integer theatreId);
		
}
