package mooc.vandy.java4android.gate.logic;

import androidx.annotation.NonNull;

/**
 * This file defines the Gate class.
 */
public class Gate
{
    /**
     * This section holds Gate class defined field variables
     */
    public static final int IN = 1, OUT = -1, CLOSED = 0;
    private int mSwing;

    /**
     * Gate class default construct. Newly created Gate objects are initialized with the value CLOSED.
     */
    public Gate()
    {
        this.mSwing = CLOSED;
    }

    /**
     * Mutator method for mSwing field variable.
     *
     * @param direction Refers to Gate Swing direction.
     * @return boolean - Returns true at success and false at failure.
     */
    public boolean setSwing(int direction)
    {
        switch (direction)
        {
            case IN:
            case OUT:
            case CLOSED:
                this.mSwing = direction;
                return true;
            default:
                return false;
        }
    }

    /**
     * Method for opening Gate object in a specific direction.
     *
     * @param direction Gate Swing direction value can either be IN or OUT.
     * @return boolean - Returns true at success and false at failure.
     */
    public boolean open(int direction)
    {
        return setSwing(direction);
    }

    /**
     * Method for closing a Gate object.
     */
    public void close()
    {
        this.setSwing(CLOSED);
    }

    /**
     * Getter method for field variable mSwing value.
     *
     * @return int - Gate object Swing direction.
     */
    public int getSwingDirection()
    {
        return this.mSwing;
    }

    /**
     * This method specifies the snails count passing through the Gate object.
     *
     * @param count Number of snails requested to pass the Gate
     * @return int - Refers to the total change in the number of snails within the farm.
     */
    public int thru(int count)
    {
        return (count * getSwingDirection());
    }

    @NonNull
    @Override
    public String toString()
    {
        switch (getSwingDirection())
        {
            // for a gate that is closed
            case CLOSED:
                return "This gate is closed";
            // for a gate that has opened to swing IN
            case IN:
                return "This gate is open and swings to enter the pen only";
            // for a gate that been opened swing OUT
            case OUT:
                return "This gate is open and swings to exit the pen only";
            // for a gate that has a swing value other than IN, OUT, or CLOSED
            default:
                return "This gate has an invalid swing direction";
        }
    }
}
