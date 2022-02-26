package ca.bytetube.day11_static;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {//compare用来写比较规则
        //如果用 参数1的值 - 参数2的值 < 0 ---> 升序排 (1,2,3,4,5)
        //如果用 参数1的值 - 参数2的值 > 0 ---> 降序排 (5,4,3,2,1)
        return s2.getAge() - s1.getAge();

    }
}
