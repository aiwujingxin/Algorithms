package knowledge.datastructure.string.bignumber.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/26 14:04
 */
public class NumberToChinese {

    String[] units = new String[]{"拾", "百", "千", "万", "拾", "百", "千", "亿"};
    // 中文大写数字数组
    String[] numeric = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private static final String YUAN = "圆";
    private static final String JIAO = "角";
    private static final String FEN = "分";

    public static void main(String[] args) {
        System.out.println(new NumberToChinese().toNum("178976543213.11"));
        System.out.println(new NumberToChinese().toNum("17900543210"));
    }

    public String toNum(String number) {
        String[] strings = number.split("\\.");
        String yuan = strings[0];
        String yuanText = numberToChinese(yuan);
        StringBuilder sb = new StringBuilder();
        sb.append(yuanText).append(YUAN);
        if (strings.length == 1) {
            sb.append("整");
            return sb.toString();
        }
        String xiaoshu = strings[1];
        String jiao = !xiaoshu.isEmpty() ? String.valueOf(xiaoshu.charAt(0)) : "";
        String fen = xiaoshu.length() > 1 ? String.valueOf((xiaoshu.charAt(1))) : "";

        String jiaoText = numberToChinese(jiao);
        String fenText = numberToChinese(fen);

        if (!jiaoText.equals("零")) {
            sb.append(jiaoText).append(JIAO);
        }

        if (!fenText.equals("零")) {
            sb.append(fenText).append(FEN);
        }
        return sb.toString();
    }

    private String numberToChinese(String temp) {
        if (temp == null || temp.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        // 遍历一行中所有数字
        for (int k = -1; !temp.isEmpty(); k++) {
            // 解析最后一位
            int j = Integer.parseInt(temp.substring(temp.length() - 1));
            String rtemp = numeric[j];

            // 数值不是0且不是个位 或者是万位或者是亿位 则去取单位
            if (j != 0 && k != -1 || k % 8 == 3 || k % 8 == 7) {
                rtemp += units[k % 8];
            }

            // 拼在之前的前面
            res.insert(0, rtemp);

            // 去除最后一位
            temp = temp.substring(0, temp.length() - 1);
        }

        // 去除后面连续的零零..
        while (res.toString().endsWith(numeric[0])) {
            res = new StringBuilder(res.substring(0, res.lastIndexOf(numeric[0])));
        }

        // 将零零替换成零
        while (res.toString().contains(numeric[0] + numeric[0])) {
            res = new StringBuilder(res.toString().replaceAll(numeric[0] + numeric[0], numeric[0]));
        }

        // 将 零+某个单位 这样的窜替换成 该单位 去掉单位前面的零
        for (int m = 1; m < units.length; m++) {
            res = new StringBuilder(res.toString().replaceAll(numeric[0] + units[m], units[m]));
        }
        // 将壹十改为十
        if (res.toString().startsWith(numeric[1] + units[0])) {
            res = new StringBuilder(res.substring(1));
        }
        return res.toString();
    }
}
