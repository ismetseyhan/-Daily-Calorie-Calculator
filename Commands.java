import java.io.*;


public class Commands {
    public static void write2(String word) {
        try {
            File dosya = new File("monitoring.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write(word);
            yaz.close();
        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

    public static void delete() {
        try {
            File sil = new File("monitoring.txt");
            sil.delete();
        } catch (Exception hata) {
            int z = 5;
        }

    }

    public static void read(String file1) {
        try {

            File file = new File(file1);
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i != 0) {
                    System.out.println("***************");
                    Commands.write2("***************\n");
                }
                i++;
                String[] parts = line.split("\t");
                if ((parts.length) == 3) {
                    int yapanid = Integer.parseInt(parts[0]);
                    int yapilanis = Integer.parseInt(parts[1]);
                    int porsiyon = Integer.parseInt(parts[2]);
                    int j;

                    for (j = 0; j < People.sayac; j++) {
                        if (yapanid == People.list[j].getId()) {
                            if (yapilanis >= 1000 && yapilanis < 2000) {
                                int newkalori = Foods.kalorihesap(yapanid, yapilanis, porsiyon);
                                People.list[j].setAlinanKalori(newkalori + People.list[j].getAlinanKalori());

                            } else if (yapilanis >= 2000) {
                                int yakilankal = Sports.kalorihesap(yapanid, yapilanis, porsiyon);
                                People.list[j].setVerilenKalori(yakilankal + People.list[j].getVerilenKalori());
                            }
                        }
                    }
                } else if ((parts.length) == 1) {
                    String kelime = parts[0];
                    if ((kelime.length()) == 9) {
                        int k;
                        for (k = 0; k < People.sayac; k++) {
                            if ((People.list[k].getVerilenKalori() != 0) || (People.list[k].getAlinanKalori() != 0)) {
                                People.persondetail(People.list[k].getId());
                            }
                        }
                    } else if ((kelime.length()) == 12) {
                        String split = kelime.substring(6, 11);
                        int split1 = Integer.parseInt(split);
                        People.persondetail(split1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to open file");
        }
    }
}
