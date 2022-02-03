package com.lubriweb.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Orden;
import com.lubriweb.pe.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordnrepo;

	@Override
	public Orden save(Orden orden) {

		return ordnrepo.save(orden);
	}

	@Override
	public List<Orden> findAll() {

		return ordnrepo.findAll();
	}

	// 000010
	public String generarNumeroOrden() {

		int numero = 0;
		String numConcat = "";

		List<Orden> ordenes = findAll();

		List<Integer> numeros = new ArrayList<Integer>();

		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

		if (ordenes.isEmpty()) {

			numero = 1;

		} else {

			numero = numeros.stream().max(Integer::compare).get();
			numero++;

		}

		if (numero < 10) {// 00001

			numConcat = "0000" + String.valueOf(numero);

		} else if (numero < 100) {

			numConcat = "000" + String.valueOf(numero);

		} else if (numero < 1000) {

			numConcat = "00" + String.valueOf(numero);
		} else if (numero < 10000) {

			numConcat = "00" + String.valueOf(numero);
		}

		return numConcat;

	}

}
