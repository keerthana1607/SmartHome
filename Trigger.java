/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;



/**
 *
 * @author keerthana
 */

// Trigger class to represent triggers.
public class Trigger {
    private String condition;
    private String action;

    public Trigger(String condition, String action) {
        this.condition = condition;
        this.action = action;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }
}


