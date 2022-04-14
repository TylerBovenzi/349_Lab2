import java.util.*;
import java.io.*;

public class TopSortTester {

   public static void main(String[] args) {
      TopSorter myTopSorter;
      ArrayList<Integer> resultList;

      ArrayList<Integer> Test1Ans = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3));
      ArrayList<Integer> Test2Ans = new ArrayList<Integer>(Arrays.asList(3, 5, 2, 1, 4));
      ArrayList<Integer> Test3Ans = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1));
      ArrayList<Integer> Test4Ans = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1));
      ArrayList<Integer> Test6Ans = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1));
      ArrayList<Integer> Test7Ans = new ArrayList<Integer>(Arrays.asList(7,1,2,3,6,5,4));
      //ArrayList<Integer> Test7Ans = new ArrayList<Integer>(Arrays.asList(7,1,2,3,6,5,4));

      try {
         System.out.println("-------Test 1--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest1.txt");
         System.out.println(resultList.equals(Test1Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest1.txt");
         System.out.println(resultList.equals(Test1Ans));


         System.out.println("-------Test 2--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest2.txt");
         System.out.println(resultList.equals(Test2Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest2.txt");
         System.out.println(resultList.equals(Test2Ans));
         
         System.out.println("-------Test 3--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest3.txt");
         System.out.println(resultList.equals(Test3Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest3.txt");
         System.out.println(resultList);
         System.out.println(resultList.equals(Test3Ans));

         System.out.println("-------Test 4--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest4.txt");
         System.out.println(resultList.equals(Test4Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest4.txt");
         System.out.println(resultList.equals(Test4Ans));

         System.out.println("-------Test 5--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest5.txt");
         System.out.println(resultList);
         resultList = myTopSorter.dfsTopSorter("topSortTest5.txt");
         System.out.println(resultList);

         System.out.println("-------Test 6--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest6.txt");
         System.out.println(resultList.equals(Test6Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest6.txt");
         System.out.println(resultList.equals(Test6Ans));

         System.out.println("-------Test 7--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest7.txt");
         System.out.println(resultList.equals(Test7Ans));
         resultList = myTopSorter.dfsTopSorter("topSortTest7.txt");
         System.out.println(resultList.equals(Test7Ans));

         System.out.println("-------Test 8--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest8.txt");
         System.out.println(resultList);
         resultList = myTopSorter.dfsTopSorter("topSortTest8.txt");
         System.out.println(resultList);

         System.out.println("-------Test 9--------");
         myTopSorter = new TopSorter();
         resultList = myTopSorter.srcRemTopSorter("topSortTest9.txt");
         System.out.println(resultList);
         resultList = myTopSorter.dfsTopSorter("topSortTest9.txt");
         System.out.println(resultList);

      }
      catch (Exception e) {
         System.out.println("EXCEPTION JAKE");
         System.out.println(e.getMessage());
      }
      
   }
}
