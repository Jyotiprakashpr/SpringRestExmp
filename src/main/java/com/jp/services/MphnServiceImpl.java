package com.jp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.dao.MphnDao;
import com.jp.entities.Mphn;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MphnServiceImpl implements MphnService {

	@Autowired
	private MphnDao mphnDao;
	
	//List<Mphn> list;

	public MphnServiceImpl() {

		/*
		 * list = new ArrayList<>(); list.add(new Mphn(1, "Realme",
		 * "This Is Realme Phone")); list.add(new Mphn(2, "Apple",
		 * "This is Apple Phone")); list.add(new Mphn(3, "Iqoo", "This Is Iqoo Phone"));
		 */	}

	@Override
	public List<Mphn> getMphns() {

		return mphnDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Mphn getMphn(long mphnId) {
		/*
		 * Mphn mp = null; for (Mphn mphn : list) { if (mphn.getId() == mphnId) { mp =
		 * mphn; break; } }
		 */
		return mphnDao.getOne(mphnId);
	}

	@Override
	public Mphn addMphn(Mphn mphn) {
		//list.add(mphn);
		mphnDao.save(mphn);
		return mphn;
	}

	@Override
	public Mphn UpdateMphn(Mphn mphn) {
		/*
		 * list.forEach(e -> { if (e.getId() == mphn.getId()) {
		 * e.setName(mphn.getName()); e.setDescription(mphn.getDescription()); } });
		 */
		mphnDao.save(mphn);
		return mphn;
	}
/*
	@Override
	public void deleteMphn(long mphnId) {
		//list = this.list.stream().filter(e -> e.getId() != mphnId).collect(Collectors.toList());
		mphnDao.getOne(mphnId);
		mphnDao.delete(null);
*/
	@Override
	public void deleteMphn(long mphnId) {
	    
	    Mphn mphn = mphnDao.getOne(mphnId);

	   
	    if (mphn != null) {
	        // Delete the entity
	        mphnDao.delete(mphn);
	    } else {
	
	        throw new EntityNotFoundException("MphnEntity with ID " + mphnId + " not found");
	    }
	}

	}


