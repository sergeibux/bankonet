package com.CESI.bankonet;

public class CompteEpargne {
	private String nom;
	private String numero;
	private String intitule;
	private double solde = 0.0f;
	private double tauxInteret = 0.0f;
	private static int nbCompteEpargne = 0;
	
	public CompteEpargne(double soldeInitial) {
		if (soldeInitial < 0) {
			this.solde = 0;
			System.out.println("Votre solde est inférieur à 0 : impossible.\n\tInitialisation avec solde = 0\n\n");
		}
		this.solde = solde;
		++ CompteEpargne.nbCompteEpargne;
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
			if (soldePrevisionnel < -(this.tauxInteret)) {
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
		str += "Taux d'intérêt : " + this.tauxInteret + "\n";
		str += "\n\tIl y a " + CompteEpargne.nbCompteEpargne + " comptes courants enregistrés";
		
		str += "\n________________________________________________________\n";
		return str;
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

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public static int getNbCompteEpargne() {
		return nbCompteEpargne;
	}

	public static void setNbCompteEpargne(int nbCompteCourant) {
		CompteEpargne.nbCompteEpargne = nbCompteCourant;
	}
}
