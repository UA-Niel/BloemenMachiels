import java.awt.*;
import java.awt.event.*;
// Om widgets toe te voegen hebben we de code van het spel 'Rush Hour' (Werkzitting Kris Aerts) grotendeels overgenomen. 
/**
 * In deze klasse Widgets worden widgets toegevoegd aan de simulatie.
 * 
 * @author Robbe Bloemen & Jarne Machiels
 * @version 27/11/2014
 */
public class Widgets extends Panel
{
    // instance variables 
    private Model model;
    protected Button setPlaneetNaarAarde;
    protected Button setPlaneetNaarMaan;
    protected Button setPlaneetNaarMars;
    /**
     * Constructor for objects of class Widgets
     * 
     * @param model het model van de simulatie
     * @author Robbe Bloemen & Jarne Machiels
     * @version 27/11/2014
     */
    public Widgets(Model model)
    {
        // initialise instance variables
        this.model = model;
        //Aarde
        setPlaneetNaarAarde = new Button("Aarde");
        setPlaneetNaarAarde.setBounds(130,100,300,150);
        add(setPlaneetNaarAarde);
        
        //Maan
        setPlaneetNaarMaan = new Button("Maan");
        setPlaneetNaarMaan.setBounds(130,100,300,150);
        add(setPlaneetNaarMaan);
        
        //Mars
        setPlaneetNaarMars = new Button("Mars");
        setPlaneetNaarMars.setBounds(130,100,300,150);
        add(setPlaneetNaarMars);
    }
    
    /**
     * Voeg een ActionListener toe aan de simulatie
     * 
     * @param a ActionListener
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public void addActionListener(ActionListener a) {
       setPlaneetNaarAarde.addActionListener(a); 
       setPlaneetNaarMaan.addActionListener(a); 
       setPlaneetNaarMars.addActionListener(a); 
    }
}
