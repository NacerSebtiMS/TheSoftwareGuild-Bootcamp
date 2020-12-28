/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nacer
 */
public class StateCapitals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[][] data = {
			{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"}, {"California", "Sacramento"},
			{"Colorado", "Denver"}, {"Connecticut", "Hartford"}, 
			{"Delaware", "Dover"}, {"Florida", "Tallahassee"}, 
			{"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
			{"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
			{"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"}, 
			{"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, 
			{"Maryland", "Annapolis"}, {"Massachusetts", "Boston"}, 
			{"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, 
			{"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"}, 
			{"Montana", "Helena"}, {"Nebraska", "Lincoln"}, 
			{"Nevada	", "Carson City"}, {"New Hampshire", "Concord"}, 
			{"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, 
			{"New York", "Albany"}, {"North Carolina", "Raleigh"}, 
			{"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"}, 
			{"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, 
			{"South Carolina", "Columbia"}, {"South Dakota", "Pierre"}, 
			{"Tennessee", "Nashville"}, {"Texas", "Austin"}, 
			{"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"}, 
			{"Virginia", "Richmond"}, {"Washington", "Olympia"}, 
			{"West Virginia", "Charleston"}, {"Wisconsin", "Madison"}, 
			{"Wyoming", "Cheyenne"}};
        
        // We create our HashMap
        Map<String, String> capitals = new HashMap<>();
        
        // We fill our HashMap
        for(int i=0;i<data.length;i++){
            capitals.put(data[i][0], data[i][1]);
        }
        
        // We will store our outputs in variables so we don't need to do multiple loops
        String output1 = "STATES:"+"\n"+"=======";
        String output2 = "CAPITALS:"+"\n"+"=======";
        String output3 = "STATE/CAPITAL PAIRS:"+"\n"+"=======";
        
        Set<String> keys = capitals.keySet();
        
        for (String k : keys) {
            output1 += "\n" + k;
            output2 += "\n" + capitals.get(k);
            output3 += "\n" + k + " - " + capitals.get(k);
        }
        
        System.out.println(output1);
        System.out.println();        
        System.out.println(output2);
        System.out.println();
        System.out.println(output3);
        
    }
    
}
