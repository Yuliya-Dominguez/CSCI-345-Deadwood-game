// Code for parsing Cards XML file
// Taken from Dr. Moushumi Sharmin example, slightly modified

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;


public class RunCardsXML{

   private static ArrayList<Card> cardsList;

   public static void main(String args[]){
   
      Document doc = null;
      CardsXMLparser parsing = new CardsXMLparser();
      try{
      
         doc = parsing.getDocFromFile("cards.xml");
         cardsList = parsing.readCardsData(doc);
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }
      getCardBudget(5);
      getName(5);
      getSceneNumber(5);
      getSceneDescription(5);
      //getPartsList(5);
      getPartName(5, 0);
      getPartName(5, 2);
      getPartLevel(5,0);
      getPartLevel(5,2);
      getPartArea(5,0);
      getPartArea(5,2);
      getPartLine(5,0);
      getPartLine(5,2);
      getPartsList(5);

   }

   public static int getCardBudget(int index) {
      Card card = cardsList.get(index);
      int budget = card.getBudget();
      System.out.println("budget = "+ budget);
      return budget;
   }

   public static String getName(int index) {
      Card card = cardsList.get(index);
      String name = card.getCardName();
      System.out.println("name = "+ name);
      return name;
   }

   public static int getSceneNumber(int index) {
      Card card = cardsList.get(index);
      Scene scene = card.getScene();
      int number = scene.getNumber();
      System.out.println("scene number = " + number);
      return number;
  }

  public static String getSceneDescription(int index) {
      Card card = cardsList.get(index);
      Scene scene = card.getScene();
      String description = scene.getDescription();
      System.out.println("scene description = " + description);
      return description;
  }

  //public static int[] getPartsList(int index) {
  public static List<Parts> getPartsList(int index) {

      Card card = cardsList.get(index);
      List<Parts> partsList = card.getParts();
      Parts part = null;
      String name = null;
      int level = 0;
      Area area = null;
      String line = null;

      //int[] indices = new int[partsList.size()];

      for (int i = 0; i < partsList.size(); i++) {
         part = partsList.get(i);
         name = part.getName();
         level = part.getLevel();
         area = part.getArea();
         line = part.getLine();

         System.out.println("Here are all available parts:\nPart " + i + ":");
         System.out.println("\tName: " + name);
         System.out.println("\tLevel: " + level);
         System.out.println("\tArea: " + area.getX() + ", " + area.getY() + ", " + area.getH() + ", " + area.getW());
         System.out.println("\tLine: " + line);
         
         //indices[i] = i;
      }
      //return indices;
      return partsList;
}

public static String getPartName(int cardIndex, int partIndex) {
   Card card = cardsList.get(cardIndex);
   List<Parts> partsList = card.getParts();
   Parts part = partsList.get(partIndex);
   String name = part.getName();
   System.out.println("part name = " + name);
   return name;
}

public static int getPartLevel(int cardIndex, int partIndex) {
   Card card = cardsList.get(cardIndex);
   List<Parts> partsList = card.getParts();
   Parts part = partsList.get(partIndex);
   int level = part.getLevel();
   System.out.println("part level = " + level);
   return level;
}

public static Area getPartArea(int cardIndex, int partIndex) {
   Card card = cardsList.get(cardIndex);
   List<Parts> partsList = card.getParts();
   Parts part = partsList.get(partIndex);
   Area area = part.getArea();
   int x = area.getX();
   int y = area.getY();
   int h = area.getH();
   int w = area.getW();
   System.out.println("part area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
   return area;
}

public static String getPartLine(int cardIndex, int partIndex) {
   Card card = cardsList.get(cardIndex);
   List<Parts> partsList = card.getParts();
   Parts part = partsList.get(partIndex);
   String line = part.getLine();
   System.out.println("part line = " + line);
   return line;
}

}