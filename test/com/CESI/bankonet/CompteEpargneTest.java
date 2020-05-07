package com.CESI.bankonet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CompteEpargneTest {


	private static CompteEpargne compteEpargne1;
	private static CompteEpargne compteEpargne2;
	private static CompteEpargne compteEpargne3;

	@BeforeAll
	static void init() {
		compteEpargne1 = new CompteEpargne(-5.21);
		compteEpargne2 = new CompteEpargne(15.0);
		compteEpargne3 = new CompteEpargne(544.01);
	}
	
	@BeforeEach
	void decouvertNull() {
		compteEpargne1.setTauxInteret(0.0);
		compteEpargne2.setTauxInteret(0.0);
		compteEpargne3.setTauxInteret(0.0);
	}

	@Test
	public void testnbComptes() {
		assertEquals(3, CompteEpargne.getNbCompteEpargne(), 0);
	}

	@Test
	public void testCpt1() {
		compteEpargne1.setNom("Moi");
		compteEpargne1.setIntitule("Mon premier compte");
		compteEpargne1.setNumero("424 42854 254");
		compteEpargne1.setSolde(120.22);
		compteEpargne1.setTauxInteret(150.0);

		assertEquals("Moi", compteEpargne1.getNom());
		assertEquals("Mon premier compte", compteEpargne1.getIntitule());
		assertEquals("424 42854 254", compteEpargne1.getNumero());
		assertEquals(120.22, compteEpargne1.getSolde(), 0.01);
		assertEquals(150.0, compteEpargne1.getTauxInteret(), 0.01);
	}
		
	@Test
	void testCpt2() {
		compteEpargne2.setNom("Toi");
		compteEpargne2.setIntitule ("Ton premier compte");
		compteEpargne2.setNumero("549 241542 57");
		compteEpargne2.setSolde(20120.59);
		
		assertEquals("Toi", compteEpargne2.getNom());
		assertEquals("Ton premier compte", compteEpargne2.getIntitule());
		assertEquals("549 241542 57", compteEpargne2.getNumero());
		assertEquals(20120.59, compteEpargne2.getSolde(), 0.01);
		assertEquals(0.0, compteEpargne2.getTauxInteret(), 0.01);
	}

	@Test
	void testCpt3() {
		compteEpargne3.setNom("Quelqu\'un d\'autre");
		compteEpargne3.setIntitule("Ceci est aussi un compte");
		compteEpargne3.setNumero("24554 521524 1558");
		compteEpargne3.setSolde(-40.32);
		compteEpargne3.setTauxInteret(50.0);

		assertEquals("Quelqu\'un d\'autre", compteEpargne3.getNom());
		assertEquals("Ceci est aussi un compte", compteEpargne3.getIntitule());
		assertEquals("24554 521524 1558", compteEpargne3.getNumero());
		assertEquals(-40.32, compteEpargne3.getSolde());
		assertEquals(50.0, compteEpargne3.getTauxInteret(), 0.01);
	}

	@Test
	void testCreditValues() {
		compteEpargne1.setSolde(1212.70);
		compteEpargne1.creditAccount(2.0);
		assertEquals((1214.70), compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(411.04);
		compteEpargne2.creditAccount(5.0);
		assertEquals((416.04), compteEpargne2.getSolde(), 0.01);

		compteEpargne3.setSolde(524825.21);
		compteEpargne3.creditAccount(8.0);
		assertEquals((524833.21), compteEpargne3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitValues() {
		compteEpargne1.setSolde(1242.71);
		compteEpargne1.debitAccount(12.0);
		assertEquals(1230.71, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(411.04);
		compteEpargne2.debitAccount(15.0);
		assertEquals(396.04, compteEpargne2.getSolde(), 0.01);

		compteEpargne3.setSolde(524825.21);
		compteEpargne3.debitAccount(18.0);
		assertEquals(524807.21, compteEpargne3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitHigerValues() {
		compteEpargne1.setSolde(1242.71);
		compteEpargne1.debitAccount(52412.0);
		assertEquals(1242.71, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(411.00);
		compteEpargne2.setTauxInteret(150.0);
		compteEpargne2.debitAccount(415.0);
		assertEquals(-4.0, compteEpargne2.getSolde(), 0.01);

		compteEpargne2.setSolde(411.04);
		System.out.println(compteEpargne2.toString());
		compteEpargne2.debitAccount(415.0);
		System.out.println(compteEpargne2.toString());
		assertEquals(-3.96, compteEpargne2.getSolde(), 0.01);

		compteEpargne3.setSolde(4825.21);
		compteEpargne3.debitAccount(598718.0);
		assertEquals(4825.21, compteEpargne3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitNullValues() {
		compteEpargne1.setSolde(0.0);
		compteEpargne1.debitAccount(52.0);
		assertEquals(0.0, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(411.00);
		compteEpargne2.setTauxInteret(150.0);
		compteEpargne2.debitAccount(0.0);
		assertEquals(411.0, compteEpargne2.getSolde(), 0.01);
	}
	
	@Test
	void testDebitNegativeValues() {
		compteEpargne1.setSolde(-25.0);
		compteEpargne1.debitAccount(52.0);
		assertEquals(-25.0, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(411.00);
		compteEpargne2.debitAccount(-210.0);
		assertEquals(621.0, compteEpargne2.getSolde(), 0.01);
	}
	
	@Test
	void testCreditNegativeValues() {
		compteEpargne1.setSolde(-25.0);
		compteEpargne1.creditAccount(52.0);
		assertEquals(27.0, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(211.02);
		compteEpargne2.setTauxInteret(150.0);
		compteEpargne2.creditAccount(-310.0);
		
		compteEpargne3.setSolde(411.00);
		compteEpargne3.creditAccount(-210.0);
		assertEquals(201.0, compteEpargne3.getSolde(), 0.01);
	}
	
	@Test
	void testCreditNullValues() {
		compteEpargne1.setSolde(0.0);
		compteEpargne1.creditAccount(52.0);
		assertEquals(52.0, compteEpargne1.getSolde(), 0.01);
		
		compteEpargne2.setSolde(211.02);
		compteEpargne2.creditAccount(0.0);
		assertEquals(211.02, compteEpargne2.getSolde(), 0.01);
	}
	
	@Test
	void testToString(){
		System.out.println(compteEpargne1.toString());
	}

}
