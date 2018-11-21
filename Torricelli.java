import java.awt.*;
import java.awt.event.*;
/**
 * De wet van Torricelli is een wet uit de vloeistofdynamica, genoemd naar Evangelista Torricelli. 
 * Wanneer in een reservoir onder invloed van de zwaartekracht vloeistof uit een lager gelegen opening stroomt,
   dan is volgens deze wet de uitstroomsnelheid waarmee de vloeistof uit die opening stroomt, evenredig met de vierkantswortel uit het verval.
 * Ten slotte gaan we er vanuit dat de dichtheid van het fluïdum constant blijft, de stroming stationair is en de viscositeit gelijk is aan 0.  
 * 
 * @author Robbe Bloemen 
 * @version 28/10/2014
 */
public class Torricelli extends Frame
{
    // instance variables
    private Model m;
    private GroteView v;
    private Controller c;
    private AnimatorToevoer at;
    private Planeet planeet;
    private int debiet;
    private boolean kraan;
    private int diameter;
    /**
     * Constructor for objects of class Torricelli
     * 
     * @author Robbe Bloemen en Jarne Machiels
     * @version 28/10/2014
     */
    public Torricelli()
    {
        // initialise data members (if necessary)
        m = new Model();
        v = new GroteView(m);
        add(v);
        c = new Controller(m,v);
        at = new AnimatorToevoer(m,v);
        Thread t1 = new Thread(at);
        t1.start();
        // om het venster te kunnen sluiten
        this.addWindowListener( new WindowAdapter() {
            /**
             * sluit het scherm
             * 
             * @param e WindowEvent
             * @author Robbe Bloemen
             * @version 28/10/2014
             */
            public void windowClosing(WindowEvent e) {
               dispose();
               System.exit(0);
            }
        });
    }

    /**
     * In deze methode wordt het venster van de simulatie weergegeven.
     * 
     * @author Robbe Bloemen
     * @version 28/10/2014
     */
    public static void main() {
        Torricelli venster = new Torricelli();
        venster.setVisible(true);
        venster.setSize(1024, 768);
        venster.setTitle("Vat van Torricelli");
        
        Image icoonTorricelli = Toolkit.getDefaultToolkit().getImage("image/IcoonTorricelli.png");// vastleggen locatie icoon voor venster
        venster.setIconImage(icoonTorricelli);// Tekenen icoon voor programma
    }
}
