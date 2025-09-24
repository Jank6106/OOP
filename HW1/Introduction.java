public class Introduction {
    public static void main(String[] args) {
        String name = "NguyenHuuDanh";
        int StudentId = 24020058;
        String Class = "K69I_IT4";
        String username = "Jank6106";
        String email = "24020058@vnu.edu.vn";
        String tab = "\t";
        System.out.println(name + tab + StudentId + tab + Class + tab + username + tab + email);

        String s1 = " bottles of beer on the wall, ";
        String s2 = " bottles of beer.";
        String s3 = "Take one down, pass it around,";
        String s4 = "No more bottles of beer on the wall.";
        for (int i = 9; i >= 1; i--) {
            if (i == 1) {
                System.out.println(i + s1 + i + s2);
                System.out.println(s3);
                System.out.println(s4);
            } else {
                System.out.println(i + s1 + i + s2);
                System.out.println(s3);
            }
        }
    }
}
