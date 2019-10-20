package host.progamernothd.ktanemanual.solver;

import host.progamernothd.ktanemanual.Main;
import host.progamernothd.ktanemanual.enums.ButtonAction;
import host.progamernothd.ktanemanual.enums.ButtonInstruction;
import host.progamernothd.ktanemanual.enums.KTANEColor;

public class ButtonSolver {
	public static ButtonAction solve(KTANEColor color, ButtonInstruction instruction) {
		
		if(color == KTANEColor.Blue && instruction == ButtonInstruction.Abort) {
			return ButtonAction.Hold;
		}
		
		if(Main.mw.batteryComboBox.getSelectedIndex()+1 >1 && instruction == ButtonInstruction.Detonate) {
			return ButtonAction.Relase;
		}
			
		if(color == KTANEColor.White && Main.mw.getCarCheckbox().isSelected()) {
			return ButtonAction.Hold;
		}
			
		if(Main.mw.batteryComboBox.getSelectedIndex()+1 >2 && Main.mw.getFrkCheckbox().isSelected()) {
			return ButtonAction.Relase;
		}
			
		if(color == KTANEColor.Yellow) {
			return ButtonAction.Hold;
		}
			
		if(color == KTANEColor.Red && instruction == ButtonInstruction.Hold) {
			return ButtonAction.Relase;
		}
			
		System.out.println("Default");
		return ButtonAction.Hold;
		
	}
}
