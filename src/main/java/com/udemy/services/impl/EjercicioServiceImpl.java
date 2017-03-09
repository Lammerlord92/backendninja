package com.udemy.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.services.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService{
	private static final Log LOG=LogFactory.getLog(EjercicioServiceImpl.class);

	@Override
	public void showLogInfo() {
		LOG.info("-- LOG DE EJERCICIO --");
	}

}
