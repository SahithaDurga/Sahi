package com.sahitha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopImpl {
	@Autowired
	ShopRepo shoprepo;

	public Shop findById(int id) {
		Shop s = shoprepo.getOne(id);
		return s;
	}

	public List<Shop> findAll() {
		List<Shop> list = shoprepo.findAll();
		return list;
	}

	public void createShop(Shop s) {
		shoprepo.save(s);
	}

	public void updateShop(Shop s) {

		shoprepo.save(s);
	}

	public void deleteById(int id) {
		shoprepo.deleteById(id);
	}

	public void deleteAll() {
		shoprepo.deleteAll();
	}

}
