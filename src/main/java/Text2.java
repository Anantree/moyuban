import java.util.*;

public class Text2 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
        String line = "A->C,B->C,D->A,C->E";
//        String simple = sc.nextLine();
        String simple = "C";
        System.out.println(getData(line, simple));
    }
    public static String getData(String line,String simple){
        Map<String,String> dep = new HashMap<>();
        String[] data = line.split(",");
        if(data.length==0){
            return "false";
        }
        if(line.split(simple).length==0){
            return "false";
        }
        List<String> simpleHead = new ArrayList<>();
        List<String> simpleEnd = new ArrayList<>();
        for (String datum : data) {
            dep.put(datum.charAt(0) + "", datum.charAt(3) + "");
            if ((datum.charAt(3) + "").equals(simple)) {
                simpleHead.add(datum.charAt(0) + "");
            }
            if ((datum.charAt(0) + "").equals(simple)) {
                simpleEnd.add(datum.charAt(3) + "");
            }
        }
        for (String datum : data) {
            if(simpleHead.contains((datum.charAt(3)+""))){
                simpleHead.add((datum.charAt(3)+""));
            }
            if(simpleEnd.contains((datum.charAt(0)+""))){
                simpleEnd.add(datum.charAt(3) + "");
            }
        }
        for (String end : simpleEnd) {
            if(simpleHead.contains(dep.get(end))){
                return "false";
            }
        }
        float v = (float) simpleEnd.size() / (simpleHead.size() + simpleEnd.size());
        return String.format("%.2f", v);
    }
}
