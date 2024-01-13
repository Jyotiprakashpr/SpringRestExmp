package com.jp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jp.entities.Mphn;
import com.jp.services.MphnService;

@RestController
public class MyController {

	@Autowired
	private MphnService mphnService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to MobilePhone List App";
	}

	@GetMapping("/mphones")
	public List<Mphn> getMphn() {
		return this.mphnService.getMphns();
	}

	@GetMapping("/mphones/{MphnId}")
	public Mphn getMphn(@PathVariable String MphnId) {
		return this.mphnService.getMphn(Long.parseLong(MphnId));

	}

	@PostMapping("/mphones")
	public Mphn addMphn(@RequestBody Mphn mphn) {
		return this.mphnService.addMphn(mphn);
	}

	@PutMapping("/mphones")
	public Mphn UpdateMphn(@RequestBody Mphn mphn) {
		return this.mphnService.UpdateMphn(mphn);
	}

	@DeleteMapping("/mphones/{MphnId}")
	public ResponseEntity<HttpStatus> deleteMphn(@PathVariable String MphnId) {
		try {
			this.mphnService.deleteMphn(Long.parseLong(MphnId));
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
