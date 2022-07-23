package LeetCode;

public class LeetCode65_regex {

    public boolean isNumber(String s) {
        String Exp = "(([+\\-](\\d+(\\.\\d*)?|(\\.\\d+)))|(\\d+(\\.\\d*)?)|(\\.\\d+))([e,E][+\\-]?\\d+)?";
        return s.matches(Exp);
    }
}
