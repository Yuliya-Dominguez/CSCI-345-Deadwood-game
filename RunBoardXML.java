// Code for parsing XML file
// Taken from Dr. Moushumi Sharmin example, slightly modified

import org.w3c.dom.Document;


public class RunBoardXML{

   public static void main(String args[]){
   
      Document doc = null;
      BoardXMLparser parsing = new BoardXMLparser();
      try{
      
         doc = parsing.getDocFromFile("board.xml");
         parsing.readBoardData(doc);
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }
   }
}