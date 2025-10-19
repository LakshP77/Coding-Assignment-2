import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionDriver{
    public static void main(String[] args) {
        // handle missng arguments
        if(args.length < 1) {
            System.out.println("Usage: java FractionDriver <filename>");
            System.exit(1);
        }

        ArrayList<FractionCounter> counters = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(args[0]))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("/");
                int num = Integer.parseInt(parts[0]);
                int den = Integer.parseInt(parts[1]);
                Fraction newFraction = new Fraction(num, den);
                
                boolean found = false;
                for (FractionCounter fc : counters) {
                    if (fc.compareAndIncrement(newFraction)) {
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    counters.add(new FractionCounter(newFraction));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + args[0]);
        }

        for (FractionCounter fc : counters) {
            System.out.println(fc);
        }
    }
}