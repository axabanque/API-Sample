package com.octo.simplepfm.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWordlService {
	public String getData() {
		return "this is a cool data given by a spring service";
	}
}
