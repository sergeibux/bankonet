package com.CESI.bankonet;

public class Client {
	private String nom;
	private String prenom;
	private String identifiant;
	
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;

	private static int nbClients = 0;
	
	public Client(String nom, String prenom, String identifiant, CompteCourant compteCourant, CompteEpargne compteEpargne) {
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		
		++ Client.nbClients;
	}
	
	public double calculerAvoirGlobal() {
		double avoir = 0.0;
		
		avoir += this.compteCourant.getSolde();
		avoir += this.compteEpargne.getSolde();
		
		return avoir;
	}
	
	@Override
	public String toString() {
String str = "\n________________________________________________________";
		
		str = "Client : ";
		str += this.nom;
		str += " " + this.prenom + "\n\t";
		str += "identifiant : " + this.identifiant + "\n";
		str += "\n\tIl y a " + Client.nbClients + " clients enregistrés";
		
		str += "\n________________________________________________________\n";
		return str;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public static int getNbClients() {
		return nbClients;
	}

	public static void setNbClients(int nbClients) {
		Client.nbClients = nbClients;
	}

	
}
