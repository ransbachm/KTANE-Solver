package host.progamernothd.ktanemanual;

import host.progamernothd.ktanemanual.windows.MainWindow;

public class KtanePlusPlusMain {
	public static MainWindow mw;
	public static void main(String[] args) {
		System.out.println("Start");
		
		mw = new MainWindow();
		mw.frame.setVisible(true);
		
	}
}