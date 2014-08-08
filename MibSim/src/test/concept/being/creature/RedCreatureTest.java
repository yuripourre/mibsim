package test.concept.being.creature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.mibsim.model.beign.creature.RedCreature;
import br.com.mibsim.model.fountain.Nutrient;
import br.com.mibsim.model.fountain.SugarFountain;
import br.com.mibsim.model.fountain.WaterFountain;

public class RedCreatureTest {

	protected RedCreature being;
	
	@Before
	public void setUp() throws Exception {
		
		being = new RedCreature(22,33);
		
	}
	
	@Test
	public void testPosition() {
		
		assertEquals(22,being.getX());
		assertEquals(33,being.getY());

	}
	
	@Test
	public void testNeeds(){
		
		assertTrue(being.haveNeed(Nutrient.SUGAR));
		assertFalse(being.haveNeed(Nutrient.WATER));
		
	}

	@Test
	public void testReaction(){
		
		int beingX = being.getX();
		int beingY = being.getY();
		
		being.getGeomap().add(new SugarFountain(beingX-2, beingY+3));
		being.react();
		
		assertTrue(being.getX()<beingX);
		assertTrue(being.getY()>beingX);
		
	}
	
}
