/**
 * Subclass of TruckPlatform
 * Instances of Scania has a ScaniaPlatform as private variable
 * Used to delegate methods relating to platform
 */
public class ScaniaPlatform extends TruckPlatform {

    private double currentInclineAngle;

    /**
     * Constructor, sets currentInclineAngle = 0 and fullyRaised = false
     */
    public ScaniaPlatform() {
        setFullyRaised(false);
        currentInclineAngle = 0;
    }

    /**
     * Method which checks if is fully raised and updates
     */
    public void checkIfFullyRaised() {
        setFullyRaised(getCurrentIncline() == 70);
    }

    /**
     * Method which raises the incline by some amount
     * First checks for negative numbers
     * calculates new angle, sets current angle to min(70, calculated angle)
     * updates fullyRaised
     * @param angleChange amount which platform is raised by
     * @throws Exception if entered a negative number
     */
    public void raise(double angleChange) throws Exception {
        if (angleChange < 0) {
            throw new Exception("angleChange can't be a negative number");
        }

        double newInclineAngle = currentInclineAngle + angleChange;

        if (newInclineAngle > 70) {
            currentInclineAngle = 70;
        } else currentInclineAngle = newInclineAngle;

        checkIfFullyRaised();
    }

    /**
     * Method which lowers the incline by some amount
     * First checks for negative numbers
     * calculates new angle, sets current angle to max(0, calculated angle)
     * updates fullyRaised
     * @param angleChange amount which platform is lowered by
     * @throws Exception if entered a negative number
     */
    public void lower(double angleChange) throws Exception {
        if (angleChange < 0) {
            throw new Exception("angleChange can't be a negative number");
        }

        double newInclineAngle = currentInclineAngle - angleChange;

        if (newInclineAngle < 0) {
            currentInclineAngle = 0;
        } else currentInclineAngle = newInclineAngle;

        checkIfFullyRaised();
    }

    /**
     * Getter for current incline
     * @return currentInclineAngle
     */
    public double getCurrentIncline() {
        return currentInclineAngle;
    }

    /**
     * Setter for current incline
     * @param newIncline what new incline is
     */
    public void setCurrentInclineAngle(double newIncline) {
        currentInclineAngle = newIncline;
    }
}
