import java.util.*;
class maior {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int obj = sc.nextInt();
        String buffer = "";
        int fim = -1;
        for (int i = n; i < m; i++) {
            if (i >= 10 && i < 100) {
                buffer = Integer.toString(i);
                String st1 = "";
                String st2 = "";
                st1 += buffer.charAt(0);
                st2 += buffer.charAt(1);
                int t1 = Integer.parseInt(st1);
                int t2 = Integer.parseInt(st2);
                int resultado = t1 + t2;
                if (resultado == obj) {
                    fim = Integer.parseInt(buffer);
                }
            } else if(i >= 10 && i < 1000){
                buffer = Integer.toString(i);
                String st1 = "";
                String st2 = "";
                String st3 = "";
                st1 += buffer.charAt(0);
                st2 += buffer.charAt(1);
                st3 += buffer.charAt(2);
                int t1 = Integer.parseInt(st1);
                int t2 = Integer.parseInt(st2);
                int t3 = Integer.parseInt(st3);
                int resultado = t1 + t2 + t3;
                if (resultado == obj) {
                    fim = Integer.parseInt(buffer);
                }
            } else if(i >= 10 && i < 10000){
                buffer = Integer.toString(i);
                String st1 = "";
                String st2 = "";
                String st3 = "";
                String st4 = "";
                st1 += buffer.charAt(0);
                st2 += buffer.charAt(1);
                st3 += buffer.charAt(2);
                st4 += buffer.charAt(3);
                int t1 = Integer.parseInt(st1);
                int t2 = Integer.parseInt(st2);
                int t3 = Integer.parseInt(st3);
                int t4 = Integer.parseInt(st4);
                int resultado = t1 + t2 + t3 + t4;
                if (resultado == obj) {
                    fim = Integer.parseInt(buffer);
                }
            }
            else if(i >= 10 && i < 100000){
                buffer = Integer.toString(i);
                String st1 = "";
                String st2 = "";
                String st3 = "";
                String st4 = "";
                String st5 = "";
                st1 += buffer.charAt(0);
                st2 += buffer.charAt(1);
                st3 += buffer.charAt(2);
                st4 += buffer.charAt(3);
                st5 += buffer.charAt(4);
                int t1 = Integer.parseInt(st1);
                int t2 = Integer.parseInt(st2);
                int t3 = Integer.parseInt(st3);
                int t4 = Integer.parseInt(st4);
                int t5 = Integer.parseInt(st5);
                int resultado = t1 + t2 + t3 + t4+ t5;
                if (resultado == obj) {
                    fim = Integer.parseInt(buffer);
                }
            }
        }
        System.out.println(fim);
    }
}
