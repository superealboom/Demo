package cn.afuo.example.predicate;

/**
 * @description: 学生断言接口
 * @author: tianci
 * @date: 2024/3/11 18:06
 */
public interface StudentPredicate {

    boolean test(Student student);

    String predicateName();

}
