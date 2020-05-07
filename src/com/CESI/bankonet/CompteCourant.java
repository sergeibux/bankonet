package com.CESI.bankonet;

public class CompteCourant {
	private String nom;
	private String numero;
	private String intitule;
	private double solde = 0.0f;
	private double montantDecouvertAutorise = 0.0f;
	private static int nbCompteCourant = 0;
	
	public CompteCourant(double soldeInitial) {
		if (soldeInitial < 0) {
			this.solde = 0;
			System.out.println("Votre solde est inférieur à 0 : impossible.\n\tInitialisation avec solde = 0\n\n");
		}
		this.solde = solde;
		++ CompteCourant.nbCompteCourant;
	}
	
	public void creditAccount(double amount) {
		if (amount < 0) {
			debitAccount(-amount);
		} else {
			this.solde += amount;
		}
	}
	
	public void debitAccount(double amount) {
		if (amount < 0) {
			creditAccount(-amount);
		} else {
			double soldePrevisionnel = this.solde - amount;
			if (soldePrevisionnel < -(this.montantDecouvertAutorise)) {
				System.out.println("Le solde de votre compte (" + this.solde + ") ne vous permet pas d'effectuer cette opération.");
			} else {
				this.solde = soldePrevisionnel;
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "\n________________________________________________________";
		
		str = "Solde du commpte de ";
		str += this.nom;
		str += " (" + this.numero + ") :\n\t";
		str += Math.ceil(this.solde*100)/100 + " €\n";
		str += "Découvert autorisé : " + this.montantDecouvertAutorise + "\n";
		str += "\n\tIl y a " + CompteCourant.nbCompteCourant + " comptes courants enregistrés";
		
		str += "\n________________________________________________________\n";
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bool = true;

		if ((this.nom != ((CompteCourant)obj).nom) ||
				(this.numero != ((CompteCourant)obj).numero) ||
				(this.intitule != ((CompteCourant)obj).intitule) ||
				(this.solde != ((CompteCourant)obj).solde) ||
				(this.montantDecouvertAutorise != ((CompteCourant)obj).montantDecouvertAutorise)){
			bool= false;
		}
		
		return bool;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	public static int getNbCompteCourant() {
		return nbCompteCourant;
	}

	public static void setNbCompteCourant(int nbCompteCourant) {
		CompteCourant.nbCompteCourant = nbCompteCourant;
	}
}
