package com.lucaaslb.Jokenpo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lucaaslb.Jokenpo.model.Jogadores;
import com.lucaaslb.Jokenpo.service.JogadasService;

@RestController
public class JokenpoController {

	@Autowired
	public JogadasService jogadasService;

	@GetMapping("jogador/{numeroJogador}/jogada/{ferramenta}")
	public String cadastrarJogador(@PathVariable int numeroJogador, @PathVariable String ferramenta) {

		jogadasService.cadastrarJogarJogada(numeroJogador, ferramenta.toUpperCase());
		return "Jogador: " + numeroJogador + " cadastrado, jogada: " + ferramenta.toUpperCase();
	}

	@GetMapping("jogadores")
	public List<Jogadores> getJogadores() {
		return jogadasService.getJogadores();
	}

	@GetMapping("novoJogo")
	public ResponseEntity<?> clearJogadores() {
		jogadasService.clear();
		return ResponseEntity.ok().build();
	}

	@GetMapping("jogar")
	public String jogar() {

		String ret = null;

		List<Jogadores> listJogadoresAux = new ArrayList<Jogadores>(jogadasService.getJogadores());

		if (listJogadoresAux.isEmpty()) {
			ret = "NÃO EXISTEM JOGADORES CADASTRADOS";
			return ret;
		}

		jogadasService.jogar(listJogadoresAux);

		if (listJogadoresAux.isEmpty()) {
			ret = "EMPATE";
		} else {
			ret = "Resultado: " + "Jogador: " + listJogadoresAux.get(0).getNumero() + ", Jogada: "
					+ listJogadoresAux.get(0).getFerramenta() + ", Vitoria!";
		}

		return ret;

	}
}
