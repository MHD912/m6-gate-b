package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral
{
    /**
     * Reference to the OutputInterface.
     */
    private final OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public FillTheCorral(OutputInterface out)
    {
        mOut = out;
    }

    /**
     *  This method is passed an array of Gate objects and a Random object
     *  and sets the direction of each gate’s swing randomly.
     * @param gate Object array of class Gate
     * @param rand Object of class Random
     */
    public void setCorralGates(Gate[] gate, Random rand)
    {
        for (int i = 0; i < gate.length; i++)
        {
            int direction = rand.nextInt(3) - 1;
            gate[i].setSwing(direction);
            mOut.println("Gate " + i + ": " + gate[i]);
        }
    }

    /**
     * This method returns a boolean value of true if at least one gate in the
     * array is set to swing IN so that snails can enter at least one corral
     * @param corral Object array of class Gate
     * @return boolean
     */
    public boolean anyCorralAvailable(Gate[] corral)
    {
        for (Gate gate : corral)
        {
            if (gate.getSwingDirection() == Gate.IN)
                return true;
        }
        return false;
    }

    /**
     * This method runs a simulation then prints and returns the number of
     * attempts that were required to corral all the snails
     * @param corral Object array of class Gate
     * @param rand Object of class Random
     * @return Integer - Attempts that were required to corral all the snails
     */
    public int corralSnails(Gate[] corral, Random rand)
    {
        int snailsOut = 5, iterations = 0;
        while (snailsOut != 0)
        {
            int corralIndex = rand.nextInt(corral.length);
            Gate G = corral[corralIndex];

            int snailsToMove = rand.nextInt(snailsOut) + 1;
            snailsOut -= G.thru(snailsToMove);

            mOut.println(snailsToMove + " are trying to move through corral " + corralIndex);
            iterations++;
        }
        mOut.println("It took " + iterations + " attempts to corral all of the snails.");
        return iterations;
    }
}
