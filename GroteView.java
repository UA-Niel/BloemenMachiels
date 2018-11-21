import java.awt.*;
import java.awt.event.*;
// Om widgets toe te voegen hebben we de code van het spel 'Rush Hour' (Werkzitting Kris Aerts) grotendeels overgenomen. 
/**
 * Write a description of class GroteView here.
 * 
 * @author Robbe Bloemen & Jarne Machiels
 * @version 27/11/2014
 */
public class GroteView extends Panel
{
    // instance variables 
    private Model model;
    // Eigen data members
    private View kleineView;
    protected Widgets widgets;
    /**
     * Constructor for objects of class GroteView
     * 
     * @param model het model van de simulatie
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public GroteView(Model model)
    {
        // Initialise instance variables
        
        this.model = model;
        
        kleineView = new View(model);
        widgets = new Widgets(model);
        
        setLayout(new BorderLayout());
        add(widgets, BorderLayout.NORTH);
        add(kleineView, BorderLayout.CENTER);
    }
    
    //Getters
    
    /**
     * Wat is de x-coördinaat van de simulatie?
     * 
     * @param pixelX de pixel van de x-coördinaat
     * @return x-coördinaat van de simulatie
     * @author Robbe Bloemen
     * @version 27/11/2014
     */
    public int getCoordinaatX(int pixelX) {
       return kleineView.getCoordinaatX(pixelX); 
    }
    
    /**
     * Wat is de y-coördinaat van de simulatie?
     * 
     * @param pixelY de pixel van de x-coördinaat
     * @return y-coördinaat van de simulatie
     * @author Robbe Bloemen
     * @version 27/11/2014
     */
    public int getCoordinaatY(int pixelY) {
       return kleineView.getCoordinaatY(pixelY); 
    }
    
    //Setters
    
    /**
     * Deze methode zal de MouseListener toevoegen.
     * 
     * @param m MouseListener
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public void addMouseListener(MouseListener m) {
       kleineView.addMouseListener(m); 
    }
    
    /**
     * Deze methode zal de ActionListener toevoegen.
     * 
     * @param a ActionListener
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public void addActionListener(ActionListener a) {
       widgets.addActionListener(a); 
    }
    
    /**
     * Deze methode zal de kleine view en de widgets hertekenen.
     * 
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public void repaint() {
       kleineView.repaint();
       widgets.repaint();
    }
}
