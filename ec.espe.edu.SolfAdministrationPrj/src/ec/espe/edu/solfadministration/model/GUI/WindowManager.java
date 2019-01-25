/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Pancho
 */
public class WindowManager {

    /**
     * This method allign to the center if the size of its container is changed
     * @param component The component that have to move
     * @param componentContainer The container of 
     */
    public static void AllignCenter(JComponent component, JFrame componentContainer) {
        ComponentEvent windowEvent = new ComponentEvent(componentContainer, ComponentEvent.COMPONENT_RESIZED);
        int componentYposition = component.getY();
        int componentWidth = component.getWidth();
            

        componentContainer.getContentPane().addComponentListener(new ComponentAdapter() {
        
            public void componentResized(ComponentEvent event){
                Component comp= (Component)event.getSource();
 
                component.setLocation( (comp.getWidth()/ 2)-componentWidth/2,componentYposition);
                
            }
        
        
        });

    }

}
