package com.mifel.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mifel.model.Item;
import com.mifel.service.ItemService;
import com.mifel.utils.EncriptadorAES;
import com.mifel.utils.SecretKeyContext;

@RestController
@RequestMapping("products")
public class ItemController {

	@Autowired
	ItemService item_service;

	@GetMapping("/get_all")
	public List<Item> getAll() {
		return item_service.getItems();
	}

	@PostMapping("/save_product")
	public Item saveItem(@RequestBody Item item) {
		return item_service.saveItem(item);
	}

	@PostMapping("/get_product")
	public List<Item> getProduct(@RequestBody Item item) {
		return item_service.findByNameIgnoraCaseContaining(item.getName());
	}

	@GetMapping("/pokemon")
	public String llamarApi() {
		String uri = "https://pokeapi.co/api/v2/pokemon/ditto";
		RestTemplate restTemplate = new RestTemplate();
		String resultados = restTemplate.getForObject(uri, String.class);
		return resultados;
	}
	
	@Autowired
	EncriptadorAES aes;
	
	SecretKeyContext skc = new SecretKeyContext();
	
	@GetMapping("/crear_clave/{cadena}")
	public SecretKeySpec  crearClave(@PathVariable("cadena") String cadena) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		skc.setClave(cadena);
		
		return aes.crearClave(cadena);
	}
	
	@PostMapping("/encriptar")
	public String  encriptar(@RequestBody SecretKeyContext x) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		return aes.encriptar(x.getDato(), x.getClave());
	}
	
	@PostMapping("/desencriptar")
	public String  desencriptar(@RequestBody SecretKeyContext x) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		return aes.desencriptar(x.getDato(), x.getClave());
	}
	
	
}
