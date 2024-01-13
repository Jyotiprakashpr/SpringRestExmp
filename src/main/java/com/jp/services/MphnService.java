package com.jp.services;

import java.util.List;

import com.jp.entities.Mphn;

public interface MphnService {
	
	public List<Mphn> getMphns();
	
	public Mphn getMphn(long mphnId);
	
	public Mphn addMphn(Mphn mphn);
	
	public Mphn UpdateMphn(Mphn mphn);
	
	public void  deleteMphn (long mphnId);

}
