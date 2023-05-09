// Code for parsing Cards XML file
// Taken from Dr. Moushumi Sharmin example, slightly modified

import org.w3c.dom.Document;


public class RunCardsXML{

   public static void main(String args[]){
   
      Document doc = null;
      CardsXMLparser parsing = new CardsXMLparser();
      try{
      
         doc = parsing.getDocFromFile("cards.xml");
         parsing.readCardsData(doc);
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }
   }
}