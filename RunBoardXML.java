// Code for parsing Board XML file
// Taken from Dr. Moushumi Sharmin example, slightly modified

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;


public class RunBoardXML{

   private static ArrayList<Set> setList;

   public static void main(String args[]){
   
      Document doc = null;
      BoardXMLparser parsing = new BoardXMLparser();
      try{
      
         doc = parsing.getDocFromFile("board.xml");
         setList = parsing.readBoardData(doc);
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }

      getSetName(7);
      getNeighborsList(7);
      getNeighborName(7,0);
      getNeighborName(7,2);
      getTakesList(7);
      getTakesNum(7,0);
      getPartName(7,0);
      getPartName(7,2);
      getPartLevel(7,1);
      getPartLevel(8,0);
      getPartArea(8,0);
      getPartLine(7,2);
      getPartLine(8,0);
   }

   public static String getSetName(int index) {
      Set set = setList.get(index);
      String name = set.getSetName();
      //System.out.println("name = "+ name);
      return name;
   }

   public static List<Neighbors> getNeighborsList(int index) {

      Set set = setList.get(index);
      List<Neighbors> neighborsList = set.getNeighbors();
      /*Neighbors neighbors = null;
      String name = null;

      for (int i = 0; i < neighborsList.size(); i++) {
         neighbors = neighborsList.get(i);
         name = neighbors.getName();

         System.out.println("Neighbor " + i + ":");
         System.out.println("\tName: " + name);
      }*/
      return neighborsList;
   }

   public static String getNeighborName(int setIndex, int neighborIndex) {
      Set set = setList.get(setIndex);
      List<Neighbors> neighborsList = set.getNeighbors();
      Neighbors neighbors = neighborsList.get(neighborIndex);
      String name = neighbors.getName();
      //System.out.println("neighbor name = " + name);
      return name;
   }

   //here we will need getArea

   public static List<Takes> getTakesList(int index) {

      Set set = setList.get(index);
      List<Takes> takesList = set.getTakes();
      return takesList;
   }

   public static int getTakesNum(int setIndex, int takeIndex) {

      Set set = setList.get(setIndex);
      List<Takes> takesList = set.getTakes();
      Takes takes = takesList.get(takeIndex);
      int num = takes.getNum();
      //System.out.println("take number = " + num);
      return num;
   }

   //here we will have getTakesArea

   public static List<Parts> getPartsList(int index) {

      Set set = setList.get(index);
      List<Parts> partsList = set.getParts();
      return partsList;
   }

   public static String getPartName(int setIndex, int partIndex) {
      Set set = setList.get(setIndex);
      List<Parts> partsList = set.getParts();
      Parts part = partsList.get(partIndex);
      String name = part.getName();
      System.out.println("part name = " + name);
      return name;
   }
   
   public static int getPartLevel(int setIndex, int partIndex) {
      Set set = setList.get(setIndex);
      List<Parts> partsList = set.getParts();
      Parts part = partsList.get(partIndex);
      int level = part.getLevel();
      System.out.println("part level = " + level);
      return level;
   }
   
   public static Area getPartArea(int setIndex, int partIndex) {
      Set set = setList.get(setIndex);
      List<Parts> partsList = set.getParts();
      Parts part = partsList.get(partIndex);
      Area area = part.getArea();
      int x = area.getX();
      int y = area.getY();
      int h = area.getH();
      int w = area.getW();
      System.out.println("part area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
      return area;
   }
   
   public static String getPartLine(int setIndex, int partIndex) {
      Set set = setList.get(setIndex);
      List<Parts> partsList = set.getParts();
      Parts part = partsList.get(partIndex);
      String line = part.getLine();
      System.out.println("part line = " + line);
      return line;
   }

}