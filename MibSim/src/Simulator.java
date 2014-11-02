import application.MibSimApplication;
import application.OriginalApplication;
import br.com.etyllica.Etyllica;
import br.com.etyllica.context.Application;
import br.com.mibsim.application.AnotherSimulator;
import br.com.mibsim.editor.MibSimMapEditor;


public class Simulator extends Etyllica {

	private static final long serialVersionUID = 1L;

	public Simulator() {
		super(800, 600);
	}

	@Override
	public Application startApplication() {

		//return new OriginalApplication(w, h);
		//return new SmallAreaApplication(w, h);
		
		String path = Simulator.class.getResource("").toString();
		path+="../";
		setPath(path);
		
		return new AnotherSimulator(w, h);
		//return new MibSimMapEditor(w, h);
		
	}

}
