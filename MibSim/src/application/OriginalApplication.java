package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.mibsim.model.beign.creature.BlueCreature;
import br.com.mibsim.model.beign.creature.RedCreature;
import br.com.mibsim.model.beign.creature.YellowCreature;
import br.com.mibsim.model.fountain.AdamantiteFountain;
import br.com.mibsim.model.fountain.SugarFountain;
import br.com.mibsim.model.fountain.WaterFountain;
import br.com.mibsim.view.BeingDrawer;
import br.com.mibsim.view.FountainDrawer;

public class OriginalApplication extends MibSimApplication {

	public OriginalApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		super.load();
		
		generateRiver();
		generateFood();
		
		addAllFoutains(fountains);

		beings = new ArrayList<BeingDrawer>();
		beings.add(new BeingDrawer(new RedCreature(160, 60)));
		beings.add(new BeingDrawer(new RedCreature(190,70)));
		beings.add(new BeingDrawer(new YellowCreature(380,190)));
		beings.add(new BeingDrawer(new YellowCreature(350,220)));
		beings.add(new BeingDrawer(new YellowCreature(360,280)));
		beings.add(new BeingDrawer(new BlueCreature(170,90)));

		Random rand = new Random();

		for(BeingDrawer being: beings) {
			being.getBeing().getGeomap().add(fountains.get(rand.nextInt(fountains.size())).getFountain());
		}

		loading = 100;
	}
	
	private void addAllFoutains(List<FountainDrawer> fountains) {
		
		for(FountainDrawer drawer: fountains) {
			geoMap.add(drawer.getFountain());
		}
		
	}

	private void generateRiver() {

		fountains.add(new FountainDrawer(new WaterFountain(100,30)));
		fountains.add(new FountainDrawer(new WaterFountain(210,30)));
		fountains.add(new FountainDrawer(new WaterFountain(320,30)));
		fountains.add(new FountainDrawer(new WaterFountain(430,30)));
		fountains.add(new FountainDrawer(new WaterFountain(540,30)));
		fountains.add(new FountainDrawer(new WaterFountain(650,30)));
		fountains.add(new FountainDrawer(new WaterFountain(750,50)));

	}

	private void generateFood() {

		fountains.add(new FountainDrawer(new SugarFountain(120,90)));
		fountains.add(new FountainDrawer(new SugarFountain(250,90)));
		fountains.add(new FountainDrawer(new SugarFountain(380,90)));

		fountains.add(new FountainDrawer(new SugarFountain(120,300)));
		fountains.add(new FountainDrawer(new SugarFountain(250,200)));
		fountains.add(new FountainDrawer(new SugarFountain(390,500)));
		
		fountains.add(new FountainDrawer(new AdamantiteFountain(200,520)));
		fountains.add(new FountainDrawer(new AdamantiteFountain(250,490)));
		fountains.add(new FountainDrawer(new AdamantiteFountain(310,590)));

	}

}

