import java.awt.*;
import java.util.*;
/**
 * In deze klasse Model worden allerhande variabelen beschreven, die noodzakelijk zijn voor de simulatie van de Wet van Torricelli. 
 * Daarnaast zullen er ook verschillende getters gemaakt worden om de waarden van deze variabelen op te vragen.
 * Ten slotte zijn er ook meerdere setters, zodat de waarden van de variabelen veranderd kunnen worden.
 * 
 * @author Robbe Bloemen en Jarne Machiels
 * @version 10/11/2014
 */
public class Model
{
    // instance variables
    private Planeet planeet;
    private int debiet;
    private boolean kraan;
    private int diameter;
    private int volumeIn;
    private int volumeUit;
    private int volumeVat;
    private int hoogteFluidum; 
    private double valversnelling;
    private int vatX, vatY;
    private int vatBreedte;
    private int vatHoogte;
    private int uitstroomX;
    private int toevoerkraanHoogte;
    private int toevoerstroomY;
    
    /**
     * Constructor for objects of class Model
     * 
     * @param planeet de planeet waar het vat zich bevindt
     * @param debiet het debiet van de kraan
     * @param kraan de toestand van de kraan
     * @param diameter de diameter van de afvoer (in mm)
     * 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public Model()
    {
        this.planeet = planeet.AARDE;
        this.debiet = debiet;
        kraan = true;
        this.diameter = diameter;
        
        vatX = 300;
        vatY = 400;
        
        //Breedte en hoogte van het vat
        vatBreedte = 200;
        vatHoogte = 250;
 
        //hoogtes van de toe-en afvoerkraan
        toevoerkraanHoogte = 130;
        toevoerstroomY = 0;
    }
    //Getters
    /**
     * Wat is de x-coordinaat van de linkeronderhoek van het vat?
     * 
     * @return de x-coordinaat van de linkeronderhoek van het vat
     * @author Jarne Machiels
     * @version 18/11/2014
     */
    public int getVatX() {
        return vatX;
    }
    
    /**
     * Wat is de y-coordinaat van de linkeronderhoek van het vat?
     * 
     * @return de y-coordinaat van de linkeronderhoek van het vat
     * @author Jarne Machiels
     * @version 18/11/2014
     */
    public int getVatY() {
        return vatY;
    }
    
    /**
     * Wat is de breedte van het vat?
     * 
     * @return de breedte van het vat
     * @author Robbe Bloemen
     * @version 18/11/2014
     */
    public int getVatBreedte() {
        return vatBreedte;
    }
    
     /**
     * Wat is de hoogte van het vat?
     * 
     * @return de hoogte van het vat
     * @author Robbe Bloemen
     * @version 18/11/2014
     */
    public int getVatHoogte() {
        return vatHoogte;
    }

    /**
     * Wat is de valversnelling uitgedrukt in meter/seconde²?
     * 
     * @return valversnelling 
     * @author Robbe Bloemen
     * @version 28/10/2014
     */
    public double getValversnelling() {
        if(planeet == Planeet.AARDE){
           valversnelling = 9.81; 
        }
        if(planeet == Planeet.MARS){
           valversnelling = 3.74; 
        }
        if(planeet == Planeet.MAAN){
           valversnelling = 1.62; 
        }
        return valversnelling;
    }
    
    /**
     * Wat is het debiet van de toevoerkraan uitgdrukt in liter/minuut?
     * 
     * @return het debiet van de toevoerkraan 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public int getDebiet(){
        return debiet;
    }
    
    /**
     * Wat is de diameter van de afvoer onderaan het vat uitgedrukt in millimeter?
     * 
     * @return de diameter van het gat onderaan het vat
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public int getDiameter(){
        return diameter;
    }
    
    /**
     * Is de kraan onderaan het vat open of dicht?
     * 
     * @return de toestand van de kraan
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public boolean getKraan(){
        return kraan;
    }
    
    /**
     * Op welke planeet bevindt het vat zich?
     * 
     * @return de planeet waarop het vat zich bevindt
     * @author Robbe Bloemen
     * @version 09/11/2014
     */
    public Planeet getPlaneet(){
        if(planeet == Planeet.AARDE){
            planeet = Planeet.AARDE;
        }
        else if(planeet == Planeet.MARS){
            planeet = Planeet.MARS;
        }
        else if(planeet == Planeet.MAAN){
            planeet = Planeet.MAAN;
        }
        return planeet;
    }
 
