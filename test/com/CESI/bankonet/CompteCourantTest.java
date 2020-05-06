package com.CESI.bankonet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompteCourantTest {

	@Test
	void testCpt1() {
		int nbCpt = CompteCourant.nbCompteCourant;
		CompteCourant compteCourant1 = new CompteCourant();
		
		compteCourant1.nom = "Moi";
		compteCourant1.intitule = "Mon premier compte";
		compteCourant1.numero = "424 42854 254";
		compteCourant1.solde = 120.22f;
		compteCourant1.montantDecouvertAutorise = 150.0f;

		assertEquals("Moi", compteCourant1.nom);
		assertEquals("Mon premier compte", compteCourant1.intitule);
		assertEquals("424 42854 254", compteCourant1.numero);
		assertEquals(120.22f, compteCourant1.solde);
		assertEquals(150.0f, compteCourant1.montantDecouvertAutorise);
		assertEquals(nbCpt + 1, CompteCourant.nbCompteCourant);
	}
		
	@Test
	void testCpt2() {
		int nbCpt = CompteCourant.nbCompteCourant;
		CompteCourant compteCourant2 = new CompteCourant();
		
		compteCourant2.nom = "Toi";
		compteCourant2.intitule = "Ton premier compte";
		compteCourant2.numero = "549 241542 57";
		compteCourant2.solde = 20120.59f;
		compteCourant2.montantDecouvertAutorise = 0.0f;
		
		assertEquals("Toi", compteCourant2.nom);
		assertEquals("Ton premier compte", compteCourant2.intitule);
		assertEquals("549 241542 57", compteCourant2.numero);
		assertEquals(20120.59f, compteCourant2.solde);
		assertEquals(0.0f, compteCourant2.montantDecouvertAutorise);
		assertEquals(nbCpt + 1, CompteCourant.nbCompteCourant);
	}

	@Test
	void testCpt3() {
		int nbCpt = CompteCourant.nbCompteCourant;
		CompteCourant compteCourant3 = new CompteCourant();

		compteCourant3.nom = "Quelqu\'un d\'autre";
		compteCourant3.intitule = "Ceci est aussi un compte";
		compteCourant3.numero = "24554 521524 1558";
		compteCourant3.solde = -40.32f;
		compteCourant3.montantDecouvertAutorise = 50.0f;

		assertEquals("Quelqu\'un d\'autre", compteCourant3.nom);
		assertEquals("Ceci est aussi un compte", compteCourant3.intitule);
		assertEquals("24554 521524 1558", compteCourant3.numero);
		assertEquals(-40.32f, compteCourant3.solde);
		assertEquals(50.0f, compteCourant3.montantDecouvertAutorise);
		assertEquals(nbCpt + 1, CompteCourant.nbCompteCourant);
	}

	@Test
	void testCreditValues() {
		CompteCourant compteCourant1 = new CompteCourant();
		CompteCourant compteCourant2 = new CompteCourant();
		CompteCourant compteCourant3 = new CompteCourant();

		compteCourant1.solde = 1212.70f;
		double soldeAnterieur = compteCourant1.solde;
		compteCourant1.creditAccount(2.0f);
		assertEquals((soldeAnterieur + 2.0f), compteCourant1.solde);
		
		compteCourant2.solde = 411.04f;
		soldeAnterieur = compteCourant2.solde;
		compteCourant2.creditAccount(5.0f);
		assertEquals((soldeAnterieur + 5.0f), compteCourant2.solde);

		compteCourant3.solde = 524825.21f;
		soldeAnterieur = compteCourant3.solde;
		compteCourant3.creditAccount(8.0f);
		assertEquals((soldeAnterieur + 8.0f), compteCourant3.solde);
	}
	
	@Test
	void testDebitValues() {
		CompteCourant compteCourant1 = new CompteCourant();
		CompteCourant compteCourant2 = new CompteCourant();
		CompteCourant compteCourant3 = new CompteCourant();

		compteCourant1.solde = 1242.71f;
		double soldeAnterieur = compteCourant1.solde;
		compteCourant1.debitAccount(12.0f);
		assertEquals((soldeAnterieur - 12.0f), compteCourant1.solde);
		
		compteCourant2.solde = 411.04f;
		soldeAnterieur = compteCourant2.solde;
		compteCourant2.debitAccount(15.0f);
		assertEquals((soldeAnterieur - 15.0f), compteCourant2.solde);

		compteCourant3.solde = 524825.21f;
		soldeAnterieur = compteCourant3.solde;
		compteCourant3.debitAccount(18.0f);
		assertEquals((soldeAnterieur - 18.0f), compteCourant3.solde);
	}

}
