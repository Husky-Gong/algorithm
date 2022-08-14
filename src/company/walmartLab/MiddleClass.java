package company.walmartLab;

import java.util.*;

public class MiddleClass {
    public static void main(String[] args) {
        String[][] courses = new String[][]{
                                    {"Foundations of Computer Science", "Operating Systems"},
                                    {"Data Structures", "Algorithms"},
                                    {"Computer Networks", "Computer Architecture"},
                                    {"Algorithms", "Foundations of Computer Science"},
                                    {"Computer Architecture", "Data Structures"},
                                    {"Software Design", "Computer Networks"}};
        String res = getMiddleClass(courses);
        System.out.println(res);

        String[][] courses2 = new String[][]{
                {"Algorithms", "Foundations of Computer Science"},
                {"Data Structures", "Algorithms"},
                {"Foundations of Computer Science", "Logic"},
                {"Logic", "Compilers"},
                {"Compilers", "Distributed Systems"}};
        String res2 = getMiddleClass(courses2);
        System.out.println(res2);

        String[][] courses3 = new String[][]{
                {"Data Structures", "Algorithms"}};
        String res3 = getMiddleClass(courses3);
        System.out.println(res3);
    }

    private static String getMiddleClass(String[][] courses) {
        // 找出没有parent的那个class -->  即为第一个要开始的课程
        Set<String> parentSet = new HashSet<>();
        Set<String> childSet = new HashSet<>();
        Map<String, String> classMap = new HashMap<>();

        // 构建map以及找出enter class
        for (String[] course : courses) {
            String parent = course[0];
            String child = course[1];

            parentSet.add(parent);
            childSet.add(child);

            classMap.put(parent, child);
        }
        String enter = "";
        for (String parent : parentSet) {
            if (!childSet.contains(parent)) {
                enter = parent;
            }
        }
        if (enter.length() == 0) return null;

        List<String> list = new ArrayList<>();
        list.add(enter);
        while (enter != null && classMap.containsKey(enter)) {
            list.add(classMap.get(enter));
            enter = classMap.get(enter);
        }

        if (list.size() % 2 == 0) {
            return list.get(list.size()/2 - 1);
        } else {
            return list.get(list.size() / 2);
        }
    }
}
