package com.destructo.corona_tracker.Model;

public class HelplineNumberModel {

    private String stateName;
    private String helpLineNumber;

    public HelplineNumberModel(String stateName, String helpLineNumber) {
        this.stateName = stateName;
        this.helpLineNumber = helpLineNumber;
    }

    public String getStateName() {
        return stateName;
    }

    public String getHelpLineNumber() {
        return helpLineNumber;
    }
}
