package com.cg.app.services;

import java.util.List;

import com.cg.app.entities.Show;

public interface ShowService {
	public Show save(Show show);
	public List<Show> findAll();
	public Show find(Integer showId);
	public Show remove(Integer showId);
}
