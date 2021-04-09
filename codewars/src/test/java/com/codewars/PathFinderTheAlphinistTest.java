package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.runners.JUnit4;

public class PathFinderTheAlphinistTest {
    @Test
    public void sampleTests() {

        String a = "000\n" + "000\n" + "000",

                b = "010\n" + "010\n" + "010",

                c = "010\n" + "101\n" + "010",

                d = "0707\n" + "7070\n" + "0707\n" + "7070",

                e = "700000\n" + "077770\n" + "077770\n" + "077770\n" + "077770\n" + "000007",

                f = "777000\n" + "007000\n" + "007000\n" + "007000\n" + "007000\n" + "007777",

                g = "000000\n" + "000000\n" + "000000\n" + "000010\n" + "000109\n" + "001010";

        assertEquals(0, PathFinderTheAlphinist.pathFinder(a));
        assertEquals(2, PathFinderTheAlphinist.pathFinder(b));
        assertEquals(4, PathFinderTheAlphinist.pathFinder(c));
        assertEquals(42, PathFinderTheAlphinist.pathFinder(d));
        assertEquals(14, PathFinderTheAlphinist.pathFinder(e));
        assertEquals(0, PathFinderTheAlphinist.pathFinder(f));
        assertEquals(4, PathFinderTheAlphinist.pathFinder(g));
    }

    @Test
    public void randomTest() {
        // int N = new Random().nextInt(5) + 1;
        int N = 6;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(new Random().nextInt(10));
            }
            sb.append("\n");
        }
        System.out.println(Arrays.stream(sb.toString().split("\n"))
                .map(item -> Arrays.stream(item.split("")).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")));
        int result = PathFinderTheAlphinist.pathFinder(sb.toString());
        System.out.println(result);
        // 8 2 9 8 6 7
        // 9 4 7 7 4 6
        // 1 5 6 1 3 3
        // 4 0 1 0 0 7
        // 9 4 2 2 2 4
        // 7 7 0 3 3 5

        // 8 9 4 5 6 1 2 2 2 4 5
        //  1  5 1 1 5 1    2 3 = 

    }

    @Test
    public void sampleTest2() {
        String a = String.join("\n", "747062171", "904866986", "340268947", "974542098", "574036106", "567149757",
                "726658263", "848862682", "755104617");

        System.out.println(
                Arrays.stream(a.split("\n")).map(item -> Arrays.stream(item.split("")).collect(Collectors.joining(" ")))
                        .collect(Collectors.joining("\n")));
        int expected = 34;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest3() {
        String a = String.join("\n", "027333993869398", "254479132779620", "330917081313786", "739481383462111",
                "848988331056760", "987401845791422", "470338001073749", "514792569030599", "687191352427816",
                "923700827906919", "143147919485312", "430146698310429", "437544138556172", "346967355374676",
                "313306314438825");
        int expected = 43;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest4() {
        String a = String.join("\n", "85090803979", "41936939999", "62406103935", "75718971156", "29379392373",
                "59318822429", "80561017488", "39240317945", "58805636930", "95042989217", "61751221609");

        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 47;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest5() {
        String a = String.join("\n", "499997418008297", "903063267622811", "264580757805411", "215365587838595",
                "064148700941453", "714383177016660", "474819618106072", "859157273873741", "098525230497228",
                "073120146861511", "976649825671164", "331653265550204", "145551854130954", "658381118820222",
                "765526746646576");

        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 42;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest6() {
        String a = String.join("\n", "9104054487", "3539122225", "1322195171", "5779815396", "3293875825", "7676493181",
                "2703354359", "3952741883", "3401526482", "7769465756");

        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).map(s -> "   " + s).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 29;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest7() {
        String a = "001292984" + "\n966310225" + "\n643605385" + "\n283388646" + "\n697515334" + "\n744725566"
                + "\n112679120" + "\n167524177" + "\n897859289";

        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).map(s -> "   " + s).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 27;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void sampleTest8() {
        String a = "167585" + "\n998916" + "\n466211" + "\n783984" + "\n878989" + "\n582582";
        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).map(s -> "   " + s).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 21;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);

        // 1	   6	   7	   5	   8	   5
        // 9	   9	   8	   9	   1	   6
        // 4	   6	   6	   2	   1	   1
        // 7	   8	   3	   9	   8	   4
        // 8	   7	   8	   9	   8	   9
        // 5	   8	   2	   5	   8	   2

        //     0	    5	    6	    8	   11	   14	 
        //     8	    8	    7	    8	   14	   15	 
        //    13	    9	    9	   13	   14	   14	 
        //    14	   13	   12	   16	   17	   17	 
        //    15	   14	   15	   16	   17	   18	 
        //    18	   15	   21	   20	   17	   23	 

    }

    @Test
    public void sampleTest9() {
        String a = "802911\n" + "294296\n" + "791917\n" + "710617\n" + "287112\n" + "426515";
        System.out.println(Arrays.stream(a.split("\n"))
                .map(item -> Arrays.stream(item.split("")).map(s -> "   " + s).collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n")));

        int expected = 31;
        int result = PathFinderTheAlphinist.pathFinder(a);
        System.out.printf("expected:<%d>\n", expected);
        System.out.printf("actual:<%d>\n", result);
        assertEquals(expected, result);
        // *8	   *0	   *2	   9	   1	   1
        // 2	   9	   *4	   2	   9	   6
        // 7	   9	   *1	   9	   1	   7
        // 7	   1	   *0	   *6	   *1	   7
        // 2	   8	   7	   1	   *1	   2
        // 4	   2	   6	   5	   *1	   *5

        //  0	    8	   10	   27	   35	   41	 
        //  6	   13	   18	   20	   27	   30	 
        // 11	   13	   21	   27	   29	   35	 
        // 11	   17	   18	   28	   29	   35	 
        // 16	   22	   23	   29	   29	   30	 
        // 18	   20	   24	   25	   29	   33
    }
}