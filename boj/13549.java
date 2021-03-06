import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// deque를 이용

public class Main {

    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];

        // deque를 사용하면 큐를 두개 사용안해도 된다.
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(n);
        dist[n] = 0;
        check[n] = true;

        while (!q.isEmpty()) {
            int now = q.pollFirst();

            if(now * 2 < MAX){
                if(check[now * 2] == false){
                    q.offerFirst(now * 2);
                    dist[now * 2] = dist[now];
                    check[now * 2] = true;
                }
            }

            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    q.offerLast(now - 1);
                    dist[now - 1] = dist[now] + 1;
                    check[now - 1] = true;
                }
            }

            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    q.offerLast(now + 1);
                    dist[now + 1] = dist[now] + 1;
                    check[now + 1] = true;
                }
            }
        }

        System.out.println(dist[k]);
    }
}

/////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];

        Queue<Integer> q1 = new LinkedList<>(); // 0 second
        Queue<Integer> q2 = new LinkedList<>(); // 1 second

        q1.offer(n);
        check[n] = true;
        dist[n] = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now * 2 < MAX) {
                if (check[now * 2] == false) {
                    check[now * 2] = true;
                    q1.add(now * 2);
                    dist[now * 2] = dist[now];
                }
            }

            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    check[now - 1] = true;
                    q2.add(now - 1);
                    dist[now - 1] = dist[now] + 1;
                }
            }

            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    check[now + 1] = true;
                    q2.add(now + 1);
                    dist[now + 1] = dist[now] + 1;
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        System.out.println(dist[k]);
    }
}

/////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        boolean[] check = new boolean[MAX];

        Queue<Integer> q1 = new LinkedList<>(); // 0 second
        Queue<Integer> q2 = new LinkedList<>(); // 1 second

        q1.offer(n);
        check[n] = true;
        dist[n] = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (check[next] == false) {
                        check[next] = true;
                        if (now*2 == next) {
                            q1.add(next);
                            dist[next] = dist[now];
                        } else {
                            q2.add(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        System.out.println(dist[k]);
    }
}
