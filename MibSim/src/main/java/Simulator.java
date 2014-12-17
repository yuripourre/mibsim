import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import br.com.etyllica.util.PathHelper;
import br.com.mibsim.application.ConfigurationScreen;


public class Simulator extends EtyllicaFrame {

	private static final long serialVersionUID = 1L;

	public Simulator() {
		super(800, 600);
	}
	
	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.setUndecorated(true);
		simulator.init();
	}	

	@Override
	public Application startApplication() {

		String path = PathHelper.currentDirectory();
		
		System.out.println(path);
		setPath(path+"../");
		
		//return new AnotherSimulator(w, h);
		return new ConfigurationScreen(w, h);		
	}

}
