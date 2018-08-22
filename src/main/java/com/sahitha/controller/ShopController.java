package com.sahitha.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ShopController {
	@Autowired
	ShopImpl shopdao;

	@RequestMapping(value = "/shop/", method = RequestMethod.POST)
	public ResponseEntity<Void> createShop(@RequestBody Shop s, UriComponentsBuilder ucBuilder) {

		shopdao.createShop(s);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Shop> updateShop(@RequestBody Shop s) {

		shopdao.updateShop(s);

		return new ResponseEntity<Shop>(s, HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Shop> deleteShop(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting User with id " + id);
		shopdao.deleteById(id);

		return new ResponseEntity<Shop>(HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> findById(@PathVariable("id") int id) {
		Shop s = shopdao.findById(id);

		return new ResponseEntity<Shop>(s, HttpStatus.OK);

	}

	@RequestMapping(value = "/shop/", method = RequestMethod.GET)
	public ResponseEntity<List<Shop>> findAll() throws IOException {

		List<Shop> list = shopdao.findAll();

		if (list.isEmpty()) {
			return new ResponseEntity<List<Shop>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Shop>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/", method = RequestMethod.DELETE)
	public ResponseEntity<Shop> deleteAll() {

		shopdao.deleteAll();

		return new ResponseEntity<Shop>(HttpStatus.OK);
	}
}
