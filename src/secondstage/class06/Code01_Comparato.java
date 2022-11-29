package secondstage.class06;

import java.util.Arrays;
import java.util.Comparator;

/*
*   比较器的本质就是重载运算符
* */
public class Code01_Comparato {
    public static class Student {
        public String name;
        public int id;
        public int age;
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }

    public static void printStudents(Student... students) {
        if(students == null || students.length == 0) {
            return;
        }
        for (Student student: students) {
            System.out.println(student.toString());
        }
    }

    /*
    *   比较器规则
    *   返回复数 认为第一个参数放在前面
    *   返回正数 认为第二个参数放在前面
    *   返回0 认为那个参数放在前面都行
    * */
    public static class AgeDescCompare implements Comparator<Student> {
        // 年龄降序排列
        @Override
        public int compare(Student o1, Student o2) {
//            if(o2.age > o1.age) {
//                return -1;
//            }else if(o2.age < o1.age) {
//                return 1;
//            }else {
//                return 0;
//            }
            // 简化写法
            return o2.age - o1.age;
        }
    }

    public static class IdAscCompare implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
//            if(o1.id < o2.id) {
//                return -1;
//            }else if(o1.id > o2.id) {
//                return 1;
//            }else {
//                return 0;
//            }
            // 简化写法
            return o1.id - o2.id;
        }
    }

    public static class IdAscAgeDescCompare implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return (o1.id != o2.id) ? (o1.id - o2.id) : (o2.age - o1.age);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 4, 22);
        Student[] students = new Student[]{student1, student2, student3};
        printStudents(students);
        System.out.println("=========================");
        Arrays.sort(students, new IdAscCompare());
        printStudents(students);
        System.out.println("=========================");
        Arrays.sort(students, new AgeDescCompare());
        printStudents(students);
        System.out.println("=========================");

        /*
        *   在treemap中如果两个元素相等就认为是重复的key
        *   重复的key不会添加
        * */

    }
}

















