import java.security.SecureRandom;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class RandomGenerator {
    public static void main(String[] args) {

        Options options = new Options();
        // -l --level
        options.addOption(Option.builder("l") // Option
                                    .longOpt("level") // Long Option Name
                                    .hasArg() // Required
                                    .argName("level") // Display Name

                                    .desc("randomization level (range: 1,2,3; default: 2)" +
                                        "\nlevel=1 => digit [0-9]" +
                                        "\nlevel=2 => alpha [a-zA-Z]" +
                                        "\nlevel=3 => alnum [0-9a-zA-Z]")
                                .build());
        //  -n --length
        options.addOption(Option.builder("n") // 
                                    .longOpt("length") // 
                                    .hasArg() // 
                                    .argName("length") // 
                                    // 
                                    .desc("random string length (range: >=0; default: 20)")
                                .build());
        //  -h --help
        options.addOption(Option.builder("h") // 
                                    .longOpt("help") // 
                                    // 
                                    .desc("show this help message and exit program")
                                .build());


        CommandLineParser parser = new DefaultParser();

        HelpFormatter formatter = new HelpFormatter();

        CommandLine result = null;

        try {
 
            result = parser.parse(options, args);
        } catch (ParseException e) {
    
            System.err.println(e.getMessage());
   
            formatter.printHelp("RandomGenerator", options, true);

            System.exit(1);
        }

        if (result.hasOption("h")) {
            formatter.printHelp("RandomGenerator", options, true);
            System.exit(0);
        }

        int level = 2; // default level
        int length = 20; // default length

        // If Exists -l --level 
        if (result.hasOption("l")) {
            try {
                level = Integer.parseInt(result.getOptionValue("l"));
            } catch (Exception e) {
                System.err.println(e.toString());
                formatter.printHelp("RandomGenerator", options, true);
                System.exit(1);
            }
        }
        // If exists-n --length 
        if (result.hasOption("n")) {
            try {
                length = Integer.parseInt(result.getOptionValue("n"));
            } catch (Exception e) {
                System.err.println(e.toString());
                formatter.printHelp("RandomGenerator", options, true);
                System.exit(1);
            }
        }
        // 
        System.out.println(random(level, length));
    }


    private static final String digit = "0123456789";

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static final String alnum = digit + alpha;

    private static final SecureRandom rnd = new SecureRandom();

    public static String random(int level, int length) {
        StringBuilder buf = new StringBuilder(length);
        if (level == 1)
            for (int i = 0; i < length; i++)
                buf.append(digit.charAt(rnd.nextInt(digit.length())));
        else if (level == 2)
            for (int i = 0; i < length; i++)
                buf.append(alpha.charAt(rnd.nextInt(alpha.length())));
        else if (level == 3)
            for (int i = 0; i < length; i++)
                buf.append(alnum.charAt(rnd.nextInt(alnum.length())));
        return buf.toString();
    }
}