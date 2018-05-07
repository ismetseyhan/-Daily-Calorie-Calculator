import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class People {

    private int Id;
    private String Name;
    private String Gender;
    private int Weight;
    private int Height;
    private int Date;
    private int AlinanKalori;
    private int VerilenKalori;
    private int Gunlukihtiyac;

    public People(int id, String name, String gender, int weight, int height, int date, int alinanKalori, int verilenKalori, int gunlukihtiyac) {
        Id = id;
        Name = name;
        Gender = gender;
        Weight = weight;
        Height = height;
        Date = date;
        AlinanKalori = alinanKalori;
        VerilenKalori = verilenKalori;
        Gunlukihtiyac = gunlukihtiyac;
    }

    public static int sayac = 0;
    public static People[] list = new People[50];

    public static void read() {
        try {
            File file = new File("people.txt");
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);

            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                int part0 = Integer.parseInt(parts[0]);
                String part1 = parts[1];
                String part2 = parts[2];
                int part3 = Integer.parseInt(parts[3]);
                int part4 = Integer.parseInt(parts[4]);
                int part5 = Integer.parseInt(parts[5]);
                int part6 = gunlukihtiyac(part2, part3, part4, part5);
                list[i] = new People(part0, part1, part2, part3, part4, part5, 0, 0, part6);
                sayac++;
                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int gunlukihtiyac(String gender, int kg, int cm, int age) {
        double sonuc1;
        int sonuc;
        age = 2018 - age;
        if (gender.equals("male")) {
            sonuc1 = (66 + ((13.75 * kg) + (5 * cm))) - (6.8 * age);

        } else {
            sonuc1 = (665 + ((9.6 * kg) + (1.7 * cm))) - (4.7 * age);
        }
        sonuc = (int) Math.round(sonuc1);
        return (int) sonuc;
    }

    public static void persondetail(int id) {
        int i;
        for (i = 0; i < People.sayac; i++) {
            if (id == list[i].getId()) {
                int total = (People.list[i].AlinanKalori) - (People.list[i].VerilenKalori) - People.list[i].Gunlukihtiyac;
                System.out.println(People.list[i].getName() + " " + (2018 - People.list[i].Date) + " " + People.list[i].Gunlukihtiyac + "kcal" + " " + People.list[i].AlinanKalori + "kcal" + " " + People.list[i].VerilenKalori + "kcal" + " " + total + "kcal");
                Commands.write2(People.list[i].getName() + " " + (2018 - People.list[i].Date) + " " + People.list[i].Gunlukihtiyac + "kcal" + " " + People.list[i].AlinanKalori + "kcal" + " " + People.list[i].VerilenKalori + "kcal" + " " + total + "kcal" + "\n");

            }
        }
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public int getWeight() {
        return Weight;
    }

    public int getHeight() {
        return Height;
    }

    public int getDate() {
        return Date;
    }

    public int getGunlukihtiyac() {
        return Gunlukihtiyac;
    }

    public void setGunlukihtiyac(int gunlukihtiyac) {
        this.Gunlukihtiyac = gunlukihtiyac;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getAlinanKalori() {
        return AlinanKalori;
    }

    public void setAlinanKalori(int alinanKalori) {
        AlinanKalori = alinanKalori;
    }

    public int getVerilenKalori() {
        return VerilenKalori;
    }

    public void setVerilenKalori(int verilenKalori) {
        VerilenKalori = verilenKalori;
    }
}
