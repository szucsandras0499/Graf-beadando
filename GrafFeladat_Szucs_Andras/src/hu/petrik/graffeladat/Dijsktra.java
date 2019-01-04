
package hu.petrik.graffeladat;

import java.util.ArrayList;
import java.util.List;

public class Dijsktra {
    
    public void legrovidebbUt(Graf tempGraf, int kezdocsucs){
        
        int Meret = tempGraf.getCsucsok().size();
        
        List<Integer> distance = new ArrayList<>();
        List<Boolean> sptset = new ArrayList<>();
    
        for (int i = 0; i < Meret; i++) {
            distance.add(Integer.MAX_VALUE);
            sptset.add(false);
        }
        distance.set(kezdocsucs, 0);
        
        for (int i = 0; i < Meret-1; i++) {
            int uv = mindistanceance(distance, sptset);
            sptset.set(uv, true);
            
            for (int j = 0; j < Meret; j++) {
                if (!sptset.get(j)){
                    if(getSulyFromElek(tempGraf.getElek(), uv, j) != 0) {
                        if (distance.get(uv) != Integer.MAX_VALUE) {
                            if (distance.get(uv) + getSulyFromElek(tempGraf.getElek(), uv, j) < distance.get(j)) {
                                distance.set(j, distance.get(uv) + getSulyFromElek(tempGraf.getElek(), uv, j)) ; 
                            }    
                        }
                    }
                }
            }
        }
        
        printSolution(distance, Meret);
    }
    
    private int getSulyFromElek(List<El> elek, int uv, int j){
        int suly = 0;
        
        for (El el : elek) {
                if (el.getCsucs1() == uv && el.getCsucs2() == j) {
                    suly = el.getSuly();
                }
            }
        return suly;
    }
    
    private int mindistanceance(List<Integer> distance, List<Boolean> sptset){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for (int i = 0; i < distance.size(); i++) 
            if (sptset.get(i)== false && distance.get(i) <= min) {
                min = distance.get(i);
                min_index = i;
            }
        
        return min_index;
    }
    
    private void printSolution(List<Integer> distance, int n){
        System.out.println("Vertex   distanceance from Source");
        for (int i = 0; i < distance.size(); i++) {
            System.out.println(i+"        " + distance.get(i));
        }
    }
}
