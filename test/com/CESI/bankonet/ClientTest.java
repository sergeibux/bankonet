package com.CESI.bankonet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ClientTest {


	private static CompteCourant compteCourant1;
	private static CompteCourant compteCourant2;
	private static CompteCourant compteCourant3;

	private static CompteEpargne compteEpargne1;
	private static CompteEpargne compteEpargne2;
	private static CompteEpargne compteEpargne3;
	
	private static Client clientDeuxCpt;
	private static Client clientCourantUniquement;
	private static Client clientEpargneUniquement;
	private static Client clientSansCpt;

	@BeforeAll
	static void init() {
		compteCourant1 = new CompteCourant(0.0);
		compteCourant2 = new CompteCourant(15.0);
		compteCourant3 = new CompteCourant(544.01);
		
		compteEpargne1 = new CompteEpargne(5.21);
		compteEpargne2 = new CompteEpargne(0.0);
		compteEpargne3 = new CompteEpargne(404.0);

		clientDeuxCpt = new Client("Monsieur", "Chanceux", "G41FSGS52", null, null);
		clientCourantUniquement = new Client("Miss", "Boule de Gomme", "FR424242BE", null, null);
		clientEpargneUniquement = new Client("Mister", "Mystère", "BE3145241", null, null);
		clientSansCpt = new Client("Madame", "Dou Naute Douwite", "CZ145SZ4210", null, null);
	}
	
	@BeforeEach
	void decouvertNull() {
		compteCourant1.setMontantDecouvertAutorise(0.0);
		compteCourant2.setMontantDecouvertAutorise(0.0);
		compteCourant3.setMontantDecouvertAutorise(0.0);
	}
	
	@Test
	void testConstructors() {
		assertEquals("Monsieur", clientDeuxCpt.getNom());
		assertEquals("Chanceux", clientDeuxCpt.getPrenom());
		assertEquals("G41FSGS52", clientDeuxCpt.getIdentifiant());
		
		assertEquals("Miss", clientCourantUniquement.getNom());
		assertEquals("Boule de Gomme", clientCourantUniquement.getPrenom());
		assertEquals("FR424242BE", clientCourantUniquement.getIdentifiant());

		assertEquals("Mister", clientEpargneUniquement.getNom());
		assertEquals("Mystère", clientEpargneUniquement.getPrenom());
		assertEquals("BE3145241", clientEpargneUniquement.getIdentifiant());

		assertEquals("Madame", clientSansCpt.getNom());
		assertEquals("Dou Naute Douwite", clientSansCpt.getPrenom());
		assertEquals("CZ145SZ4210", clientSansCpt.getIdentifiant());
	}
	
	@Test void testGiveAccounts() {
		clientDeuxCpt.setCompteCourant(compteCourant1);
		clientDeuxCpt.setCompteEpargne(compteEpargne1);

		clientCourantUniquement.setCompteCourant(compteCourant2);

		clientEpargneUniquement.setCompteEpargne(compteEpargne3);

		assertEquals(true, compteCourant1.equals(clientDeuxCpt.getCompteCourant()));
		assertEquals(true, compteEpargne1.equals(clientDeuxCpt.getCompteEpargne()));

		assertEquals(true, compteCourant2.equals(clientCourantUniquement.getCompteCourant()));
		assertEquals(null, clientCourantUniquement.getCompteEpargne());
		
		assertEquals(true, compteEpargne3.equals(clientEpargneUniquement.getCompteEpargne()));
		assertEquals(null, clientEpargneUniquement.getCompteCourant());

		assertEquals(null, clientSansCpt.getCompteCourant());
		assertEquals(null, clientSansCpt.getCompteEpargne());
	}

	@Test
	public void testnbClient() {
		assertEquals(3, CompteCourant.getNbCompteCourant(), 0);
	}

	
	@Test
	void testToString(){
		System.out.println(clientDeuxCpt.toString());
	}
}











