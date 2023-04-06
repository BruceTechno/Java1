import java.util.*;

public class Main  {
    public static void main(String[] args) {
        int count=0;
        List<Integer> topic = genereteNum();
        System.out.println(topic);
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            int A=0;
            int B=0;
            System.out.println("請猜四位數:");
            String input = scanner.next();
            //確定輸入為四位數
            if (input.length() != 4) {
                System.out.println("輸入的不是四位數");
                continue;
            }
            //檢查輸入數字 不重複
            Set<Character> set = new HashSet<>();
            for (char c : input.toCharArray()) {
                set.add(c);
            }
            if (set.size() != 4) {
                System.out.println("輸入的數字不能重複");
                continue;
            } else {
                System.out.println("你猜的數字為: " + input);
            }
            //判斷 A OR B
            int num = Integer.parseInt(input);
            int onesDigit = num % 10;
            int tensDigit = (num / 10) % 10;
            int hundredsDigit = (num / 100) % 10;
            int thousandsDigit = num / 1000;

            Map<Integer,Integer> Digit = new HashMap<>();
            Digit.put(0,thousandsDigit);            //topic.get(0)
            Digit.put(1,hundredsDigit);             //topic.get(1)
            Digit.put(2,tensDigit);                 //topic.get(2)
            Digit.put(3,onesDigit);                 //topic.get(3)

            for (Map.Entry<Integer,Integer> x : Digit.entrySet()){
                if (x.getValue()== topic.get(x.getKey())){
                    A++;
                    System.out.println(x.getValue()+"的位置是對的");
                }else if (topic.contains(x.getValue())) {
                        B++;
                    }
                }
            if (A==4) {
                count++;
                System.out.println("Bingo");
                System.out.println("你猜的次數 :"+count);
                break;
            }else {
                count++;
                System.out.println(A + "A" + B + "B");
                System.out.println("你猜的次數 :" + count);
            }
        }
    }
    public static List<Integer> genereteNum(){

        List<Integer> list = new ArrayList<>();
        Random random =new Random();
        for (int i = 0 ; i<10 ; i++){
            list.add(i);
        }
        for (int x : list){
            int randoNum = random.nextInt(10);
            int temp =list.get(randoNum);
            list.set(randoNum,list.get(x));
            list.set(x,temp);
        }
        List randomList = list.subList(0,4);
       return  randomList;
    }
}