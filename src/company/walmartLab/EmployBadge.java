package company.walmartLab;

import java.util.*;

public class EmployBadge {
    public static void main(String[] args) {
        String[][] records = new String[][]{{"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"}};
        String[][] records2 = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}};
        String[][] records3 = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}, {"Paul", "exit"}, {"Paul", "enter"}};
        String[][] records4 = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}, {"Paul", "exit"}, {"Paul", "enter"}};
        List<Set<String>> res = badgeRecord(records4);

    }

    private static List<Set<String>> badgeRecord(String[][] records) {
        Set<String> enterIssue = new HashSet<>();
        Set<String> exitIssue = new HashSet<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String[] record : records) {
            String name = record[0];
            String action = record[1];
            List<String> list = map.getOrDefault(name, new ArrayList<>());
            if (list.size() == 0) {
                if (action.equals("exit")) {
                    enterIssue.add(name);
                }
            } else {
                String lastAction = list.get(list.size() - 1);
                if (lastAction.equals("enter") && action.equals("enter")) {
                    exitIssue.add(name);
                }
                if (lastAction.equals("exit") && action.equals("exit")) {
                    enterIssue.add(name);
                }
            }
            list.add(action);
            map.put(name, list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> actions = entry.getValue();
            if (actions.get(actions.size() - 1).equals("enter")) {
                exitIssue.add(name);
            }
        }

        List<Set<String>> res = new ArrayList<>();
        res.add(enterIssue);
        res.add(exitIssue);

        return res;
    }
}
