//@author Daiane Tararam

package view;
import controller.Corredores;
public class CorredoresPrincipal {

	public static void main(String[] args) {
		Corredores p1 = new Corredores("Antonia");
		Corredores p2 = new Corredores("João");
		Corredores p3 = new Corredores("Maria");
		Corredores p4 = new Corredores("Renan");
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}
