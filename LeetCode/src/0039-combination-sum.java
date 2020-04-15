//0039-组合总和
//思路：回溯算法+深度优先遍历



//回溯算法：4ms，击败70.2%的用户
/*
- 分析：
    - 根据示例 1：输入: candidates = [2,3,6,7]，target = 7。
      - 候选数组里有 2 ，如果找到了 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
      - 同理考虑 3，如果找到了 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去；
      - 根据图示，得到路径[[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]，而示例中的解集只有 [[7], [2, 2, 3]]；
      - 重复的原因是在较深层的结点值考虑了之前考虑过的元素，因此我们需要设置“下一轮搜索的起点”即可（这里可能没有说清楚，已经尽力了）。
    - 去重复
      - 在搜索的时候，需要设置搜索起点的下标 begin ，由于一个数可以使用多次，下一层的结点从这个搜索起点开始搜索；
      - 在搜索起点 begin 之前的数因为以前的分支搜索过了，所以一定会产生重复。
    - 剪枝提速
      - 如果一个数位搜索起点都不能搜索到结果，那么比它还大的数肯定搜索不到结果，基于这个想法，我们可以对输入数组进行排序，以减少搜索的分支；
      - 排序是为了提高搜索速度，非必要；
      - 搜索问题一般复杂度较高，能剪枝就尽量需要剪枝。
      - 把候选数组排个序，遇到一个较大的数，如果以这个数为起点都搜索不到结果，后面的数就更搜索不到结果了。
  - 算法：
    - 主体函数+调用函数
    - 主体函数：新建二维结果数组res；对给定数组排序；调用dfs函数；返回结果数组res。
    - 调用函数：
      - 参数列表：给定数组candidates，除存入path元素之外的剩余目标值rest，开始位置索引值begin，本路径path，最终结果res
      - 首先：判断rest是否等于0，等于是即为找到一组，将结果存入res，并返回；
      - 循环遍历给定数组：首先判断rest是否小于数组元素，小于则break；然后将数组元素添加到path的后面之后调用dfs深度遍历；之后回溯，将path的last元素去掉重新遍历。
  - 知识点：
    - ArrayDeque：双向队列接口
      - addFirst(E e)：将指定元素插入此双端队列的开头。
      - addLast(E e)：将指定元素插入此双端队列的末尾。
      - removeLast()：获取并移除此双端队列的最后一个元素。
    - ArrayList：数组
      - 构造函数：ArrayList(Collection<? extends E> c)：
        - 构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
      - add(E e)：将指定的元素添加到此列表的尾部。
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        //排序可以提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayDeque<>(), res);

        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */

    private void dfs(int[] candidates,
                     int rest,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
                       
        //当叶子节点正好凑齐时，将path添加到结果列表res
        if (rest == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        //遍历数组：深度优先遍历，当rest小于遍历数组时终止循环
        for (int i = begin; i < candidates.length; i++) {

            // 在数组有序的前提下，剪枝
            if (rest < candidates[i]) {
                break;
            }

            path.addLast(candidates[i]);

            //控制开始节点为i
            dfs(candidates, rest - candidates[i], i, path, res);

            //path是公用的，上一步dfs无论什么结果，下一步都要回溯。
            //相当于中序遍历中，返回根，然后再走向下一个子节点。
            path.removeLast();

        }
    }
}
