import java.awt.*;
import java.util.*;
import java.awt.image.*; // Bij het importeren van afbeeldingen in de simulatie hebben we hulp gehad van Wim Braekers. (Masterstudent EM)
import javax.swing.*; // ImageIcon
/**
 * In deze klasse View wordt het visuele uitzicht van de simulatie beschreven.
 * Zo zullen enerzijds de achtergronden geprogrammeerd worden, en anderzijds de tekening van de simulatie (het vat, kraan ...) zelf.
 * Daarnaast zal de stroming van het fluïdum ook in deze klasse getekend worden.
 * 
 * @author Robbe Bloemen en Jarne Machiels
 * @version 10/11/2014
 */
public class View extends Canvas
{
    private Model m;
    //Bufferen
    private Image buffer;
    // De achtergronden
    private Image achtergrondMars; //http://en.wikipedia.org/wiki/File:Rocky_Mars_Surface.jpeg
    private Image achtergrondGras; //http://www.libdesigner.com/2012/03/26/25-awesome-grass-textures-for-your-nature-projects/
    private Image achtergrondMaan; //http://www.messagetoeagle.com/openinglunarsurface.php
    
    //Op schaal tekenen:
    private int breedte = 1024;
    private int hoogte = 768; // dit zou eigenlijk met een getter van het model moeten gebeuren, maar dan krijg ik steeds nullpointerException
    /**
     * Constructor for objects of class View
     * 
     * @param m het model van de simulatie
     * @author Robbe Bloemen
     * @version 09/11/2014
     */
    public View(Model m)
    {
        // initialise instance variables
        this.m = m;
        achtergrondMars = new ImageIcon("image/achtergrondMars.jpg").getImage();
        achtergrondGras = new ImageIcon("image/achtergrondGras.jpg").getImage();
        achtergrondMaan = new ImageIcon("image/achtergrondMaan.jpg").getImage();
    }

    /**
     * Deze teken-methode zal er voor zorgen dat er geen flikkeringen op het scherm voorkomen.
     * 
     * @param g de graphics van de simulate
     * @author Jarne Machiels
     * @version 20/11/2014
     */
    public void teken(Graphics g) {
       if (buffer == null 
            || buffer.getWidth(this) != getWidth()
            || buffer.getHeight(this) != getHeight()) {
         buffer = createImage(getWidth(),getHeight());
       }
       paint(buffer.getGraphics());
       g.drawImage(buffer, 0, 0, this);
    }
    
    /**
     * Deze update-methode zal enkel nog de methode teken() uitvoeren.
     * 
     * @param g de graphics van de simulatie
     * @author Jarne Machiels
     * @version 20/11/2014
     */
    public void update(Graphics g) {
        teken(g);
    }
    
