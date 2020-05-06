package com.CESI.bankonet;

public class CompteCourant {
	String nom;
	String numero;
	String intitule;
	double solde = 0.0f;
	double montantDecouvertAutorise = 0.0f;
	static int nbCompteCourant = 0;
	
	public CompteCourant() {
		++ CompteCourant.nbCompteCourant;
	}
	
	public void creditAccount(double amount) {
		this.solde += amount;
	}
	
	public void debitAccount(double amount) {
		this.solde -= amount;
	}
}
