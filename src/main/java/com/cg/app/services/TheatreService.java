package com.cg.app.services;

import java.util.List;

import com.cg.app.entities.Theatre;

public interface TheatreService {
	public Theatre save(Theatre theatre);
	public List<Theatre> findAll();
	public Theatre find(Integer theatreId);
	public Theatre remove(Integer theatreId);
}
