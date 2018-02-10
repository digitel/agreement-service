package org.tmf.openapi.agreement.domain;

public class AgreementTermOrCondition {

    private String id;

    private String description;

    private TimePeriod validFor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    @Override
    public String toString() {
        return "AgreementTermOrCondition{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", validFor=" + validFor +
                '}';
    }
}
