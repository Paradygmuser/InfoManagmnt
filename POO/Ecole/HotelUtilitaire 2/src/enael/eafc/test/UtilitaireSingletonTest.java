package enael.eafc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import enael.eafc.UtilitaireSingleton;

class UtilitaireSingletonTest {

	@Test
	void SingleTone() {
		UtilitaireSingleton s1 = UtilitaireSingleton.getInstance();
		UtilitaireSingleton s2 = UtilitaireSingleton.getInstance();
		
		assertSame(s1,s2);
	}

}
