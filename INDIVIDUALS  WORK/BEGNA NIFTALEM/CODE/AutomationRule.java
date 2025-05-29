public class AutomationRule {
    private String ruleId;
    private String condition;
    private String action;

    public AutomationRule(String ruleId, String condition, String action) {
        this.ruleId = ruleId;
        this.condition = condition;
        this.action = action;
    }

    public boolean evaluate() {
        // Dummy condition check
        return true;
    }

    public void executeAction() {
        System.out.println("Action executed: " + action);
    }
}