package Labs.Lab13;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab13 {
    public static void processFile(File inputFile, File outputFile) throws FileNotFoundException{
        Team team;
        Team minTeam = null;
        Team maxTeam = null;
        double totalShots = 0;
        int numTeams = 0;
        String line;

        Scanner scr = new Scanner(inputFile);
        PrintWriter prt = new PrintWriter(outputFile);

        while(scr.hasNextLine()){
            line = scr.nextLine();
            String[] fields = line.split(",");

            team = new Team(fields[0], Integer.parseInt(fields[1]), Double.parseDouble(fields[2]));

            if(minTeam == null || minTeam.getNumGoals() > team.getNumGoals()){
                minTeam = team;
            }

            if(maxTeam == null || maxTeam.getNumGoals() < team.getNumGoals()){
                maxTeam = team;
            }
            numTeams++;
            totalShots += team.getNumShots();
        }

        scr.close();

        if(numTeams > 0){
            prt.println("Maximum goals Scored: " + maxTeam.getName() + " " + maxTeam.getNumGoals());
            prt.println("Minimum goals Scored: " + minTeam.getName() + " " + minTeam.getNumGoals());
            prt.printf("Average shots per game: %.3f", (totalShots/numTeams));
        }

        prt.close();
    }

    public static void main(String[] args){
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try{
            processFile(inputFile, outputFile);
        } catch (FileNotFoundException e){
            System.out.println("Unable to open file(s)");
        }
    }
}
