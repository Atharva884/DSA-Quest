/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> impMap = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            int empId = emp.id;
            int imp = emp.importance;
            List<Integer> ids = emp.subordinates;

            map.put(empId, ids);
            impMap.put(empId, imp);
        }

        int ans = impMap.get(id);

        Queue<Integer> q = new LinkedList<>();
        List<Integer> subIdss = map.get(id);
        for (int i : subIdss) {
            q.add(i);
        }

        while (q.size() != 0) {
            int subId = q.poll();

            ans += impMap.get(subId);

            List<Integer> nbrs = map.get(subId);
            for (int nbr : nbrs) {
                q.add(nbr);
            }
        }

        return ans;
    }
}