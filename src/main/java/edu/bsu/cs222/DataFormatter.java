package edu.bsu.cs222;

public class DataFormatter {

    public String formatRank(String s) {
        int rank = Integer.parseInt(s);
        if (rank > 3999){
            return "Grandmaster";
        }
        else if (rank > 3499){
            return "Master";
        }
        else if (rank > 2999){
            return "Diamond";
        }
        else if (rank > 2499){
            return "Platinum";
        }
        else if (rank > 1999){
            return "Gold";
        }
        else if (rank > 1499){
            return "Silver";
        }
        else{
            return "Bronze";
        }
    }
}
