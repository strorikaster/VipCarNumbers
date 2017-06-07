import java.io.*;
import java.util.*;

import static java.util.Collections.binarySearch;

/**
 * Created by в on 20.05.2017.
 */
public class VipCarNumbers {
    public static void main(String[] args) throws IOException {
        char[] allowedSymbols = {'a', 'b', 'c', 'e', 'h', 'k', 'm', 'o', 'p', 't', 'y', 'x'};
        //[allowedSymbols]\d{3}[allowedSymbols]{2}\d{2,3}
        String[] carNumbers = new String[1000];
        String[] regionNumbers = new String[100];
        int[] additionalRegionNumbers = {102, 103, 113, 116, 121, 123, 124, 125, 126, 134, 136, 138, 142, 150, 190, 750, 152, 154, 159, 161, 163, 164, 196, 173, 174, 177, 197, 199, 777, 178, 186};
        String[] rnWithAdditional = new String[regionNumbers.length + additionalRegionNumbers.length] ;
        ArrayList<String> regionNumbersList = new ArrayList<>();

        //ArrayList <Integer>  rn = regionNumbers + additionalRegionNumbers;
        String[] arrVipNumbers = new String[2500000];
        // String[] rn = new String[99];

        ArrayList<String> vipNumbers = new ArrayList<>();
        //Object[] arrVipNumbers = new Object[2000000];



        for (int i = 0; i <= carNumbers.length - 1; i++) {
            carNumbers[i] = Integer.toString(i);
            if (Integer.parseInt(carNumbers[i]) < 10){
                carNumbers[i] = "00"  + Integer.toString(i);
                //System.out.println(carNumbers[i]);
            }
            if (Integer.parseInt(carNumbers[i]) >= 10 && Integer.parseInt(carNumbers[i]) < 100){
                carNumbers[i] = "0" + Integer.toString(i);
                //System.out.println(carNumbers[i]);
            }
            if (Integer.parseInt(carNumbers[i]) > 100){
                carNumbers[i] =  Integer.toString(i);
                //System.out.println(carNumbers[i]);
            }
        }

        for (int i = 0; i < regionNumbers.length - 1; i++) {
            regionNumbers[i] =  Integer.toString(i);
            rnWithAdditional[i] = Integer.toString(i);
            if(Integer.parseInt(regionNumbers[i]) < 10) {
                regionNumbers[i] = "0" + Integer.toString(i);
                regionNumbers[i] = "0" + Integer.toString(i);
            }
            regionNumbersList.add(regionNumbers[i]);
        }
        for (int i = 0; i < additionalRegionNumbers.length - 1; i++) {

            regionNumbersList.add(Integer.toString(additionalRegionNumbers[i]));
        }


        for (int i = 0; i < allowedSymbols.length; i++) {
            for (int j = 0; j < carNumbers.length; j++) {
                for (int k = 0; k < regionNumbersList.size(); k++) {

//                    if (carNumbers[j] < 10 && Integer.parseInt(regionNumbersList.get(k)) < 10) {
//                        vipNumbers.add(Character.toString(allowedSymbols[i]) + "00" + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + "0" + regionNumbersList.get(k));
//                    } else {
//                        if (carNumbers[j] < 100 && Integer.parseInt(regionNumbersList.get(k)) < 10) {
//                            vipNumbers.add(Character.toString(allowedSymbols[i]) + "0" + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + "0" + regionNumbersList.get(k));
//                        } else {
//                            if (carNumbers[j] == 0 && Integer.parseInt(regionNumbersList.get(k)) < 10) {
//                                vipNumbers.add(Character.toString(allowedSymbols[i]) + "00" + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + "0" + regionNumbersList.get(k));
//                            } else {
//                                if (carNumbers[j] > 100 && Integer.parseInt(regionNumbersList.get(k)) < 10) {
//                                    vipNumbers.add(Character.toString(allowedSymbols[i]) + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + "0" + regionNumbersList.get(k));
//                                } else {
//                                    if (carNumbers[j] > 100 && Integer.parseInt(regionNumbersList.get(k)) > 10) {
//                                        vipNumbers.add(Character.toString(allowedSymbols[i]) + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + regionNumbersList.get(k));
//                                    }else{
//                                        if (carNumbers[j] > 100 && Integer.parseInt(regionNumbersList.get(k)) > 100) {
                    vipNumbers.add(Character.toString(allowedSymbols[i]) + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + regionNumbersList.get(k));
//                    if (i > 0 && i < allowedSymbols.length-1){
//                        vipNumbers.add(Character.toString(allowedSymbols[i+1]) + carNumbers[j] + allowedSymbols[i] + allowedSymbols[i] + regionNumbersList.get(k));
//                    }
//                                    }
//                                    }
//                                }
                    // }
                    //}
                    //}
//
                }

            }

        }



//        for (String item : vipNumbers) {
//            System.out.println(item);
//        }
        arrVipNumbers = vipNumbers.toArray(new String[vipNumbers.size()]);
    // System.out.println(vipNumbers.size());
//
//        PrintStream out = null;
//        try {
//            out = new PrintStream(new FileOutputStream("output.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.setOut(out);

//        for (String item1 : regionNumbersList){
//            System.out.println(item1);
//        }
//


        //System.out.println(regionNumbersList.size());

        //Collections.sort(sortVipNumbers);
        //sortVipNumbers.addAll(vipNumbers);
        String[] sortArrVipNumbers = Arrays.copyOf(arrVipNumbers, arrVipNumbers.length);
        Arrays.sort(sortArrVipNumbers);

       ArrayList<String> sortVipNumbers =  new ArrayList<String>();
        sortVipNumbers.addAll(vipNumbers);
       Collections.sort(sortVipNumbers);

        HashSet<String> hashSetVipNumbers = new HashSet<>();
        hashSetVipNumbers.addAll(vipNumbers);

        TreeSet<String> treeSetVipNumbers = new TreeSet<>();
        treeSetVipNumbers.addAll(vipNumbers);

//       System.out.println(vipNumbers);
//        System.out.println(sortVipNumbers);
//        System.out.println(hashSetVipNumbers);
//        System.out.println(treeSetVipNumbers);

       checkVipNumbers(arrVipNumbers, sortArrVipNumbers, hashSetVipNumbers, treeSetVipNumbers);

//        for (String item : treeSetVipNumbers) {
//            System.out.println(item);
//        }

    }
            public static void checkVipNumbers(String[] arrVipNumbers, String[] sortArrVipNumbers, HashSet<String> hashSetVipNumbers, TreeSet<String> treeSetVipNumbers) throws IOException {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                long start = System.currentTimeMillis();
                //String[] arrVipNumbers = new String[2500000];
                //arrVipNumbers = vipNumbers.toArray();

                for(;;) {
                    System.out.println("Please, enter car number in format xXXXxxXX, where x - letter, X - digit");
                    String enteredNumber = reader.readLine().trim();
                    boolean a = false;

                    System.out.println("Search without sorting");
                    for (int i = 0; i < arrVipNumbers.length; i++) {
                        if (arrVipNumbers[i].equals(enteredNumber)) {
                            //System.out.println("true" + " " + (System.currentTimeMillis() - start) + " ms");
                            //System.out.println(vipNumbers.get(i));
                            a = true;
                        } else {
                            //System.out.println("false" + " " + (System.currentTimeMillis() - start) + " ms");
                           // System.out.println(vipNumbers.get(i));
                            a = false;
                        }
                    }
                    if (a == true){
                    System.out.println("true " + ((System.currentTimeMillis() - start)) + " ms");
                    }else{
                        System.out.println("false " + ((System.currentTimeMillis() - start)) + " ms");
                    }

                    System.out.println("Search with sorting");

                    //if ((binarySearch(sortArrVipNumbers, enteredNumber) >= 0)) {
                    if ((Arrays.binarySearch(sortArrVipNumbers, enteredNumber))>=0){
                        System.out.println("true" + " " + (System.currentTimeMillis() - start) + " ms");
                    } else {
                        System.out.println("false" + " " + (System.currentTimeMillis() - start) + " ms");
                    }

                    System.out.println("Search HashSet");
                    //Collections.sort(vipNumbers);
                    if (hashSetVipNumbers.contains(enteredNumber)) {
                        System.out.println("true" + " " + (System.currentTimeMillis() - start) + " ms");
                    } else {
                        System.out.println("false" + " " + (System.currentTimeMillis() - start) + " ms");
                    }

                    System.out.println("Search TreeSet");
                    //Collections.sort(vipNumbers);
                    if (treeSetVipNumbers.contains(enteredNumber)) {
                        System.out.println("true" + " " + (System.currentTimeMillis() - start) + " ms");
                    } else {
                        System.out.println("false" + " " + (System.currentTimeMillis() - start) + " ms");
                    }


                    if (enteredNumber.equals("STOP")){
                        System.out.println("Received \"STOP\" command, exit");
                        break;
                    }
                }
            }

}