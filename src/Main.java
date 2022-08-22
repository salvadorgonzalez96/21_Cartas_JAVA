import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    Escenario es;
    
    public Main(){
        super("Juego de Cartas - 31");
        es=new Escenario();
        setSize(900,700);
        add(es);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main (String args[]){
        Main al=new Main();
    }
}