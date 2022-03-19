package com.example.service;

import java.util.List;

import com.example.pojo.NumberObj;

public interface INumberService {
	
	public List<NumberObj> findAll();

	public NumberObj findAllbyId(long id);

	public void addNumber(NumberObj number);

	public void updateNumber(NumberObj number);

}
