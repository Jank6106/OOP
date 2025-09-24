public class Distance {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        float result = (float) Math.sqrt(x * x + y * y);
        System.out.println(result);
    }
}
