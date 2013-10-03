import application.MibSimApplication;
import br.com.etyllica.Etyllica;


public class Simulator extends Etyllica{

	private static final long serialVersionUID = 1L;

	public Simulator() {
		super(800, 600);
	}

	@Override
	public void startGame() {

		setMainApplication(new MibSimApplication(w, h));
		
	}

}
