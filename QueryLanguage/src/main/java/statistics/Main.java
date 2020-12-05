package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";
        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        QueryBuilder query = new QueryBuilder();
        // System.out.println("Has at least 5 goals, assists and plays in PHI:");
          
        // Matcher m1 = new And( new HasAtLeast(5, "goals"),
        //                      new HasAtLeast(5, "assists"),
        //                      new PlaysIn("PHI")
        // );
 
       

        // for (Player player : stats.matches(m1)) {
        //     System.out.println(player);
        // }
        // System.out.println("");
        // System.out.println("Has at less than 1 goals, assists and plays in NYR:"); 

        // Matcher m2 = new And( 
        //     new HasFewerThan(1, "goals"), 
        //     new PlaysIn("NYR")
        // );

        // for (Player player : stats.matches(m2)) {
        //     System.out.println(player);
        // }        

        // System.out.println("");
        // System.out.println("Another try:"); 

        // Matcher m3 = new And( 
        //     new Not( new HasAtLeast(1, "goals") ), 
        //     new PlaysIn("NYR")
        // );
        // for (Player player : stats.matches(m3)) {
        //     System.out.println(player);
        // }         

        // System.out.println("");
        // System.out.println("Print all:");         
        // System.out.println(stats.matches(new All()).size());


        // Matcher m4 = new Or( new HasAtLeast(40, "goals"),
        //             new HasAtLeast(60, "assists")
        // );  
        // System.out.println("");
        // System.out.println("Has at least 40 goals OR 60 assists:");         
        // for (Player player : stats.matches(m4)) {
        //     System.out.println(player);
        // }


        // Matcher m5 = new And(
        //     new HasAtLeast(50, "points"),
        //     new Or( 
        //         new PlaysIn("NYR"),
        //         new PlaysIn("NYI"),
        //         new PlaysIn("BOS")
        //     )
        // );
        // System.out.println("");
        // System.out.println("Has at least 50 points AND plays in NYT OR NYI OR BOS:");         
        // for (Player player : stats.matches(m5)) {
        //     System.out.println(player);
        // }        
    

        // System.out.println("");
        // System.out.println("Print all qith QueryBuilder:");         

        // Matcher m6 = query.build();
    
        // for (Player player : stats.matches(m6)) {
        //     System.out.println( player );
        // }

        // System.out.println("");
        // System.out.println("Print NYR-players with QueryBuilder:");
        // Matcher m7 = query.playsIn("NYR").build();
 
        // for (Player player : stats.matches(m7)) {
        //     System.out.println( player );
        // }

        // System.out.println("");
        // System.out.println("Print NYR-players with 5-9 goals with QueryBuilder:");        
        // Matcher m8 = query.playsIn("NYR")
        //                 .hasAtLeast(5, "goals")
        //                 .hasFewerThan(10, "goals").build();

        // for (Player player : stats.matches(m8)) {
        //     System.out.println( player );
        // }

        // System.out.println("");
        // System.out.println("Print NYR-players with 5-9 goals with OR with 40 points with QueryBuilder:");  
        // Matcher m9 = query.playsIn("PHI")
        //           .hasAtLeast(10, "assists")
        //           .hasFewerThan(5, "goals").build();
        
        // Matcher m10 = query.playsIn("EDM")
        //           .hasAtLeast(40, "points").build();
        
        // Matcher m11 = query.oneOf(m9, m10).build();
        
        // for (Player player : stats.matches(m11)) {
        //     System.out.println( player );
        // }

        Matcher m12 = query.oneOf(
            query.playsIn("EDM")
                .hasAtLeast(40, "points").build(),
            query.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(5, "goals").build()

        ).build();

        for (Player player : stats.matches(m12)) {
            System.out.println( player );
        }
    }
}
