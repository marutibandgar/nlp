package com.algorithm;

import java.sql.ResultSet;
import java.util.ArrayList;



public class C4_5 {
	
	

public static int computeEditDistance(String s1, String s2) {
	
	s1 = s1.toLowerCase();//Database Q
    s2 = s2.toLowerCase();//Search Q(keyword)

    int[] costs = new int[s2.length() + 1];//jdbc+1=5
    for (int i = 0; i <= s1.length(); i++) {//i<=12(what is jdbc=12)
        int lastValue = i;//1
        for (int j = 0; j <= s2.length(); j++) {
            if (i == 0) {
                costs[j] = j;
            } else {
                if (j > 0) {
                    int newValue = costs[j - 1];//0
                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {//character checking
                        newValue = Math.min(Math.min(newValue, lastValue),costs[j]) + 1;
                    }
                    costs[j - 1] = lastValue;//first match=8,(1-1=0),cost[0]=7
                    lastValue = newValue;
                }
            }
        }
        if (i > 0) {
            costs[s2.length()] = lastValue;
        }
    }
    for(int i=0;i<costs.length;i++){
    	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+costs[i]);
    }
    return costs[s2.length()];
    
    //cost=7
}

public static double printDistance(String s1, String s2) {
	
	System.out.println("In String Match  "+s1+" Second String "+s2);
    double similarityOfStrings = 0.0;
    int editDistance = 0;
    if (s1.length() < s2.length()) { // s1 should always be bigger
        String swap = s1;
        s1 = s2;
        s2 = swap;
    }
    int bigLen = s1.length();
    editDistance = computeEditDistance(s1, s2);
    if (bigLen == 0) {
        similarityOfStrings = 100; /* both strings are zero length */
    } else {
        similarityOfStrings = (bigLen - editDistance) / (double) bigLen*100;
    }
    //////////////////////////
    //System.out.println(s1 + "-->" + s2 + ": " +
      //      editDistance + " (" + similarityOfStrings + ")");
    
    /*System.out.println("***************************");
    System.out.println( " " + similarityOfStrings + ""+"%");*/
   
	return similarityOfStrings;//5
    
   
	
}

/*public static void main(String[] args) {
   
	StringMatch r=new StringMatch();
   double d=r.printDistance("vinod", "vinod");
  System.out.println(d);
  
   
    }*/


 }

