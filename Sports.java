import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Sports {
    private int ID;
    private String NAME;
    private int CAL;

    public Sports(int id, String name, int cal) {
        ID = id;
        NAME = name;
        CAL = cal;
    }

    public static Sports[] list = new Sports[100];
    public static int sayac = 0;

    public static void read() {
        try {
            File file = new File("sport.txt");
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                int part0 = Integer.parseInt(parts[0]);
                String part1 = parts[1];
                int part2 = Integer.parseInt(parts[2]);
                list[i] = new Sports(part0, part1, part2);
                i++;
                sayac++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to open file");
        }
    }

    public static int kalorihesap(int yapanid, int id, int sure) {
        double verilenkal1 = 0;
        int verilenkal = 0;
        String name = "x";
        int i;
        for (i = 0; i < sayac; i++) {
            if (list[i].getID() == id) {
                int x = list[i].getCAL();
                name = list[i].getNAME();
                verilenkal1 = (sure * x) / 60;
                verilenkal = (int) Math.round(verilenkal1);
            }
        }
        System.out.println(yapanid + " " + "has" + " " + "burned" + " " + verilenkal + "kcal" + " " + "thanks to" + " " + name);
        Commands.write2(yapanid + " " + "has" + " " + "burned" + " " + verilenkal + "kcal" + " " + "thanks to" + " " + name + "\n");
        return verilenkal;
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
