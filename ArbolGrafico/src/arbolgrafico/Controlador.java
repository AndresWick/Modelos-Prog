package arbolgrafico;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Carlos_Aguirre.
 */
public class Controlador {
    Arbol miArbol = new Arbol();

    public Controlador() {
    }

    public void insertar(Integer dato) {
       this.miArbol.insertar(dato);
    }
    
    public void resetArbol(Arbol miArbol){
        this.miArbol = miArbol;
    }

    public JPanel getDibujo() {
        return new Dibujo(miArbol);
    }
}
