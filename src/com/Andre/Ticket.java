package com.Andre;

import java.util.Date;

/**
 * Created by Andre on 2/26/2015.
 */
public class Ticket implements Comparable<Ticket> {
    private int priority;
    private String reporter; //Stores person or department who reported issue
    private String description;
    private Date dateReported;
    private Date resolvedDate;
    private String resolution;

    //STATIC Counter - accessible to all Ticket objects.
    //If any Ticket object modifies this counter, all Ticket objects will have the modified value
    //Make it private - only Ticket objects should have access
    private static int staticTicketIDCounter = 1;
    //The ID for each ticket - instance variable. Each Ticket will have it's own ticketID variable
    protected int ticketID;

    public int getTicketID() {
        return ticketID;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Ticket(String desc, int p, String rep, Date date) {
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = date;
        this.ticketID = staticTicketIDCounter;
        staticTicketIDCounter++;
    }

    public String getReporter() {
        return reporter;
    }

    public String getDescription() {
        return description;
    }

    protected int getPriority() {
        return priority;
    }

    public String toString(){
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;

        return("ID: " + this.ticketID + ", Issued: " + this.description + ", Priority: " +
                this.priority + ", Reported by: " + this.reporter + ", Reported on: " +
                this.dateReported + ", Resolved: " + resolutionString +
                ", Resolved Date: " + resolvedDateString);
    }

    public int compareTo(Ticket anotherTicket) {

        if (this.priority < anotherTicket.getPriority() ) {
            return 1;
        } else if (this.priority > anotherTicket.getPriority()) {
            return -1;
        } else {
            return 0;
        }

    }

}
