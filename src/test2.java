import java.util.*;

public class test2 {

    public static void main(String[] args) {
        int count = 0;

        List<Integer> topic = genereteNum();
        System.out.println(topic);
        for (; ; ) {
            count++;
            String input = getInput();
            if (judge(input, topic, count) == 4) {
                break;
            }
        }
    }
    public static List<Integer> genereteNum() {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int x : list) {
            int randoNum = random.nextInt(10);
            int temp = list.get(randoNum);
            list.set(randoNum, list.get(x));
            list.set(x, temp);
        }
        List randomList = list.subList(0, 4);
        return randomList;
    }
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請猜四位數:");
        //確定輸入為四位數
        for (; ; ) {
            String input = scanner.next();
            //檢查輸入數字 不重複
            Set<Character> set = new HashSet<>();
            for (char c : input.toCharArray()) {
                set.add(c);
            }
            if (input.length() != 4 || set.size() != 4) {
                System.out.println("輸入格式錯誤");
            } else {
                System.out.println("你猜的數字為: " + input);
                return input;
            }
        }
    }
    public static int judge(String input, List<Integer> topic, int count /*int A, int B*/  /*int count*/) {
        //判斷 A OR B
        int A = 0;
        int B = 0;
        int num = Integer.parseInt(input);
        int onesDigit = num % 10;
        int tensDigit = (num / 10) % 10;
        int hundredsDigit = (num / 100) % 10;
        int thousandsDigit = num / 1000;

        Map<Integer, Integer> Digit = new HashMap<>();
        Digit.put(0, thousandsDigit);            //topic.get(0)
        Digit.put(1, hundredsDigit);             //topic.get(1)
        Digit.put(2, tensDigit);                 //topic.get(2)
        Digit.put(3, onesDigit);                 //topic.get(3)

        for (Map.Entry<Integer, Integer> x : Digit.entrySet()) {
            if (x.getValue() == topic.get(x.getKey())) {
                A++;
                System.out.println(x.getValue() + "的位置是對的");
            } else if (topic.contains(x.getValue())) {
                B++;
            }
        }
        if (A == 4) {
            System.out.printf("你猜了%d次\n", count);
            System.out.println("Bingo");
        } else {
            System.out.println(A + "A" + B + "B");
            System.out.printf("你猜了%d次\n", count);
        }
        return A;
    }
}