    /**
     * In deze methode wordt de visualisatie van de simulatie beschreven. 
     * Zo zal ook de keuzen tussen planeten, verhogen/verlagen van diameter en debiet weergegeven worden.
     * Verder zal ook de achtergrond getekend worden.
     * 
     * @param g de graphics van de simulatie
     * @author Robbe Bloemen en Jarne Machiels
     * @version 10/11/2014
     */
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(), getHeight());

        tekenAchtergrond(g);
        //Debietkraan + leiding + vat
        g.drawLine(getWidth()*m.getVatX()/breedte,getHeight()*(m.getVatY()-m.getVatHoogte())/hoogte,getWidth()*m.getVatX()/breedte,getHeight()*m.getVatY()/hoogte);
        g.drawLine(getWidth()*m.getVatX()/breedte,getHeight()*m.getVatY()/hoogte,getWidth()*540/breedte,getHeight()*m.getVatY()/hoogte);
        g.drawLine(getWidth()*500/breedte,getHeight()*150/hoogte,getWidth()*500/breedte,getHeight()*(m.getVatY()-m.getDiameter())/hoogte);
        g.drawLine(getWidth()*500/breedte,getHeight()*(m.getVatY()-m.getDiameter())/hoogte,getWidth()*540/breedte,getHeight()*(m.getVatY()-m.getDiameter())/hoogte);
        g.drawLine(getWidth()*390/breedte,getHeight()*140/hoogte,getWidth()*390/breedte,getHeight()*90/hoogte);
        g.drawLine(getWidth()*410/breedte,getHeight()*140/hoogte,getWidth()*410/breedte,getHeight()*70/hoogte);
        g.drawLine(getWidth()*410/breedte,getHeight()*70/hoogte,getWidth()*200/breedte,getHeight()*70/hoogte);
        g.drawLine(getWidth()*390/breedte,getHeight()*90/hoogte,getWidth()*200/breedte,getHeight()*90/hoogte);
        g.drawLine(getWidth()*200/breedte,getHeight()*70/hoogte,getWidth()*200/breedte,getHeight()*50/hoogte);
        g.drawLine(getWidth()*200/breedte,getHeight()*90/hoogte,getWidth()*200/breedte,getHeight()*110/hoogte);
        g.drawLine(getWidth()*200/breedte,getHeight()*50/hoogte,getWidth()*50/breedte,getHeight()*50/hoogte);
        g.drawLine(getWidth()*200/breedte,getHeight()*110/hoogte,getWidth()*50/breedte,getHeight()*110/hoogte);
        g.drawLine(getWidth()*50/breedte,getHeight()*50/hoogte,getWidth()*50/breedte,getHeight()*110/hoogte);
        g.drawLine(getWidth()*90/breedte,getHeight()*50/hoogte,getWidth()*90/breedte,getHeight()*110/hoogte);
        g.drawLine(getWidth()*50/breedte,getHeight()*80/hoogte,getWidth()*90/breedte,getHeight()*80/hoogte);
        
        if(m.getDebiet() == 0){
            g.drawLine(getWidth()*390/breedte,getHeight()*140/hoogte,getWidth()*410/breedte,getHeight()*140/hoogte);
        }
        else {
            g.setColor(Color.BLUE);
            g.fillRect(getWidth()*(400-m.getDebiet()/10)/breedte,getHeight()*140/hoogte,getWidth()*(2*m.getDebiet()/10)/breedte,getHeight()*(m.getToevoerstroomY()-4)/hoogte);
            g.setColor(Color.BLACK);
            g.drawLine(getWidth()*390/breedte,getHeight()*140/hoogte,getWidth()*(390+(10-m.getDebiet()/10))/breedte,getHeight()*140/hoogte);
            g.drawLine(getWidth()*410/breedte,getHeight()*140/hoogte,getWidth()*(410-(10-m.getDebiet()/10))/breedte,getHeight()*140/hoogte);
        }
        
        //Vul toevoerleiding met water
        g.setColor(Color.BLUE);
        g.fillRect(getWidth()*200/breedte,getHeight()*70/hoogte,getWidth()*210/breedte,getHeight()*20/hoogte);
        g.fillRect(getWidth()*390/breedte,getHeight()*90/hoogte,getWidth()*20/breedte,getHeight()*50/hoogte);
        g.setColor(Color.BLACK);
        
        //Kaders voor toestand afvoerkraan
        g.drawRect(getWidth()*370/breedte,getHeight()*430/hoogte,getWidth()*130/breedte,getHeight()*30/hoogte);
        g.drawRect(getWidth()*370/breedte,getHeight()*460/hoogte,getWidth()*130/breedte,getHeight()*30/hoogte);
        g.drawString("Open",getWidth()*422/breedte,getHeight()*452/hoogte);
        g.drawString("Toe", getWidth()*427/breedte, getHeight()*482/hoogte);
        
        if(m.getKraan() == true){
            g.setColor(Color.RED);
            g.drawRect(getWidth()*370/breedte,getHeight()*430/hoogte,getWidth()*130/breedte,getHeight()*30/hoogte);
            g.drawString("Open",getWidth()*422/breedte,getHeight()*452/hoogte);
        }
        else if(m.getKraan() == false){
            g.setColor(Color.RED);
            g.drawRect(getWidth()*370/breedte,getHeight()*460/hoogte,getWidth()*130/breedte,getHeight()*30/hoogte);
            g.drawString("Toe",getWidth()*427/breedte,getHeight()* 482/hoogte);
        }
        g.setColor(Color.BLACK);
        
        //Pijlen voor debiet en debiet zelf
        g.drawLine(getWidth()*70/breedte,getHeight()*55/hoogte,getWidth()*80/breedte,getHeight()*75/hoogte);
        g.drawLine(getWidth()*70/breedte,getHeight()*55/hoogte,getWidth()*60/breedte,getHeight()*75/hoogte);
        g.drawLine(getWidth()*60/breedte,getHeight()*75/hoogte,getWidth()*80/breedte,getHeight()*75/hoogte);
        g.drawLine(getWidth()*60/breedte,getHeight()*85/hoogte,getWidth()*80/breedte,getHeight()*85/hoogte);
        g.drawLine(getWidth()*80/breedte,getHeight()*85/hoogte,getWidth()*70/breedte,getHeight()*105/hoogte);
        g.drawLine(getWidth()*60/breedte,getHeight()*85/hoogte,getWidth()*70/breedte,getHeight()*105/hoogte);
        g.drawString("Debiet (Liter/min)" ,getWidth()*100/breedte,getHeight()*40/hoogte);
        g.drawString(" " + m.getDebiet(),getWidth()*140/breedte,getHeight()*80/hoogte);
        
        //Kader + pijlen voor diameter en diameter zelf
        g.drawRect(getWidth()*600/breedte,getHeight()*225/hoogte,getWidth()*130/breedte,getHeight()*60/hoogte);
        g.drawLine(getWidth()*640/breedte,getHeight()*225/hoogte,getWidth()*640/breedte,getHeight()*285/hoogte);
        g.drawLine(getWidth()*620/breedte,getHeight()*230/hoogte,getWidth()*630/breedte,getHeight()*250/hoogte);
        g.drawLine(getWidth()*630/breedte,getHeight()*250/hoogte,getWidth()*610/breedte,getHeight()*250/hoogte);
        g.drawLine(getWidth()*610/breedte,getHeight()*250/hoogte,getWidth()*620/breedte,getHeight()*230/hoogte);
        g.drawLine(getWidth()*610/breedte,getHeight()*260/hoogte,getWidth()*630/breedte,getHeight()*260/hoogte);
        g.drawLine(getWidth()*630/breedte,getHeight()*260/hoogte,getWidth()*620/breedte,getHeight()*280/hoogte);
        g.drawLine(getWidth()*620/breedte,getHeight()*280/hoogte,getWidth()*610/breedte,getHeight()*260/hoogte);
        g.drawLine(getWidth()*600/breedte,getHeight()*255/hoogte,getWidth()*640/breedte,getHeight()*255/hoogte);
        g.drawString("Diameter (mm)",getWidth()*645/breedte,getHeight()*215/hoogte);
        g.drawString(" "+ m.getDiameter(),getWidth()*680/breedte,getHeight()*255/hoogte);

        //grond
        g.drawLine(0,(int)(getHeight()*650/hoogte),getWidth(),(int)(getHeight()*650/hoogte));
        for(int i=0; i<getWidth()/15; i++){
            g.drawLine(15*i,(int)(getHeight()*(650+30)/hoogte),(15+15*i),(int)(getHeight()*650/hoogte));
        }
        // pijl voor x-waarde + vakje met x-waarde
        if(m.getDiameter() >0 && m.getHoogteFluidum() > 0){
            //pijl
            g.setColor(Color.RED);
            g.drawLine(getWidth()*540/breedte,getHeight()*700/hoogte,getWidth()*(540+m.getUitstroomX())/breedte,getHeight()*700/hoogte);
            g.drawLine(getWidth()*540/breedte,getHeight()*700/hoogte,getWidth()*550/breedte,getHeight()*710/hoogte);
            g.drawLine(getWidth()*540/breedte,getHeight()*700/hoogte,getWidth()*550/breedte,getHeight()*690/hoogte);
            g.drawLine(getWidth()*(540+m.getUitstroomX())/breedte,getHeight()*700/hoogte,getWidth()*(540+m.getUitstroomX()-10)/breedte,getHeight()*710/hoogte);
            g.drawLine(getWidth()*(540+m.getUitstroomX())/breedte,getHeight()*700/hoogte,getWidth()*(540+m.getUitstroomX()-10)/breedte,getHeight()*690/hoogte);
            //vakje
            g.drawString("Breedte = " + m.getUitstroomX() + " mm", getWidth()*(540+m.getUitstroomX()/3)/breedte,getHeight()*750/hoogte); 
            g.setColor(Color.BLACK);
        }
        // pijl met hoogte
        g.drawLine(getWidth()*900/breedte,getHeight()*400/hoogte,getWidth()*900/breedte,getHeight()*650/hoogte);
        g.drawLine(getWidth()*890/breedte,getHeight()*410/hoogte,getWidth()*900/breedte,getHeight()*400/hoogte);
        g.drawLine(getWidth()*910/breedte,getHeight()*410/hoogte,getWidth()*900/breedte,getHeight()*400/hoogte);
        g.drawLine(getWidth()*890/breedte,getHeight()*640/hoogte,getWidth()*900/breedte,getHeight()*650/hoogte);
        g.drawLine(getWidth()*910/breedte,getHeight()*640/hoogte,getWidth()*900/breedte,getHeight()*650/hoogte);
        g.drawString("Hoogte = 250 mm",getWidth()*905/breedte,getHeight()*525/hoogte);

        // Het vullen van het vat
        g.setColor(Color.BLUE);
        g.fillRect(getWidth()*m.getVatX()/breedte,(int)(getHeight()*(m.getVatY()-m.getHoogteFluidum())/hoogte), getWidth()*m.getVatBreedte()/breedte,(int) (getHeight()*m.getHoogteFluidum()/hoogte));
        
        // het vat laten leeglopen
        if(m.getHoogteFluidum() > 0){
           for(int i=0; i<m.getDiameter(); i++){
               g.drawArc(getWidth()*(540-m.getUitstroomX())/breedte, getHeight()*(400-i)/hoogte, getWidth()*(2*m.getUitstroomX())/breedte, getHeight()*500/hoogte, 0,90);
               g.fillRect(getWidth()*500/breedte, getHeight()*(m.getVatY()+1-m.getDiameter())/hoogte, getWidth()*40/breedte,getHeight()*m.getDiameter()/hoogte);
           }
        }
    }
    
    /**
     * Deze methode zal in staat zijn om de achtergrond van de simulatie (aarde, mars of maan) te visualiseren.
     * 
     * @param g de graphics van de simulatie 
     */
    private void tekenAchtergrond(Graphics g){
        if(m.getPlaneet() == Planeet.MARS){
            g.drawImage(achtergrondMars,0,0,getWidth(),getHeight(),null);// achtergrond beginnen te tekenen in oorsprong
        }
        if(m.getPlaneet() == Planeet.AARDE){
            g.drawImage(achtergrondGras,0,0,getWidth(),getHeight(),null);// achtergrond beginnen te tekenen in oorsprong
        }
        if(m.getPlaneet() == Planeet.MAAN){
            g.drawImage(achtergrondMaan,0,0,getWidth(),getHeight(),null);// achtergrond beginnen te tekenen in oorsprong
        }
    }
    
    /** Welke x-coördinaat komt overeen met de x-coördinaat op het scherm? 
     * 
     * @param schermX de x-coördinaat op het scherm
     * @return x-coördinaat
     * 
     * @author Jarne Machiels
     * @version 26/11/2014
     */
    public int getCoordinaatX(int schermX) {
       return schermX;    
    }
    
     /** Welke y-coördinaat komt overeen met de y-coördinaat op het scherm? 
     * 
     * @param schermY de y-coördinaat op het scherm
     * @return y-coördinaat
     * @author Jarne Machiels
     * @version 26/11/2014
     */
    public int getCoordinaatY(int schermY) {
       return schermY;    
    }
}
