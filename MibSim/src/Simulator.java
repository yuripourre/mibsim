import application.MibSimApplication;
import br.com.etyllica.Etyllica;
import br.com.etyllica.context.Application;


public class Simulator extends Etyllica {

	private static final long serialVersionUID = 1L;

	public Simulator() {
		super(800, 600);
	}

	@Override
	public Application startApplication() {

		return new MibSimApplication(w, h);
		
	}

}
