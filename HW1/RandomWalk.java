import edu.princeton.cs.algs4.*;

public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5); // Scale;
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int stepSize = 1; // số bước cho mỗi lượt
        int director = 0; // đổi hướng
        int count = 0;
        // draw the first square
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();

        while (Math.abs(x) < n && Math.abs(y) < n) {
            for (int i = 0; i < stepSize; i++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);

                switch (director) {
                    case(0) -> x--;
                    case(1) -> y++;
                    case(2) -> x++;
                    case(3) -> y--;
                }
                steps++;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show();
                StdDraw.pause(40); // pause giữa mỗi lần vẽ

                if (Math.abs(x) > n || Math.abs(y) >n) {
                    StdOut.println("Total steps = " + steps);
                    return;
                }
            }
            director = (director + 1) % 4;
            count++;
            if (count % 2 == 0) {
                stepSize++;
            }
        }

    }

}