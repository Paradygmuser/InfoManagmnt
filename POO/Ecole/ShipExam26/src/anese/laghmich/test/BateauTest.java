package anese.laghmich.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import anese.laghmich.Bateau;

class BateauTest {

	@Test
	void testSingleton() {
		Bateau bateau1 = Bateau.getInstance();
		Bateau bateau2 = Bateau.getInstance();
		
		assertSame(bateau1, bateau2);
		
	}

}
