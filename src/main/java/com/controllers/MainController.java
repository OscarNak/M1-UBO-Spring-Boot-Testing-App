package com.controllers;

import com.dtos.UtilisateurDto;
import com.services.impl.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MainController {

	private final UtilisateurServiceImpl userService;

	public MainController(UtilisateurServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<UtilisateurDto> getUtilisateurs(){
		return userService.getUtilisateurs();
	}

	@GetMapping("/{id}")
	public UtilisateurDto getUtilisateur(@PathVariable Long id){
		return userService.getUserById(id);
	}

	@PostMapping
	public UtilisateurDto saveUtilisateur(final @RequestBody UtilisateurDto userDto){
		System.out.println(userDto);
		return userService.saveUtilisateur(userDto);
	}

	@DeleteMapping("/{id}")
	public Boolean deleteUtilisateur(@PathVariable Long id){
		return userService.deleteUser(id);
	}
}