    /**
     * Wat is de hoogte van het totale fluïdum dat zich in het vat bevindt?
     * 
     * @return de hoogte van het totale fluïdum dat zich in het vat bevindt
     * @author Jarne Machiels
     * @version 15/11/2014
     */
    public double getHoogteFluidum() {
        return hoogteFluidum; 
    }
    
    /**
     * Wat is de X-waarde van de uitstromende straal?
     * 
     * @return uitstroomX de x-waarde van de uitstromende straal
     * @author Robbe Bloemen
     * @version 27/11/2014
     */
    public int getUitstroomX(){
        return uitstroomX;
    }
    
    /**
     * Wat is de y-waarde van de toevoerstroom?
     * 
     * @return toevoerstroomY de y-waarde van de instromende straal
     * @author Robbe Bloemen
     * @version 27/11/2014
     */
    public int getToevoerstroomY(){
        return toevoerstroomY;
    }
    
    /**
     * Wat is het volume dat in het vat loopt?
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public int getVolumeIn(){
        return volumeIn;
    }
   
     /**
     * Wat is het volume dat uit het vat loopt?
     * 
     * @return volumeUit het uitgaande volume
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public int getVolumeUit(){
        return volumeUit;
    }
    
     /**
     * Wat is het volume dat in het vat zit?
     * 
     * @return volumeVat het totale volume aanwezig in het vat
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public int getVolumeVat(){
        return volumeVat;
    }
    
     /**
     * Wat is de hoogte van de toevoerkraan?
     * 
     * @return toevoerkraanHoogte de hoogte van de toevoerkraan
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public int getToevoerkraanHoogte(){
        return toevoerkraanHoogte;
    }
    
    //setters
    /**
     * Verhoog het debiet met 5 liter/minuut. Het maximale debiet is 200 l/min
     * 
     * @author Jarne Machiels
     * @version 25/11/2014
     */
    public void setVerhoogDebiet() {
        if(debiet <100) {
            debiet = debiet + 5;
        }
        else
        {
            debiet = debiet;
        }
    }
    
    /**
     * Verlaag het debiet met 5 liter/minuut. We weten ook dat een debiet niet negatief kan zijn.
     * 
     * @author Robbe Bloemen en Jarne Machiels
     * @version 25/11/2014
     */
    public void setVerlaagDebiet() {
        if(debiet == 0){
            debiet = debiet;
        }
        else
        {
            debiet = debiet - 5;
        }
    }
    
    /**
     * Draai de kraan onderaan de afvoer van het vat open.
     * 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public boolean setOpenKraan() {
        kraan = true;
        return kraan;
    }
    
    /**
     * Draai de kraan onderaan de afvoer van het vat dicht.
     * 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public boolean setSluitKraan() {
        kraan = false;
        return kraan;
    }
    
    /**
     * Verhoog de diameter van de afvoer onderaan het vat met 1 millimeter.
     * Verder kiezen we een maximale diameter van 10 millimeter.
     * 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public void setVerhoogDiameter(){
        if(diameter < 10) {
            diameter = diameter + 1;
        }
        else
        {
            diameter = diameter;
        }
    }
    
    /**
     * Verlaag de diameter van de afvoer onderaan het vat met 1 millimeter. We weten ook dat de diameter niet negatief kan zijn.
     * 
     * @author Jarne Machiels
     * @version 28/10/2014
     */
    public void setVerlaagDiameter(){
        if(diameter == 0){
            diameter = diameter;
        }
        else 
        {
            diameter = diameter - 1;
        }
    }
    
    /**
     * Kies planeet Aarde als omgeving
     * 
     * @author Robbe Bloemen
     * @version 09/11/2014
     */
    public void setPlaneetNaarAarde(){
        planeet = Planeet.AARDE;
    }
    
    /**
     * Kies de maan als omgeving
     * 
     * @author Robbe Bloemen
     * @version 09/11/2014
     */
    public void setNaarPlaneetMaan(){
        planeet = Planeet.MAAN;
    }
    
    /**
     * Kies planeet Mars als omgeving
     * 
     * @author Robbe Bloemen
     * @version 09/11/2014
     */
    public void setPlaneetNaarMars(){
        planeet = Planeet.MARS;
    }
   
    /**
     * In deze methode gaan we beschrijven dat een vat niet kan overlopen. 
     * Dus, zodra het fluidum dezelfde hoogte heeft als het vat zelf, zal het debiet automatisch op 0 liter/minuut gezet worden.
     * In de andere gevallen zal het debiet gewoon behouden blijven.
     * 
     * @author Jarne Machiels
     * @version 25/11/2014
     */
    public void setLaatVatNietOverlopen() {
        if(hoogteFluidum >= vatHoogte) {
            debiet = 0;
            hoogteFluidum = vatHoogte;
        }
        else {
            debiet = debiet;
        }
    }
    
