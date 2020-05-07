package com.CESI.bankonet;

public class CompteEpargne extends Compte {
	private String nom;
	private double tauxInteret = 0.0f;
	private static int nbCompteEpargne = 0;
	
	public CompteEpargne(double soldeInitial) {
		super.initSolde(soldeInitial);
		++ CompteEpargne.nbCompteEpargne;
	}
	
	public void creditAccount(double amount) {
		super.creditAccount(amount, 0.0);
	}
	
	public void debitAccount(double amount) {
		super.debitAccount(amount, 0.0);
	}
	
	
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "Taux d'intérêt : " + this.tauxInteret + "\n";
		str += "\n\tIl y a " + CompteEpargne.nbCompteEpargne + " comptes courants enregistrés";
		
		str += "\n________________________________________________________\n";
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bool = true;

		if ((!super.equals(obj)) || 
				(this.nom != ((CompteEpargne)obj).getNom()) ||
				(this.tauxInteret != ((CompteEpargne)obj).getTauxInteret())) {
			bool = false;
		}
		
		return bool;
	}
	
	public void calculerInterets() {
		super.setSolde(super.getSolde() + (super.getSolde() * (this.tauxInteret / 100)));
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
}
