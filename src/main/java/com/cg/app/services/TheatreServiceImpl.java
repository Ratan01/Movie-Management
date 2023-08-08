package com.cg.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.TheatreDao;
import com.cg.app.entities.Theatre;

import jakarta.transaction.Transactional;

@Service("theatreService")
@Transactional
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	TheatreDao theatreDao;

	public Theatre save(Theatre theatre) {
		return theatreDao.save(theatre);
	}

	public List<Theatre> findAll() {
		return theatreDao.findAll();
	}

	public Theatre find(Integer theatreId) {
		return theatreDao.find(theatreId);
	}

	public Theatre remove(Integer theatreId) {
		return theatreDao.remove(theatreId);
	}

}
