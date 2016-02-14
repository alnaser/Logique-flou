/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyFuzzzyLogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 *
 * @author alnaser's
 */
public class Fuzzylogic {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
                // Load from 'FCL' file
        
        String fileName = "tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        functionBlock.chart();
        

        // Set inputs
        functionBlock.setVariable("service",9);
        functionBlock.setVariable("food", 9);

        // Evaluate
        functionBlock.evaluate();

        // Show output variable's chart
        
        functionBlock.getVariable("tip").chartDefuzzifier(true);

        // Print ruleSet
        System.out.println(functionBlock);
        System.out.println("\n TIP:"+functionBlock.getVariable("tip").getValue());

    }
    
}
