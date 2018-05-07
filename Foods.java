import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Foods {
    private int ID;
    private String NAME;
    private int CAL;


    public Foods(int id, String name, int cal) {
        ID = id;
        NAME = name;
        CAL = cal;

    }

    public static Foods[] list = new Foods[100];
    public static int sayac = 0;

    public static void read() {
        try {
            File file = new File("food.txt");
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                int part0 = Integer.parseInt(parts[0]);
                String part1 = parts[1];
                int part2 = Integer.parseInt(parts[2]);
                list[i] = new Foods(part0, part1, part2);
                i++;
                sayac++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to open file");
        }
    }

    public static int kalorihesap(int yapanid, int id, int porsion) {
        int alinankal = 0;
        String name = "x";
        int i;
        for (i = 0; i < Foods.sayac; i++) {
            if (list[i].getID() == id) {
                int x = list[i].getCAL();
                name = list[i].getNAME();
                alinankal = porsion * x;

            }
        }
        System.out.println(yapanid + " " + "has" + " " + "taken" + " " + alinankal + "kcal" + " " + "from" + " " + name);
        Commands.write2(yapanid + " " + "has" + " " + "taken" + " " + alinankal + "kcal" + " " + "from" + " " + name + "\n");

        return alinankal;
    }


    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getCAL() {
        return CAL;
    }
}
