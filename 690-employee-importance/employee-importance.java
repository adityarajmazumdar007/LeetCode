class Solution {
    private Map<Integer, Employee> employeeMap; 
    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        employeeMap = new HashMap<>();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }

        // 3. Initial Call & 4. Return
        return dfs(id);
    }

    private int dfs(int currentId) {

        Employee currentEmployee = employeeMap.get(currentId);
        if (currentEmployee == null) {
            return 0;
        }

        // Start with the current employee's importance
        int currentTotalImportance = currentEmployee.importance;

        // Recursively add importance of all subordinates
        if (currentEmployee.subordinates != null) {
            for (int subordinateId : currentEmployee.subordinates) {
                currentTotalImportance += dfs(subordinateId);
            }
        }

        return currentTotalImportance;
    }
}