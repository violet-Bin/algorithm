package com.algorithm.code00;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 15:47 2019/2/22
 */
public class Code08Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[]{student3, student2, student1};
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

        //匿名函数->lambda表达式
        Arrays.sort(students, (o1, o2) -> o2.id - o1.id);
        printStudents(students);
        //方法引用
        Arrays.sort(students, Comparator.comparingInt(o -> o.id));
        printStudents(students);

        //优先级队列就是堆， 需要传入一个比较器作为比较规则
        PriorityQueue<Student> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.id));
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);

        while (!heap.isEmpty()) {
            Student student = heap.poll();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }

        // treeSet
        TreeSet<Student> treeSet = new TreeSet<>(Comparator.comparingInt(o -> o.id));
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        Iterator<Student> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }

    }


}
