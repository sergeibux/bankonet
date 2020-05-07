package com.CESI.bankonet;

public class CompteCourant extends Compte {
	private String nom;
	private double montantDecouvertAutorise = 0.0f;
	private static int nbCompteCourant = 0;
	
	public CompteCourant(double soldeInitial) {
		super.initSolde(soldeInitial);
		++ CompteCourant.nbCompteCourant;
	}
	
	public void creditAccount(double amount) {
		System.out.println("cour");
		super.creditAccount(amount, -(this.montantDecouvertAutorise));
	}
	
	public void debitAccount(double amount) {
		super.debitAccount(amount, -(this.montantDecouvertAutorise));
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "Découvert autorisé : " + this.montantDecouvertAutorise + "\n";
		str += "\n\tIl y a " + CompteCourant.nbCompteCourant + " comptes courants enregistrés";
		
		str += "\n________________________________________________________\n";
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bool = true;

		if ((!super.equals(obj)) ||
				(this.nom != ((CompteCourant)obj).getNom()) ||
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

	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	public static int getNbCompteCourant() {
		return nbCompteCourant;
	}
}
