package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager
{
    /**
     * Reference to the output.
     */
    private final OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private final Gate mWestGate;

    /**
     * The output Gate object.
     */
    private final Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Maximum size of the escargatoire
     */
    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out, Gate westGate, Gate eastGate)
    {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    /**
     * This method simulates the movement of snails in and out
     * of the escargatoire.
     * @param rand Object of class Random
     */
    public void simulateHerd(Random rand)
    {
        int pen = HERD;     // Snails count within the pen
        int pasture = 0;    // Snails count out of the pen
        mOut.println("There are currently" + pen + "snails in the pen and" + pasture + "snails in the pasture");
        for (int i = 0; i < MAX_ITERATIONS; i++)
        {
            Gate gate;      // Reference object of class Gate which is assigned to one of the available gates
            if (pasture == HERD)    // If all snails are out of the pen
                gate = mWestGate;
            else if (pen == HERD)   // If all snails are within the pen
                gate = mEastGate;
            else
            {
                // Randomly select one of the two gates
                boolean isEastGate = rand.nextBoolean();
                if (isEastGate)
                    gate = mEastGate;
                else
                    gate = mWestGate;
            }

            // Randomly select the number of snails to be moved
            int snailsCount;
            if (pasture == HERD || pen == HERD)
                snailsCount = rand.nextInt(HERD) + 1;
            else if (gate.getSwingDirection() == Gate.IN)
                snailsCount = rand.nextInt(HERD - pen) + 1;
            else
                snailsCount = rand.nextInt(HERD - pasture) + 1;

            pen += gate.thru(snailsCount);
            pasture -= gate.thru(snailsCount);
            mOut.println("There are currently" + pen + "snails in the pen and" + pasture + "snails in the pasture");
        }
    }
}
