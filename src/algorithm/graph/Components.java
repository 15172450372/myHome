package algorithm.graph;

/**
 * @Author: zhouwei
 * @Description: 求无权图的联通分量
 * @Date: 2019/7/26 14:54
 * @Version: 1.0
 **/
public class Components {

    Graph G;                    // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    public Components(Graph graph) {
        G = graph;
        ccount = 0;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        for (int i=0; i<G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        for (int i=0; i<G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount ++;
            }
        }
    }

    // 图的深度优先遍历
    void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for( int i: G.adj(v) ) {
            if( !visited[i] ) {
                dfs(i);
            }
        }
    }

}
