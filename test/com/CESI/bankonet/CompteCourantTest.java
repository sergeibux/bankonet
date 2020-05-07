package com.CESI.bankonet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CompteCourantTest {


	private static CompteCourant compteCourant1;
	private static CompteCourant compteCourant2;
	private static CompteCourant compteCourant3;

	@BeforeAll
	static void init() {
		compteCourant1 = new CompteCourant(-5.21);
		compteCourant2 = new CompteCourant(15.0);
		compteCourant3 = new CompteCourant(544.01);
	}
	
	@BeforeEach
	void decouvertNull() {
		compteCourant1.setMontantDecouvertAutorise(0.0);
		compteCourant2.setMontantDecouvertAutorise(0.0);
		compteCourant3.setMontantDecouvertAutorise(0.0);
	}

	@Test
	public void testnbComptes() {
		assertEquals(3, CompteCourant.getNbCompteCourant(), 0);
	}

	@Test
	public void testCpt1() {
		compteCourant1.setNom("Moi");
		compteCourant1.setIntitule("Mon premier compte");
		compteCourant1.setNumero("424 42854 254");
		compteCourant1.setSolde(120.22);
		compteCourant1.setMontantDecouvertAutorise(150.0);

		assertEquals("Moi", compteCourant1.getNom());
		assertEquals("Mon premier compte", compteCourant1.getIntitule());
		assertEquals("424 42854 254", compteCourant1.getNumero());
		assertEquals(120.22, compteCourant1.getSolde(), 0.01);
		assertEquals(150.0, compteCourant1.getMontantDecouvertAutorise(), 0.01);
	}
		
	@Test
	void testCpt2() {
		compteCourant2.setNom("Toi");
		compteCourant2.setIntitule ("Ton premier compte");
		compteCourant2.setNumero("549 241542 57");
		compteCourant2.setSolde(20120.59);
		
		assertEquals("Toi", compteCourant2.getNom());
		assertEquals("Ton premier compte", compteCourant2.getIntitule());
		assertEquals("549 241542 57", compteCourant2.getNumero());
		assertEquals(20120.59, compteCourant2.getSolde(), 0.01);
		assertEquals(0.0, compteCourant2.getMontantDecouvertAutorise(), 0.01);
	}

	@Test
	void testCpt3() {
		compteCourant3.setNom("Quelqu\'un d\'autre");
		compteCourant3.setIntitule("Ceci est aussi un compte");
		compteCourant3.setNumero("24554 521524 1558");
		compteCourant3.setSolde(-40.32);
		compteCourant3.setMontantDecouvertAutorise(50.0);

		assertEquals("Quelqu\'un d\'autre", compteCourant3.getNom());
		assertEquals("Ceci est aussi un compte", compteCourant3.getIntitule());
		assertEquals("24554 521524 1558", compteCourant3.getNumero());
		assertEquals(-40.32, compteCourant3.getSolde());
		assertEquals(50.0, compteCourant3.getMontantDecouvertAutorise(), 0.01);
	}

	@Test
	void testCreditValues() {
		compteCourant1.setSolde(1212.70);
		compteCourant1.creditAccount(2.0);
		assertEquals((1214.70), compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(411.04);
		compteCourant2.creditAccount(5.0);
		assertEquals((416.04), compteCourant2.getSolde(), 0.01);

		compteCourant3.setSolde(524825.21);
		compteCourant3.creditAccount(8.0);
		assertEquals((524833.21), compteCourant3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitValues() {
		compteCourant1.setSolde(1242.71);
		compteCourant1.debitAccount(12.0);
		assertEquals(1230.71, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(411.04);
		compteCourant2.debitAccount(15.0);
		assertEquals(396.04, compteCourant2.getSolde(), 0.01);

		compteCourant3.setSolde(524825.21);
		compteCourant3.debitAccount(18.0);
		assertEquals(524807.21, compteCourant3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitHigerValues() {
		compteCourant1.setSolde(1242.71);
		compteCourant1.debitAccount(52412.0);
		assertEquals(1242.71, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(411.00);
		compteCourant2.setMontantDecouvertAutorise(150.0);
		compteCourant2.debitAccount(415.0);
		assertEquals(-4.0, compteCourant2.getSolde(), 0.01);

		compteCourant2.setSolde(411.04);
		System.out.println(compteCourant2.toString());
		compteCourant2.debitAccount(415.0);
		System.out.println(compteCourant2.toString());
		assertEquals(-3.96, compteCourant2.getSolde(), 0.01);

		compteCourant3.setSolde(4825.21);
		compteCourant3.debitAccount(598718.0);
		assertEquals(4825.21, compteCourant3.getSolde(), 0.01);
	}
	
	@Test
	void testDebitNullValues() {
		compteCourant1.setSolde(0.0);
		compteCourant1.debitAccount(52.0);
		assertEquals(0.0, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(411.00);
		compteCourant2.setMontantDecouvertAutorise(150.0);
		compteCourant2.debitAccount(0.0);
		assertEquals(411.0, compteCourant2.getSolde(), 0.01);
	}
	
	@Test
	void testDebitNegativeValues() {
		compteCourant1.setSolde(-25.0);
		compteCourant1.debitAccount(52.0);
		assertEquals(-25.0, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(411.00);
		compteCourant2.debitAccount(-210.0);
		assertEquals(621.0, compteCourant2.getSolde(), 0.01);
	}
	
	@Test
	void testCreditNegativeValues() {
		compteCourant1.setSolde(-25.0);
		compteCourant1.creditAccount(52.0);
		assertEquals(27.0, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(211.02);
		compteCourant2.setMontantDecouvertAutorise(150.0);
		compteCourant2.creditAccount(-310.0);
		
		compteCourant3.setSolde(411.00);
		compteCourant3.creditAccount(-210.0);
		assertEquals(201.0, compteCourant3.getSolde(), 0.01);
	}
	
	@Test
	void testCreditNullValues() {
		compteCourant1.setSolde(0.0);
		compteCourant1.creditAccount(52.0);
		assertEquals(52.0, compteCourant1.getSolde(), 0.01);
		
		compteCourant2.setSolde(211.02);
		compteCourant2.creditAccount(0.0);
		assertEquals(211.02, compteCourant2.getSolde(), 0.01);
	}
	
	@Test
	void testToString(){
		System.out.println(compteCourant1.toString());
	}

}
