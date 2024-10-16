package cn.afuo.example.predicate;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: 学生姓名断言
 * @author: tianci
 * @date: 2024/3/11 18:10
 */
public class StudentNamePredicate implements StudentPredicate {
    @Override
    public boolean test(Student student) {
        return student != null && StringUtils.isNotBlank(student.getName()) && student.getName().equals("tianci");
    }

    @Override
    public String predicateName() {
        return "筛选学生姓名";
    }
}
