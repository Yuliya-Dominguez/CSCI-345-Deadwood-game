// Code for parsing Board XML file
// Taken from Dr. Moushumi Sharmin example, slightly modified

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;


public class RunBoardXML{

   private static ArrayList<Set> setList;
   private static ArrayList<Trailer> trailerList;//
   private static ArrayList<Office> officeList;//

   public static void main(String args[]){
   
      Document doc = null;
      BoardXMLparser parsing = new BoardXMLparser();
      try{
      
         doc = parsing.getDocFromFile("board.xml");
         setList = parsing.readBoardData(doc);//
         trailerList = parsing.readTrailerData(doc);//
         officeList = parsing.readOfficeData(doc);//
      
      }catch (Exception e){
      
         System.out.println("Error = "+e);
      
      }

      //getSetArea(0);
      //getSetArea(3);

      int gx = getTakesArea(0,0).getX();
      System.out.println(gx);

      /*getTrailerNeighbors();
      getOfficeNeighbors();
      getTrailNeighbor(0);
      getTrailNeighbor(1);
      getOffNeighbor(0);
      getOffNeighbor(1);
      getUpgradesList();

      getUpgradeLevel(0);
      getUpgradeLevel(3);
      getUpgradeLevel(9);

      getUpgradeCurrency(0);
      getUpgradeCurrency(5);
      getUpgradeCurrency(8);

      getUpgradeAmt(2);
      getUpgradeAmt(4);
      getUpgradeAmt(7);

      getUpgradeArea(0);
      getUpgradeArea(3);
      getUpgradeArea(7);*/

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
   public static Area getSetArea(int index) {
      Set set = setList.get(index);
      Area area = set.getArea();
      int x = area.getX();
      int y = area.getY();
      int h = area.getH();
      int w = area.getW();
      //System.out.println("area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
      return area;
   }

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
   public static Area getTakesArea(int setIndex, int takeIndex) {
      Set set = setList.get(setIndex);
      List<Takes> takesList = set.getTakes();
      Takes takes = takesList.get(takeIndex);
      Area area = takes.getArea();
      int x = area.getX();
      int y = area.getY();
      int h = area.getH();
      int w = area.getW();
      //System.out.println("area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
      return area;
   }

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

   public static List<Neighbors> getTrailerNeighbors() {

      Trailer trailer = trailerList.get(0);
      List<Neighbors> neighborsList = trailer.getNeighbors();
      Neighbors neighbors = null;
      String name = null;

      for (int i = 0; i < neighborsList.size(); i++) {
         neighbors = neighborsList.get(i);
         name = neighbors.getName();

         System.out.println("Neighbor " + i + ":");
         System.out.println("\tName: " + name);
      }
      return neighborsList;
   }

   //here we will need trailer's area

   public static List<Neighbors> getOfficeNeighbors() {

      Office office = officeList.get(0);
      List<Neighbors> neighborsList = office.getNeighbors();
      Neighbors neighbors = null;
      String name = null;

      for (int i = 0; i < neighborsList.size(); i++) {
         neighbors = neighborsList.get(i);
         name = neighbors.getName();

         System.out.println("Neighbor " + i + ":");
         System.out.println("\tName: " + name);
      }
      return neighborsList;
   }

   //here we will need office area

   public static String getTrailNeighbor(int neighborIndex) {
      Trailer trailer = trailerList.get(0);
      List<Neighbors> neighborsList = trailer.getNeighbors();
      Neighbors neighbors = neighborsList.get(neighborIndex);
      String name = neighbors.getName();
      return name;
   }

   public static String getOffNeighbor(int neighborIndex) {
      Office office = officeList.get(0);
      List<Neighbors> neighborsList = office.getNeighbors();
      Neighbors neighbors = neighborsList.get(neighborIndex);
      String name = neighbors.getName();
      return name;
   }

   public static List<Upgrade> getUpgradesList() {

      Office upgrade = officeList.get(0);
      List<Upgrade> upList = upgrade.getUpgrade();
      /*Upgrade up = null;
      int level = 0;
      Area area = null;
      String currency = null;
      int amt = 0;

      for (int i = 0; i < upList.size(); i++) {
         up = upList.get(i);
         level = up.getLevel();
         area = up.getArea();
         currency = up.getCurrency();
         amt = up.getAmt();

         System.out.println("Upgrade " + i + ":");
         System.out.println("\tLevel: " + level);
         System.out.println("\tCurrency: " + currency);
         System.out.println("\tAmount: " + amt);
         System.out.println("\tArea: " + area.getX() + ", " + area.getY() + ", " + area.getH() + ", " + area.getW());
      }*/
      return upList;
   }

   public static int getUpgradeLevel(int upIndex) {
      Office office = officeList.get(0);
      List<Upgrade> upList = office.getUpgrade();
      Upgrade upgrade = upList.get(upIndex);
      int level = upgrade.getLevel();
      //System.out.println("upgrade level = " + level);
      return level;
   }

   public static String getUpgradeCurrency(int upIndex) {
      Office office = officeList.get(0);
      List<Upgrade> upList = office.getUpgrade();
      Upgrade upgrade = upList.get(upIndex);
      String currency = upgrade.getCurrency();
      //System.out.println("upgrade currency = " + currency);
      return currency;
   }

   public static int getUpgradeAmt(int upIndex) {
      Office office = officeList.get(0);
      List<Upgrade> upList = office.getUpgrade();
      Upgrade upgrade = upList.get(upIndex);
      int amt = upgrade.getAmt();
      //System.out.println("upgrade amt = " + amt);
      return amt;
   }

   public static Area getUpgradeArea(int upIndex) {
      Office office = officeList.get(0);
      List<Upgrade> upList = office.getUpgrade();
      Upgrade upgrade = upList.get(upIndex);
      Area area = upgrade.getArea();
      int x = area.getX();
      int y = area.getY();
      int h = area.getH();
      int w = area.getW();
      //System.out.println("part area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
      return area;
   }

}