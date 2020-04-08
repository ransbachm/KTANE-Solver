package host.progamernothd.ktanemanual.solver;

import host.progamernothd.ktanemanual.KtanePlusPlusMain;
import host.progamernothd.ktanemanual.enums.ButtonAction;
import host.progamernothd.ktanemanual.enums.ButtonInstruction;
import host.progamernothd.ktanemanual.enums.KTANEColor;

public class ButtonSolver {
	public static ButtonAction solve(KTANEColor color, ButtonInstruction instruction) {
		
		if(color == KTANEColor.Blue && instruction == ButtonInstruction.Abort) {
			return ButtonAction.Hold;
		}
		
		if(KtanePlusPlusMain.mw.batteryComboBox.getSelectedIndex() >1 && instruction == ButtonInstruction.Detonate) {
			return ButtonAction.Relase;
		}
			
		if(color == KTANEColor.White && KtanePlusPlusMain.mw.getCarCheckbox().isSelected()) {
			return ButtonAction.Hold;
		}
			
		if(KtanePlusPlusMain.mw.batteryComboBox.getSelectedIndex() >2 && KtanePlusPlusMain.mw.getFrkCheckbox().isSelected()) {
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
