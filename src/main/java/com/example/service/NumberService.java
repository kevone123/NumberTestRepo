package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.NumbersDao;
import com.example.pojo.NumberObj;

@Service
public class NumberService implements INumberService {
	
	@Autowired
	NumbersDao numbersDao;
	
	@Override
	public List<NumberObj> findAll() {
		
		return numbersDao.getNumbers();
	}
	
	@Override
	public NumberObj findAllbyId(long id) {
		return numbersDao.getNumberById(id);
	}
	
	@Override
	public void addNumber(NumberObj number) {
		 numbersDao.insertNumber(number);

	}
	
	@Override
	public void updateNumber(NumberObj number) {
		numbersDao.updateNumber(number);
		
	}

}
