package arbolAVL;
import javax.swing.JPanel;

/**
 *
 * @author Carlos_Aguirre.
 */
public class Controlador {
    ArbolAVL miArbol = new ArbolAVL();

    public Controlador() {
    }

    public void insertar(Integer dato) {
       this.miArbol.insertar(dato);
    }
    
    public void resetArbol(ArbolAVL miArbol){
        this.miArbol = miArbol;
    }

    public JPanel getDibujo() {
        return new Dibujo(miArbol);
    }
}
