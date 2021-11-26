import java.util.*;

public class Text1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        String[] numss = nums.split(" ");
        List<String> blackList = new ArrayList<>();
        List<String> ipList = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(numss[0]); i++) {
            blackList.add(sc.nextLine());
        }
        for (int i = 0; i < Integer.parseInt(numss[1]); i++) {
            ipList.add(sc.nextLine());
        }
        List<String> filter = new ArrayList<>();
        for (String s : blackList) {
            //如果是8, 说明第一个数字匹配即过滤
            switch (s.split("/")[1]) {
                case "8": {
                    String[] ips = s.split("\\.");
                    filter.add(ips[0]);
                    break;
                }
                case "16": {
                    String[] ips = s.split("\\.");
                    filter.add(ips[0] + "." + ips[1]);
                    break;
                }
                case "24": {
                    String[] ips = s.split("\\.");
                    filter.add(ips[0] + "." + ips[1] + "." + ips[2]);
                    break;
                }
                case "32": {
                    String[] ips = s.split("\\.");
                    filter.add(ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3]);
                    break;
                }
            }
        }

        for (String s : ipList) {
            String[] ips = s.split("\\.");
            if(filter.contains(ips[0])){
                answer.add(s);
            }else if(filter.contains(ips[0]+"."+ips[1])){
                answer.add(s);
            }else if(filter.contains(ips[0]+"."+ips[1]+"."+ips[2])){
                answer.add(s);
            }else if(filter.contains(ips[0]+"."+ips[1]+"."+ips[2]+"."+ips[3])){
                answer.add(s);
            }
        }
        if(answer.size()>0) {
            for (String s : answer) {
                System.out.println(s);
            }
        }else{
            System.out.println("null");
        }
    }
}
