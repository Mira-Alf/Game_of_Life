class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String hoursString = hours<10 ? "0"+hours : String.valueOf(hours);
        String minutesString = minutes<10 ? "0"+minutes : String.valueOf(minutes);
        String secondsString = seconds<10 ? "0"+seconds : String.valueOf(seconds);

        return String.format("%s:%s:%s", hoursString, minutesString, secondsString);
    }
}