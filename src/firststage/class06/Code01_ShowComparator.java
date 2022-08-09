package firststage.class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Code01_ShowComparator {

    public static class Student {
        String name;
        int id;
        int age;
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
        public String toString() {
            return "{name:" + name + " id:" + id + " age:" + age + "}";
        }
    }

    // 自定义id比较器 预期id小的放在前面
    public static class IdComparator implements Comparator<Student> {
        // 如果返回负数 表示第一个参数应该排到前面
        // 如果返回正数 表示第二个参数应该排到前面
        // 如果返回0 表示第一个参数和第二个参数相等
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.id < o2.id) {
                return -1;
            }else if(o2.id < o1.id) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    // 自定义age比较器 预期age小的放在前面
    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.age < o2.age) {
                return -1;
            }else if(o2.age < o1.age) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("张六", 3, 9);
        Student s5 = new Student("赫七", 2, 34);

        Student[] students = {s1, s2, s3, s4, s5};

        Arrays.sort(students, new AgeComparator());
        printStudents(students);

        ArrayList<Student> array = new ArrayList<>();
        array.add(new Student("张三", 5, 27));
        array.add(new Student("李四", 1, 17));
        array.add(new Student("王五", 4, 29));
        array.add(new Student("张六", 3, 9));
        array.add(new Student("赫七", 2, 34));
        array.sort(new IdComparator());

    }
}
