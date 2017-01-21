package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	
	State state = State.VALUE_1;
	JButton btnAdd, btnSub, btnDiv, btnMul, btnResult;
	JTextField display;
	JFrame frame;
	
	double value1, value2;
	char operator;
	boolean decimal = false;
	
	public enum State {
		VALUE_1,
		VALUE_2,
		RESULT
	}
	
	public static void main(String[] args) {
		new Main();
	}
 
    Main() {
    	createGUI();
    }
    
    private void showResult() {
    	if (state == State.VALUE_2 && !display.getText().isEmpty()) {
    		
    		state = State.RESULT;
    		value2 = Double.parseDouble(display.getText());
    		
    		/* TODO: Aufgabe 5, Partner B
    		 * führe abhängig vom Wert von operator die richtige Rechnung 
    		 * mit value1 und value2 durch
    		 * gebe das Ergebnis im display aus
    		 */
    		
    		
    	}
    }

    public void operatorPressed(char op) {
    	if (!display.getText().isEmpty()) {
    		operator = op;
        	value1 = Double.parseDouble(display.getText());
        	display.setText("");
        	decimal = false;
        	state = State.VALUE_2;
    	}
    }
    
    public void numberPressed(int value) {
    	if (state == state.RESULT) {
    		display.setText("");
    		state = state.VALUE_1;
    		decimal = false;
    	}
    	display.setText(display.getText().concat(Integer.toString(value)));
    }
    
    public void pointPressed() {
    	if (!display.getText().isEmpty() && !decimal) {
			display.setText(display.getText().concat("."));
			decimal = true;
		}
    }
    
    public void createGUI() {
    	// create frame
    	
    	frame = new JFrame("Rechner");
    	frame.setLayout(new BorderLayout());
    	frame.setSize(350, 400);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	
    	// add display
    	
    	display = new JTextField();
    	display.setEditable(false);
    	Font font = new Font("Arial", Font.BOLD, 30);
    	display.setFont(font);
    	display.setForeground(Color.GRAY);
    	display.setHorizontalAlignment(SwingConstants.RIGHT);
    	display.setPreferredSize(new Dimension(350, 100));
    	frame.add(display, BorderLayout.NORTH);
    	
    	// add buttons
    	
    	Panel pnlNumbers = new Panel();
    	pnlNumbers.setLayout(new GridLayout(0, 3, 5, 5));
    	frame.add(pnlNumbers, BorderLayout.CENTER);
    	
    	for (int i = 1; i <= 9; i++) {
    		final int v = i;
    		JButton button = new JButton(new AbstractAction(Integer.toString(i)) {
        		@Override
        		public void actionPerformed(ActionEvent e) {
        			numberPressed(v);
        		}
        	});
    		pnlNumbers.add(button);
    	}
    	
    	JButton btnPoint = new JButton(new AbstractAction(".") {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			pointPressed();
    		}
    	});
    	pnlNumbers.add(btnPoint);
    	
    	JButton btnZero = new JButton(new AbstractAction("0") {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numberPressed(0);
    		}
    	});
    	pnlNumbers.add(btnZero);
    	
    	JButton btnResult = new JButton(new AbstractAction("=") {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			showResult();
    		}
    	});
    	btnResult.setForeground(Color.BLUE);
    	pnlNumbers.add(btnResult);
    	
    	Panel pnlOperators = new Panel();
    	pnlOperators.setLayout(new GridLayout(4, 1, 5, 5));
    	frame.add(pnlOperators, BorderLayout.EAST);
    	
    	/* TODO: Aufgabe 5, Partner A
    	 * erstelle die Buttons +, -, *, /
    	 * so dass sie die Methode operatorPressed mit dem richtigen Parameter aufrufen
    	 * Setze die Schriftfarbe der Buttons auf rot
    	 * Füge Sie dem pnlOperators hinzu
    	 */
    	
    	// show frame
    	
    	frame.setVisible(true);
    }
}