    /**
     * Wat is de hoogte van het fluïdum dat zich in het vat bevindt? 
     * Dit gaan we berekenen door allereerst het ingaande fluidum te bepalen. Vervolgens tellen we hierbij het huidige volume fluïdum bij, maar trekken we ook
       het uitgaande volume fluïdum ervan af.
     * 
     * @author Robbe Bloemen
     * @version 25/11/2014
     */
    public void setBerekenHoogteFluidum() {
        volumeIn = (int) (debiet*1000/1200); // eenheid = ml/tick 
        if(volumeIn >= 0 && toevoerstroomY >= vatY - toevoerkraanHoogte - 14){
           volumeVat = volumeVat + volumeIn - volumeUit;
           
        }
        hoogteFluidum = (int) (volumeVat/(2*2*Math.PI/4));
    }
    
     /**
     * Wat is het volume van het fluïdum dat het vat verlaat?
     * 
     * @author Jarne Machiels
     * @version 25/11/2014
     */
    public void setVolumeUit() {
        if(kraan = true && diameter > 0) {
            //Om het uitgaande volume te berekenen, maken we gebruik van de wet van Torricelli*oppervlakte van de afvoer*tijdUit
            volumeUit = (int) (Math.sqrt(2*valversnelling*1000*hoogteFluidum)*((diameter*diameter*Math.PI)/4)/1200);
        }
        else {
            volumeUit = 0;
        }
    }
    
    /**
     * Berekent hoever de straal van het fluidum uitstroomt in horizontale richting
     * 
     * @author Robbe Bloemen
     * @version 27/11/2014
     */
    public void setUitstroomX(){
        //Sx(t) = vt
        //Sy(t) = -0.5*g*t^2  hieruit halen we de t die we in Sx(t) invullen
        uitstroomX = (int) (Math.sqrt(2*valversnelling*1000*hoogteFluidum)/(Math.sqrt(250/(0.5*valversnelling))));
    }
    
    /**
     * Bepaal de y-waarde van de onderkant van de toevoerstraal
     * 
     * @author Robbe Bloemen
     * #version 27/11/2014
     */
    public void setToevoerstroomY(){
        //begin van de kraan + valversnelling maal tijd
        // als de toevoerstroomY tussen de kraan en de onderkant van het vat is
        for (int i = 1; i <6;i++){
            if (toevoerstroomY <= (vatY - toevoerkraanHoogte - 16) && debiet > 0){
               toevoerstroomY =  toevoerstroomY + (int) (0.5*valversnelling*1000/1200*i);
            }
        }
    }
    
    /**
     * Kies de valversnelling van de simulatie
     *  
     * @author Robbe Bloemen
     * @version 25/11/2014
     */
    public void setValversnelling() {
        if(planeet == Planeet.AARDE){
           valversnelling = 9.81; 
        }
        if(planeet == Planeet.MARS){
           valversnelling = 3.74; 
        }
        if(planeet == Planeet.MAAN){
           valversnelling = 1.62; 
        }
    }
   
     /**
     * Bepaal de x-coordinaat van de linkeronderhoek van het vat.
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public void setVatX(){
        this.vatX = vatX;
    }
    
    /**
     * Bepaal de y-coordinaat van de linkeronderhoek van het vat.
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public void setVatY(){
        this.vatY = vatY;
    }
    
     /**
     * Bepaal de breedte van het vat
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public void setVatBreedte(){
        this.vatBreedte = vatBreedte;
    }
    
     /**
     * Bepaal de breedte van het vat
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public void setVatHoogte(){
        this.vatHoogte = vatHoogte;
    }
    
     /**
     * Bepaal de hoogte van de toevoerkraan.
     * 
     * @author Robbe Bloemen
     * @version 08/12/2014
     */
    public void setToevoerkraanHoogte(){
        this.toevoerkraanHoogte = toevoerkraanHoogte;
    }
    
    /**
     * Deze methode hangt samen met de klasse Animator.
     * 
     * @author Jarne Machiels
     * @version 17/11/2014
     */
    public void tickToevoer() {
        setBerekenHoogteFluidum();
        setVolumeUit();
        setValversnelling();
        setLaatVatNietOverlopen();
        setUitstroomX();
        setToevoerstroomY();
    } 
}
