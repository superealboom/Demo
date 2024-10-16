package cn.afuo.example.predicate;

/**
 * @description: 学生年龄断言
 * @author: tianci
 * @date: 2024/3/11 18:12
 */
public class StudentAgePredicate implements StudentPredicate {
    @Override
    public boolean test(Student student) {
        return student != null && student.getAge() != null && student.getAge().equals(28);
    }

    public String predicateName() {
        return "筛选学生年龄";
    }
}
