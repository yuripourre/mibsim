package test.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mibsim.model.fountain.Fountain;
import br.com.mibsim.model.fountain.SugarFountain;
import br.com.mibsim.model.fountain.WaterFountain;
import br.com.mibsim.model.map.GeoMap;

public class GeomapTest {
	
	private GeoMap map;

	@Before
	public void setUp() throws Exception {
		
		map = new GeoMap();		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGeoMapEmpty() {
		List<Fountain> found = map.get(20, 30);
		
		assertEquals(0, found.size());
	}
	
	@Test
	public void testGeoMapInsert() {
		
		WaterFountain waterFontain = new WaterFountain(20, 30);
		SugarFountain foodFontain = new SugarFountain(20, 30);
		SugarFountain anotherFoodFontain = new SugarFountain(21, 30);
		
		map.add(waterFontain);
		map.add(foodFontain);
		map.add(anotherFoodFontain);
		
		List<Fountain> found = map.get(20, 30);
		
		assertEquals(2, found.size());
		assertTrue(found.contains(waterFontain));
		assertTrue(found.contains(foodFontain));
		
		assertFalse(found.contains(anotherFoodFontain));
		
	}

}
