/**
 * Abstract class, represents any type of truck platform
 */

abstract public class TruckPlatform {
    /**
     * Boolean that says if a platform is fully raised or not
     */
    private boolean fullyRaised;

    /**
     * Getter for the variable fullyRaised
     * @return fullyRaised
     */
    public boolean isFullyRaised() {
        return fullyRaised;
    }

    /**
     * Setter for the boolean fullyRaised
     * @param bol true or false
     */
    public void setFullyRaised(boolean bol) {
        fullyRaised = bol;
    }
}
