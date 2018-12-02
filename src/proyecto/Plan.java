package proyecto;

public class Plan {
    private String planType;
    private String start;
    private String end;
    private boolean status;
    private String day;
    private String hour;

    public Plan(String planType, String start, String end, boolean status, String day, String hour) {
        this.planType = planType;
        this.start = start;
        this.end = end;
        this.status = status;
        this.day = day;
        this.hour = hour;
    }

    public Plan() {

    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}