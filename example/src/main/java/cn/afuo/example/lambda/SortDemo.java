package cn.afuo.example.lambda;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: lambda排序
 * @author: tianci
 * @date: 2024/3/12 10:23
 */
@Slf4j
public class SortDemo {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("a","d","c","e","b");

        // 顺序
        nameList.sort(Comparator.naturalOrder());
        String naturalOrder = StringUtils.join(nameList, ",");

        log.info("naturalOrder顺序：{}", naturalOrder);

        // 顺序
        nameList.sort(String::compareTo);
        String compareToSort = StringUtils.join(nameList, ",");
        log.info("compareToSort顺序：{}", compareToSort);

        // 倒叙
        nameList.sort(Comparator.reverseOrder());
        String reverseOrder = StringUtils.join(nameList, ",");
        log.info("reverseOrder倒序：{}", reverseOrder);
    }

}
