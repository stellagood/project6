import javax.swing.*;

public class Algorithm {
    int len;
    int[] distance = new int[len];

    int minmum(boolean[] visit){
        int min = Integer.MAX_VALUE;
        int min_index=0;
        for(int i=0; i<len; i+=1){
            if (visit[i] == false && distance[i]<min){
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }



    void name(int[][] graph, int start){
        len = graph.length;
        int[] distance = new int[len];
        this.distance = distance;
        boolean[] visit = new boolean[len];

        for (int i=0; i<len; i+=1) {
            distance[i] = Integer.MAX_VALUE;
            visit[i] = false;
        }

        distance[start] = 0;
        for(int i=0; i<len; i+=1){
            int now = minmum(visit);

            visit[now]= true;

            for (int j=0; j<len; j++)
            {
                if (visit[j] == false && graph[now][j] != 0 && distance[j] > distance[now] + graph[now][j]){
                    distance[j] = distance[now] + graph[now][j];
                }
            }
        }
    }
    void print(){
        System.out.println("Index:    Distance:");
        for(int i=0;i<len; i+=1){
            System.out.println(i+"\t\t\t" + distance[i]);
        }
    }
}
