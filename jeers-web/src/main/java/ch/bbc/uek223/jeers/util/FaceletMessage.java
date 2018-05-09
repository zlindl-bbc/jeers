/**
 * church administration by ghwalin
 */
package ch.bbc.uek223.jeers.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public final class FaceletMessage {

    /**
     * show an error message in the facelet
     * @param context
     * @param formField
     * @param shortMsg
     * @param longMsg
     */
    public static void showMessage(
            FacesContext context, 
            FacesMessage.Severity severity,
            String formField, 
            String shortMsg, 
            String longMsg) {
        
        context.addMessage(formField,
                new FacesMessage(severity, 
                                 shortMsg,
                                 longMsg));
        
        
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
}
