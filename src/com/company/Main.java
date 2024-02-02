package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // нужно слово из 6 букв и в котором будет слово "cat"
        // cat\w{3}|\wcat\w{2}|\w{2}cat\w|\w{3}cat
        // как вариант, но это очень неудобно и грамоздко

        // для начало определим ему сколько нужно символов
        // b\w{6}\b

        // теперь искомое слово
        // \b\w*cat\w*\b

        // а теперь объеденим эти 2 условия и получим следующие варианты записи:
        // (?=b\w{6}\b)\b\w*cat\w*\b
        // (?=b\w{6}\b)\w*cat\w*
        // (?=b\w{6}\b)\w{0,3}*cat\w*
        // \b(?=b\w{6}\b)\w{0,3}*cat\w*

        Pattern p1 = Pattern.compile("(?=\\b\\w{6}\\b)\\w*cat\\w*"); // не нужна буква "u", найдет если будет Iraq
        Matcher m1 = p1.matcher("wecate");
        while (m1.find()){
            System.out.println(m1.start() +" "+ m1.group()+" ");
        }

        // а теперь другой пример 6-12 символом, слова "cat", "dog" и "mouse"
        Pattern p2 = Pattern.compile("\\b(?=\\w{6,12}\\b)\\w{0,9}(cat|dog|mouse)\\w*"); // если любой символ перед "b", не "а"
        Matcher m2 = p2.matcher("mycats do nit doge, my cate like bigmouse");
        while (m2.find()){
            System.out.println(m2.start() +" "+ m2.group()+" ");
        }
    }
}
