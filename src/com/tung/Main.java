package com.tung;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Main extends MIDlet implements CommandListener {

	private Command exitCommand;
	
	private Result result;
	
	private Form enterResultForm;
	private Display display;
	private ResultSender resultSender;
	private ResultView resultView;
	
	public Main() {
		display = Display.getDisplay(this);
		
		exitCommand = new Command("Exit", Command.EXIT, 1);
		
		result = new Result();
		
		resultSender = new ResultSender(result);
		resultView = new ResultView(result, display, resultSender);
		enterResultForm = new EnterResultForm(display, result, resultView);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		display.setCurrent(enterResultForm);
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == exitCommand) {
			try {
				destroyApp(false);
			} catch (MIDletStateChangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyDestroyed();
		}
	}

}