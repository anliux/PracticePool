//38. 字符串的排列



//回溯：7 ms/91.38%; 46.4 MB/50.50%
class Solution {
    //初始化：结果列表res，字符数组c
    LinkedList<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        //转为字符数组；递归；返回结果
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x){
        //递归出口：走到最后一位时不再需要更换，将此时的字符数组按字符串返回保存
        if(x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }

        //初始化set容器过滤重复元素
        HashSet<Character> set = new HashSet<>();

        //遍历
        for(int i = x; i < c.length; i++){
            //判重复
            if(set.contains(c[i]))
                continue;
            set.add(c[i]);

            //交换并递归
            swap(i,x);
            dfs(x+1);
            //回溯复位
            swap(x,i);
        }
    }

    //交换索引对应的元素
    public void swap(int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
