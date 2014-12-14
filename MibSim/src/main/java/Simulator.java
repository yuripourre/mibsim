import br.com.etyllica.Etyllica;
import br.com.etyllica.context.Application;
import br.com.etyllica.util.PathHelper;
import br.com.mibsim.application.AnotherSimulator;
import br.com.mibsim.application.ConfigurationScreen;


public class Simulator extends Etyllica {

	private static final long serialVersionUID = 1L;

	public Simulator() {
		super(800, 600);
	}

	@Override
	public Application startApplication() {

		String path = PathHelper.currentDirectory();
		
		setPath(path+"../");
		
		//return new AnotherSimulator(w, h);
		return new ConfigurationScreen(w, h);
		
	}

}
