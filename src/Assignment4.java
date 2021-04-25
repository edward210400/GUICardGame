import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


/**
 * Assignment 4 is the class to create a simple card game.
 * The player will bet their money against the dealer.
 * If the player wins the round, they will get the same amount of money they bet,
 * if the player lose the round, their money will be deducted by the amount of money they bet.
 * The player cannot continue the game if they run out of money.
 * 
 * @author Edward Suryajaya
 */
public class Assignment4 {
	
	ArrayList<String> CardCollection = new ArrayList<>(Arrays.asList("card_11.gif", "card_12.gif", "card_13.gif",
			"card_14.gif", "card_15.gif", "card_16.gif", "card_17.gif", "card_18.gif", "card_19.gif", "card_110.gif",
			"card_111.gif", "card_112.gif", "card_113.gif", "card_21.gif", "card_22.gif", "card_23.gif",
			"card_24.gif", "card_25.gif", "card_26.gif", "card_27.gif", "card_28.gif", "card_29.gif", "card_210.gif",
			"card_211.gif", "card_212.gif", "card_213.gif", "card_31.gif", "card_32.gif", "card_33.gif",
			"card_34.gif", "card_35.gif", "card_36.gif", "card_37.gif", "card_38.gif", "card_39.gif", "card_310.gif",
			"card_311.gif", "card_312.gif", "card_313.gif", "card_41.gif", "card_42.gif", "card_43.gif",
			"card_44.gif", "card_45.gif", "card_46.gif", "card_47.gif", "card_48.gif", "card_49.gif", "card_410.gif",
			"card_411.gif", "card_412.gif", "card_413.gif"));
	
	ArrayList<String> ShuffledDeck = new ArrayList<>();
	int d_value = 0;
	int d_special = 0;
	int p_value = 0;
	int p_special = 0;
	int totalChange = 0;
	int val_P1 = 0;
	int val_P2 = 0;
	int val_P3 = 0;
	int val_D1 = 0;
	int val_D2 = 0;
	int val_D3 = 0;
	int special_D1 = 0;
	int special_D2 = 0;
	int special_D3 = 0;
	int special_P1 = 0;
	int special_P2 = 0;
	int special_P3 = 0;
	int bet = 0;
	
	
	int money = 100;
	JTextField txt_inputbet = new JTextField(10);
	ImageIcon Image1 = new ImageIcon("card_back.gif");
	ImageIcon Image2 = new ImageIcon("card_back.gif");
	ImageIcon Image3 = new ImageIcon("card_back.gif");
	ImageIcon Image4 = new ImageIcon("card_back.gif");
	ImageIcon Image5 = new ImageIcon("card_back.gif");
	ImageIcon Image6 = new ImageIcon("card_back.gif");
	JLabel label_info = new JLabel("Please place your bet!");
	JLabel label_money = new JLabel("Amount of money you have: $"+money);
	
	/**
	 * The main function to simulate a simple card game.
	 */
	
	public static void main(String[] args) {
		Assignment4 t = new Assignment4();
		t.go();
	}
	
	/**
	 * To draw the frame of the card game including all of the component.
	 * The component consists of 6 JLabel to display 3 image of cards for the players and 3 image for the dealer's cards,
	 * 2 JButton to start and see the results of the game, 3 JButton to change the player's card,
	 * 5 JPanel that divide the main panel into 5 components, and JMenuBar to display the menus.
	 * ActionListener also implemented to all of the buttons so the buttons could work according to their function.
	 * The player will be given $100 at the start of the game.
	 * The player can keep playing until they lose all of their money.
	 */
	
