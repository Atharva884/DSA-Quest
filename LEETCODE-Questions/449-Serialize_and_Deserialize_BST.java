/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void solve1(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("# ");
            return;
        }

        sb.append(root.val + " ");
        solve1(root.left, sb);
        solve1(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return sb.toString();
        }

        solve1(root, sb);
        System.out.println(sb.toString());

        return sb.toString();
    }


    public TreeNode solve2(String[] arr){
        if(arr[i].equals("#")){
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;

        root.left = solve2(arr);
        root.right = solve2(arr);

        return root;
    }

    int i;
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }

        String[] arr = data.split(" ");
        i=0;

        return solve2(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;