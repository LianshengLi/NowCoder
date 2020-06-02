package main;

public class StringProblems {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
    public String replaceSpace1(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                res.append("%20");
            }
            else{
                res.append(chars[i]);
            }
        }
        return res.toString();
    }
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    public boolean isNumeric(char[] str) {
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */
    //Insert one char from stringstream
    //利用一个int型数组表示256个字符，这个数组初值置为-1.
    //每读出一个字符，将该字符的位置存入字符对应数组下标中。
    //若值为-1标识第一次读入，不为-1且> 0表示不是第一次读入，将值改为-2.
    //之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
    private int[] occurence = new int[256];
    private int index;

    public Solution(){
        for(int i=0;i<256;i++){
            occurence[i] = -1;
        }
        index = 0;
    }
    void Insert(char ch)
    {
        if(occurence[ch] == -1)
            occurence[ch] = index;
        else if(occurence[ch] >= 0)
            occurence[ch] = -2;

        index++;
    }
    //return the first appearence once char in current stringstream
    char FirstAppearingOnce()
    {
        //找到index的最小值
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(occurence[i] >=0 && occurence[i]<minIndex){
                ch = (char)i;
                minIndex = occurence[i];
            }
        }
        //没有只出现一次的字符返回'#    '
        if(ch == '\0')
            return '#';
        return ch;
    }
}