	public void go() {
		ShuffledDeck = Shuffle.shuffleDeck(CardCollection);
		
		JLabel label_Image1 = new JLabel();
		JLabel label_Image2 = new JLabel();
		JLabel label_Image3 = new JLabel();
		JLabel label_Image4 = new JLabel();
		JLabel label_Image5 = new JLabel();
		JLabel label_Image6 = new JLabel();
		
		JButton btn_rpcard1 = new JButton("Replace Card 1");
		JButton btn_rpcard2 = new JButton("Replace Card 2");
		JButton btn_rpcard3 = new JButton("Replace Card 3");
		JButton btn_start = new JButton("Start");
		JButton btn_result = new JButton("Result");
		JLabel label_bet = new JLabel("Bet: $");

		label_Image1.setIcon(Image1);
		label_Image2.setIcon(Image2);
		label_Image3.setIcon(Image3);
		label_Image4.setIcon(Image4);
		label_Image5.setIcon(Image5);
		label_Image6.setIcon(Image6);
		
		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);
		RpCardBtnPanel.add(btn_rpcard1);
		RpCardBtnPanel.add(btn_rpcard2);
		RpCardBtnPanel.add(btn_rpcard3);
		ButtonPanel.add(label_bet);
		ButtonPanel.add(txt_inputbet);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);
		InfoPanel.add(label_info);
		InfoPanel.add(label_money);
		
		
		MainPanel.setLayout(new GridLayout(5,1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green); 
		
		JMenuBar menubar = new JMenuBar();
		JMenu control = new JMenu("Control");
		JMenu help = new JMenu("Help");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem help_ = new JMenuItem("Instruction");
		help.add(help_);
		control.add(exit);
		menubar.add(control);
		menubar.add(help);
		
		JFrame frame = new JFrame();
		frame.setJMenuBar(menubar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setTitle("A Simple Card Game");
		frame.setSize(400, 700);
		frame.setVisible(true);
		
		btn_rpcard1.setEnabled(false);
		btn_rpcard2.setEnabled(false);
		btn_rpcard3.setEnabled(false);
		btn_result.setEnabled(false);
		
		help_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "J, Q, K are regarded as special cards.\r\n" + 
						"Rule 1: The one with more special cards wins.\r\n" + 
						"Rule 2: If both have the same number of special cards, add the face values of the other " + 
						"card(s) and take the remainder after dividing the sum by 10. The one with a bigger " + 
						"remainder wins. (Note: Ace = 1).\r\n" + 
						"Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_inputbet.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "WARNING: The bet you place must be a positive integer!");
				}
				
				if(Double.parseDouble(txt_inputbet.getText())>0 && Double.parseDouble(txt_inputbet.getText())%1 == 0 && Double.parseDouble(txt_inputbet.getText())<=money) {
					btn_rpcard1.setEnabled(true);
					btn_rpcard2.setEnabled(true);
					btn_rpcard3.setEnabled(true);
					btn_result.setEnabled(true);
					bet = Integer.parseInt(txt_inputbet.getText());
					label_info.setText("Your current bet is: $"+txt_inputbet.getText());
					label_Image4.setIcon(new ImageIcon(ShuffledDeck.get(0)));
					label_Image5.setIcon(new ImageIcon(ShuffledDeck.get(1)));
					label_Image6.setIcon(new ImageIcon(ShuffledDeck.get(2)));
					if(ShuffledDeck.get(0).length()==11) {
						val_P1 = Character.getNumericValue(ShuffledDeck.get(0).charAt(6));
					}
					if(ShuffledDeck.get(0).length()==12) {
						if(Character.getNumericValue(ShuffledDeck.get(0).charAt(7))==0) {
							val_P1 = 10;
						}
						else {
							special_P1 = 1;
						}
					}
					if(ShuffledDeck.get(1).length()==11) {
						val_P2 = Character.getNumericValue(ShuffledDeck.get(1).charAt(6));
					}
					if(ShuffledDeck.get(1).length()==12) {
						if(Character.getNumericValue(ShuffledDeck.get(1).charAt(7))==0) {
							val_P2 = 10;
						}
						else {
							special_P2 = 1;
						}
					}
					if(ShuffledDeck.get(2).length()==11) {
						val_P3 = Character.getNumericValue(ShuffledDeck.get(2).charAt(6));
					}
					if(ShuffledDeck.get(2).length()==12) {
						if(Character.getNumericValue(ShuffledDeck.get(2).charAt(7))==0) {
							val_P3 = 10;
						}
						else {
							special_P3 = 1;
						}
					}
					btn_start.setEnabled(false);
				}
				else {
					if(Double.parseDouble(txt_inputbet.getText())>money) {
						JOptionPane.showMessageDialog(frame, "WARNING: You only have $"+money+"!");
					}
					else {
						JOptionPane.showMessageDialog(frame, "WARNING: The bet you place must be a positive integer!");
					}
				}
			}
		});
		
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Image1.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange+1)));
				label_Image2.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange+2)));
				label_Image3.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange+3)));
				if(ShuffledDeck.get(2+totalChange+1).length()==11) {
					val_D1 = Character.getNumericValue(ShuffledDeck.get(2+totalChange+1).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange+1).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange+1).charAt(7))==0) {
						val_D1 = 10;
					}
					else {
						special_D1 = 1;
					}
				}
				if(ShuffledDeck.get(2+totalChange+2).length()==11) {
					val_D2 = Character.getNumericValue(ShuffledDeck.get(2+totalChange+2).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange+2).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange+2).charAt(7))==0) {
						val_D2 = 10;
					}
					else {
						special_D2 = 1;
					}
				}
				if(ShuffledDeck.get(2+totalChange+3).length()==11) {
					val_D3 = Character.getNumericValue(ShuffledDeck.get(2+totalChange+3).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange+3).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange+3).charAt(7))==0) {
						val_D3 = 10;
					}
					else {
						special_D3 = 1;
					}
				}
				d_value = (val_D1 + val_D2 + val_D3)%10;
				p_value = (val_P1 + val_P2 + val_P3)%10;
				d_special = special_D1 + special_D2 + special_D3;
				p_special = special_P1 + special_P2 + special_P3;
				if(p_special>d_special) {
					JOptionPane.showMessageDialog(frame, "Congratulations! You win this round!");
					money = money+bet;
				}
				if(p_special<d_special) {
					JOptionPane.showMessageDialog(frame, "Sorry! The Dealer wins this round!");
					money = money-bet;
				}
				if(p_special==d_special) {
					if(p_value>d_value) {
						JOptionPane.showMessageDialog(frame, "Congratulations! You win this round!");
						money = money+bet;
					}
					if(p_value<d_value) {
						JOptionPane.showMessageDialog(frame, "Sorry! The Dealer wins this round!");
						money = money-bet;
					}
					if(p_value==d_value) {
						JOptionPane.showMessageDialog(frame, "Sorry! The Dealer wins this round!");
						money = money-bet;
					}
				}
				label_money.setText("Amount of money you have: $"+money);
				if(money<=0) {
					label_info.setText("You have no more money!");
					label_money.setText("Please start a new game!");
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
					btn_start.setEnabled(false);
					btn_result.setEnabled(false);
					JOptionPane.showMessageDialog(frame, "Game over!\nYou have no more money!\nPlease start a new game!");
				}
				if(money>0) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
					btn_start.setEnabled(true);
					btn_result.setEnabled(false);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					label_Image4.setIcon(Image4);
					label_Image5.setIcon(Image5);
					label_Image6.setIcon(Image6);
					d_value = 0;
					d_special = 0;
					p_value = 0;
					p_special = 0;
					totalChange = 0;
					val_P1 = 0;
					val_P2 = 0;
					val_P3 = 0;
					val_D1 = 0;
					val_D2 = 0;
					val_D3 = 0;
					special_D1 = 0;
					special_D2 = 0;
					special_D3 = 0;
					special_P1 = 0;
					special_P2 = 0;
					special_P3 = 0;
					ShuffledDeck.clear();
					ShuffledDeck = Shuffle.shuffleDeck(CardCollection);
				}
			}
		});
		
		btn_rpcard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val_P1 = 0;
				special_P1 = 0;
				totalChange++;
				label_Image4.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange)));
				if(ShuffledDeck.get(2+totalChange).length()==11) {
					val_P1 = Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(7))==0) {
						val_P2 = 10;
					}
					else {
						special_P2 = 1;
					}
				}
				btn_rpcard1.setEnabled(false);
				if(totalChange==2) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
				}
			}
		});
		
		btn_rpcard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val_P2 = 0;
				special_P2 = 0;
				totalChange++;
				label_Image5.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange)));
				if(ShuffledDeck.get(2+totalChange).length()==11) {
					val_P2 = Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(7))==0) {
						val_P2 = 10;
					}
					else {
						special_P2 = 1;
					}
				}
				btn_rpcard2.setEnabled(false);
				if(totalChange==2) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
				}
			}
		});
		
		btn_rpcard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val_P3 = 0;
				special_P3 = 0;
				totalChange++;
				label_Image6.setIcon(new ImageIcon(ShuffledDeck.get(2+totalChange)));
				if(ShuffledDeck.get(2+totalChange).length()==11) {
					val_P3 = Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(6));
				}
				if(ShuffledDeck.get(2+totalChange).length()==12) {
					if(Character.getNumericValue(ShuffledDeck.get(2+totalChange).charAt(7))==0) {
						val_P3 = 10;
					}
					else {
						special_P3 = 1;
					}
				}
				btn_rpcard3.setEnabled(false);
				if(totalChange==2) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
				}
			}
		});

	}
	
	
	
}
