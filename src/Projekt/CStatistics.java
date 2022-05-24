package Projekt;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CStatistics {
    ArrayList<String> stats = new ArrayList<String>();
    public void savetofile() throws IOException {
        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter("statistics.csv");

            for(String i: stats)
            fWriter.write(i+"\n");

        } finally {
            if (fWriter != null) {
                fWriter.close();
            }
        }
    }

    public void compute(ArrayList<CMoveObject> List, CMap map){

        int[] sumob = new int[3];
        int[] sumdis = new int[3];
        for(int i =0; i <3; i++){
            sumdis[i]=0;
            sumob[i]=0;
        }
        for(CMoveObject i: List){
            if(i.typ=='C') sumob[0]++;
            if(i.typ=='P') sumob[1]++;
            if(i.typ=='U') sumob[2]++;
        }
        for(CMoveObject i: List){
            if(i.typ=='C') sumdis[0]=sumdis[0]+map.getdistance(i.getPossition());
            if(i.typ=='P') sumdis[1]=sumdis[1]+map.getdistance(i.getPossition());
            if(i.typ=='U') sumdis[2]=sumdis[2]+map.getdistance(i.getPossition());
        }
        String S="";

        for(int i =0; i<3;i++){
            S =S+sumob[i]+";";
            if(sumob[i]>0) {
                S = S + sumdis[i] / sumob[i]+";";
            }else{
                S= S+"0;";
            }
        }
        stats.add(S);
        System.out.println(S);

    }

}
