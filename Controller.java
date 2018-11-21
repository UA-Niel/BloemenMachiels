import java.awt.event.*;
/**
 * In deze klasse Controller wordt de bediening van de simulatie beschreven.
 * Zo zal je het debiet en de diameter kunnen verhogen/verlagen door op de pijlpunten in de desbetreffende vakken te klikken.
 * Verder kan men ook de planeten veranderen door in het desbetreffende kader te klikken.
 * 
 * @author Robbe Bloemen en Jarne Machiels 
 * @version 10/11/2014
 */
public class Controller implements MouseListener, ActionListener
{
    // instance variables 
    private Model m;
    private GroteView v;
    private int hoogte= 768;
    private int breedte= 1024;
    /**
     * Constructor for objects of class Controller
     * 
     * @param m het model van de simulatie
     * @param v de groteview van de simulatie
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public Controller(Model m, GroteView v)
    {
        // initialise instance variables
        this.m = m;
        this.v = v;
        v.addMouseListener(this);
        v.addActionListener(this);
    }
    
    /**
     * Wanneer je klikt op de pijlen van het debiet/diameter, verhoog/verlaag je het debiet/diameter.
     * 
     * @param  e Mousevent
     * @author Robbe Bloemen en Jarne Machiels
     * @version 10/11/2014
     */
    public void mouseClicked(MouseEvent e){
        //Debiet aanpassen
        //System.out.println(e.getX() + "-" + e.getY());
        if(e.getX() >= v.getWidth()*50/breedte && e.getX() <= v.getWidth()*90/breedte && e.getY() >= v.getHeight()*50/hoogte && e.getY() <= v.getHeight()*80/hoogte){
            m.setVerhoogDebiet();
            v.repaint();
        }
        if(e.getX() >= v.getWidth()*50/breedte && e.getX() <= v.getWidth()*90/breedte && e.getY() >= v.getHeight()*80/hoogte && e.getY() <= v.getHeight()*110/hoogte){
            m.setVerlaagDebiet();
            v.repaint();
        }
        //Diameter aanpassen
        //System.out.println("Debiet = "+m.getDebiet());
         if(e.getX() >= v.getWidth()*600/breedte && e.getX() <= v.getWidth()*640/breedte && e.getY() >= v.getHeight()*210/hoogte && e.getY() <= v.getHeight()*240/hoogte){
            m.setVerhoogDiameter();
            v.repaint();
        }
        if(e.getX() >= v.getWidth()*600/breedte && e.getX() <= v.getWidth()*640/breedte && e.getY() >= v.getHeight()*240/hoogte && e.getY() <= v.getHeight()*270/hoogte){
            m.setVerlaagDiameter();
            v.repaint();
        }
        //System.out.println("Diameter = "+m.getDiameter());
        //Toestand kraan aanpassen
        if(e.getX() >= v.getWidth()*410/breedte && e.getX() <= v.getWidth()*540/breedte && e.getY() >= v.getHeight()*430/hoogte && e.getY() <= v.getHeight()*460/hoogte) {
            m.setOpenKraan();
            v.repaint();
        }
        if(e.getX() >= v.getWidth()*410/breedte && e.getX() <= v.getWidth()*540/breedte && e.getY() >= v.getHeight()*460/hoogte && e.getY() <= v.getHeight()*490/hoogte) {
            m.setSluitKraan();
            v.repaint();
        }
        //System.out.println("Toestand kraan = "+m.getKraan());
    }
    
    /**
     * Wat gebeurt er als je op de muis klikt?
     * 
     * @param e MouseEvent
     * @author Jarne Machiels
     * @version 08/12/2014
     */
    public void mouseEntered(MouseEvent e){
    }
    
     /**
     * Wat gebeurt er als de muis het scherm verlaat?
     * 
     * @param e MouseEvent
     * @author Jarne Machiels
     * @version 08/12/2014
     */
    public void mouseExited(MouseEvent e){
    }
    
     /**
     * Wat gebeurt er als je de muis ingedrukt houdt?
     * 
     * @param e MouseEvent
     * @author Jarne Machiels
     * @version 08/12/2014
     */
    public void mousePressed(MouseEvent e){
    }
    
     /**
     * Wat gebeurt er als je op de muis geklikt hebt?
     * 
     * @param e MouseEvent
     * @author Jarne Machiels
     * @version 08/12/2014
     */
    public void mouseReleased(MouseEvent e){
    }
    
    /**
     * Deze methode zal de widgets van de simulatie laten werken.
     * 
     * @param e ActionEvent
     * @author Jarne Machiels
     * @version 27/11/2014
     */
    public void actionPerformed(ActionEvent e) { 
       if (e.getSource() == v.widgets.setPlaneetNaarAarde){
            m.setPlaneetNaarAarde();
            v.repaint();
       }
       if (e.getSource() == v.widgets.setPlaneetNaarMaan){
            m.setNaarPlaneetMaan();
            v.repaint();
       } 
       if (e.getSource() == v.widgets.setPlaneetNaarMars){
            m.setPlaneetNaarMars();
            v.repaint();
        }
    }
}
