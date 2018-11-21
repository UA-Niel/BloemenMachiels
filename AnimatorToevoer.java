// inspiratie : cursus GAJA
/**
 * Deze klasse zorgt ervoor dat het fluïdum in het vat + de uitstroming van het fluïdum beweegt.
 * beweegt.
 * 
 * @author Jarne Machiels
 * @version 17/11/2014
 */
public class AnimatorToevoer implements Runnable
{
    // data members (instance variables)
    private Model m;
    private GroteView v;
    /**
     * Constructor for objects of class AnimatorToevoer
     * 
     * @param model het model van de simulatie
     * @param view de view van de simulatie (uitstroming + stroming vat)
     * 
     * @author Jarne Machiels
     * @version 17/11/2014
     */
    public AnimatorToevoer(Model m, GroteView v)
    {
        this.m = m;
        this.v = v;
    }

    /**
     * Deze methode zorgt ervoor dat het fluïdum in het vat ofwel naar boven, ofwel naar beneden beweegt.
     * 
     * @author Jarne Machiels
     * @version 17/11/2014
     */
    public void run() {
       while (true) {
        try {
          Thread.sleep(50);
          m.tickToevoer();
          v.repaint();
        }
        catch (InterruptedException e) {}
        v.repaint();
       }
       
    }

}

