package com.CESI.bankonet;

public abstract class Compte {
	private String numero;
	private String intitule;
	private double solde = 0.0f;

	void initSolde(double amount) {
		if (amount < 0) {
			this.solde = 0;
			System.out.println("Votre solde est inférieur à 0 : impossible.\n\tInitialisation avec solde = 0\n\n");
		} else {
			this.solde = amount;
		}
	}
	
	public void creditAccount(double amount, double floor) {
		if (amount < 0) {
			debitAccount(-amount, floor);
		} else {
			this.solde += amount;
		}
	}
	
	public void debitAccount(double amount, double floor) {
		if (amount < 0) {
			creditAccount(-amount, floor);
		} else {
			double soldePrevisionnel = this.solde - amount;
			if (soldePrevisionnel < floor) {
				System.out.println("Le solde de votre compte (" + this.solde + ") ne vous permet pas d'effectuer cette opération.");
			} else {
				this.solde = soldePrevisionnel;
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "\n________________________________________________________";
		
		str = "Solde du commpte " + this.numero + " :\n\t";
		str += Math.ceil(this.solde*100)/100 + " €\n";
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bool = true;

		if ((this.numero != ((Compte)obj).numero) || 
				(this.intitule != ((Compte)obj).intitule) ||
				(this.solde != ((Compte)obj).solde)) {
			bool = false;
		}
		
		return bool;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
