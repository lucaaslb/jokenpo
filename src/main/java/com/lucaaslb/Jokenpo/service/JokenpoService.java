package com.lucaaslb.Jokenpo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lucaaslb.Jokenpo.model.Jogadores;

@Service
public class JokenpoService {

	private List<Jogadores> listJogadores = new ArrayList<Jogadores>();

	public void clear() {
		listJogadores.clear();
	}

	public void cadastrarJogarJogada(int numeroJogador, String ferramenta) {
		Jogadores j = new Jogadores(numeroJogador, ferramenta);
		listJogadores.add(j);
	}

	public List<Jogadores> getJogadores() {
		return listJogadores;
	}

	public void removeJogador(int numeroJogador) {
		listJogadores.removeIf(u -> u.getNumero() == numeroJogador);

	}

	public void jogar(List<Jogadores> listJogar) {

		if (listJogar.size() <= 1) {
			return;
		} else {
			verificaVencedor(listJogar);
			jogar(listJogar);
		}
	}

	private static void verificaVencedor(List<Jogadores> listJogar) {

		HashMap<String, String> hashDeFraquezas = new HashMap<String, String>();
		hashDeFraquezas.put("PEDRA", "PAPEL,SPOCK");
		hashDeFraquezas.put("PAPEL", "TESOURA,LAGARTO");
		hashDeFraquezas.put("TESOURA", "PEDRA,SPOCK");
		hashDeFraquezas.put("LAGARTO", "PEDRA,TESOURA");
		hashDeFraquezas.put("SPOCK", "PAPEL,LAGARTO");

		if (listJogar.size() >= 2) {
			if (listJogar.get(0).getFerramenta().equals(listJogar.get(1).getFerramenta())) {

				if (listJogar.size() == 3
						&& (listJogar.get(1).getFerramenta().equals(listJogar.get(2).getFerramenta()))) {
					listJogar.clear();
					return;
				}
				listJogar.remove(0);

			} else if (hashDeFraquezas.get(listJogar.get(0).getFerramenta())
					.contains(listJogar.get(1).getFerramenta())) {
				listJogar.remove(0);
			} else if (hashDeFraquezas.get(listJogar.get(1).getFerramenta())
					.contains(listJogar.get(0).getFerramenta())) {
				listJogar.remove(1);

			}
		}

	}

}
