import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> l = new ArrayList<>();
        ArrayList<String> was = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder queue = new StringBuilder();
            String command = sc.nextLine();
            String[] com = command.split(" ");
            if (command.startsWith("Добавить")) {
                l.add(com[1]);
                System.out.println(com[1] + " в очереди");
            }
            if (command.equals("Следующий!")) {
                if (l.size() > 0) {
                    was.add(l.get(0));
                    System.out.println(l.remove(0) + " в обработке");
                } else {
                    System.out.println("Отлично, попью чаёк!");
                }
            }
            if (command.startsWith("Посмотреть")) {
                if (l.size() == 0) {
                    System.out.println("*прокатилось перекати-поле*");
                } else {
                    for (String u : l) queue.append(u).append(" ");
                    String j = queue.toString();
                    System.out.println(j.trim());
                }
            }
            if (command.startsWith("Стоит")) {
                if (l.size() < 5) {
                    l.add(com[4]);
                } else {
                    System.out.println("Слабак!");
                }
            }
            if (command.contains("занимал")) {
                if (!l.contains(com[3])) {
                    if(was.contains(com[3])) l.add(0,com[0]);
                    l.add(com[0]);
                    System.out.println(com[0] + ", не надо тут ля-ля");
                }
                else {
                    l.add(l.indexOf(com[3]) + 1, com[0]);
                }
            }

        }
    }
}
