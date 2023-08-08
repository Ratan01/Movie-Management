package com.cg.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.ShowDao;
import com.cg.app.entities.Show;

import jakarta.transaction.Transactional;

@Service("showService")
@Transactional
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	ShowDao showDao;

	public Show save(Show show) {
		return showDao.save(show);
	}

	public List<Show> findAll() {
		return showDao.findAll();
	}

	public Show find(Integer showId) {
		return showDao.find(showId);
	}

	public Show remove(Integer showId) {
		return showDao.remove(showId);
	}

}
