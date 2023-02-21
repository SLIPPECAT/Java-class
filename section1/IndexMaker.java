package section1;

import java.io.*;
import java.util.Scanner;

public class IndexMaker {
//    static String[] words = new String[100000];
//    static int[] count = new int[100000];
    static Item[] items = new Item[100000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fileName = kb.next();  // sample.txt
                makeIndex(fileName);
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if (index > -1) {
                    System.out.println("The word "+items[index].word+" appears"+items[index].count+" times.");
                }
                else {
                    System.out.println("The word "+str+" does not appear.");
                }

            } else if (command.equals("saveas")) {
                String fileName = kb.next();  // sample.txt
                saveAs(fileName);
            } else if (command.equals("exit"))
                break;
        }
        kb.close();
    }
    static void saveAs(String fileName){
        PrintWriter outFile;
        try{
            outFile = new PrintWriter(new FileWriter(fileName));
            for (int i=0; i<n; i++){
                outFile.println(items[i].word + " " + items[i].count);
            }
            outFile.close();
        } catch (IOException e){
            System.out.println("Save failed");
            return;
        }
    }
    static void makeIndex(String fileName) {
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()) {
                String str = inFile.next();  // 하나를 읽는다.

                String trimmed = trimming(str);
                if (trimmed != null){
                    String t = trimmed.toLowerCase();
                    addWord( t );
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            return;
        }
    }

    static String trimming(String str) {

        int i = 0, j = str.length()-1;
        while ( i < str.length() && !Character.isLetter( str.charAt(i) ) )  //  while i-th character is not letter i++
            i++;  // 범위를 벗어나지 않게 i로 범위를 설정해준다.
        while ( j >=0  && !Character.isLetter( str.charAt(j) ) )  //  while i-th character is not letter i++
            j--;  // 범위를 벗어나지 않게 i로 범위를 설정해준다.
//        System.out.println(str + ";"+i+":"+j);  // 알파벳이 없는 경우가 있다. i가 j보다 커져버림
        if (i > j)
            return null;
        return str.substring(i, j+1);
    }

    // 문자열에 목록이 있는지 확인하는 함수
    static void addWord(String str) {

        int index = findWord(str);   // returns -1 if not found
        if (index != -1) {  // found  words[index] == str  // exist
            items[index].count++;
        }
        else {  //not found
            int i =n-1;
//            while(;i>= && words[i].compareTo(str)>0){}

            while (i >= 0 && items[i].word.compareToIgnoreCase(str) > 0){
                items[i+1] = items[i]; // 이제 items를 통째로 바꿀 것!
                i--;
            }
            // 여기서 처리를 해줘야 하는 부분이 있다..아래꺼
            // 이 라인이 중요한 이유는 지금 새로 추가된 단어가 들어갈 공간을 마련하지 않은 꼴이 된다.
            items[i+1] = new Item();
            // 이렇게 해야 새로 만들어진 객체의 참조변수의 안에 값을 넣어줄 수 있다.
            items[i+1].word = str;
            items[i+1].count = 1;
            n++;
        }
    }
    static int findWord(String str) {
        for (int i = 0; i < n; i++) {
            if (items[i].word.equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }
}

