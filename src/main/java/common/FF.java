package common;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jingxinwu
 * @date 2021-08-24 8:29 下午
 */
public class FF {

    public static void main(String[] args) throws Throwable {

        String value = "${name1}，**sadas${job2}，asda${date3}";
        Map<String, String> map = new HashMap<>();
        map.put("${name1}", "你好");
        map.put("${job2}", "哈哈");
        map.put("${date3}", "java开发");
        // 正则匹配 ${xx}
        Pattern regex = Pattern.compile("\\$\\{(.*?)\\}");

        // 占位符可能匹配的次数
        int count = value.split("\\$\\{").length - 1;
        System.out.println("占位符可能匹配的次数:" + count);
        for (int i = 0; i < count; i++) {
            Matcher matcher = regex.matcher(value);
            boolean flag = matcher.find();
            if (!flag) {
                // 没有匹配到，结束
                break;
            }

            String key = matcher.group(0);// 取得匹配到的 ${xxx}
            if (map.containsKey(key)) {
                value = value.replace(key, map.get(key));
            }
            System.out.println("第" + i + "次值：" + value);
        }
    }
}