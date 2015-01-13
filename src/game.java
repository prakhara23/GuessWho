import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JToggleButton;

public class game {

	private JFrame frame;
	private String player;
	private String character; 
	private int b01, b02, b03, b04, b05, b06, b07, b08, b09, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19;
	private int player_char;
	private int quesnum = 0;
	private String[] answer = new String[10];
	private static String[] cpu_choice;
	private boolean game_over = false;
	private ArrayList<String[]> chars = new ArrayList<String[]>();
	private ArrayList<String> questions = new ArrayList<String>();
	private String[] people = new String[15];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game window = new game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(930, 732);
		frame.setResizable(false);
		frame.setTitle("Guess Who?");
		frame.setIconImage((new ImageIcon(game.class.getResource("/Buttons/askthb.png"))).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel pnlhome = new JPanel();
		pnlhome.setBackground(new Color(220, 20, 60));
		frame.getContentPane().add(pnlhome, "name_254043700633329");
		pnlhome.setLayout(null);
		
		final JPanel pnlgame = new JPanel();
		frame.getContentPane().add(pnlgame, "name_254043712406138");
		pnlgame.setLayout(null);
		
		final JPanel pnlrule = new JPanel();
		frame.getContentPane().add(pnlrule, "name_254043707249098");
		pnlrule.setBackground(new Color(0, 0, 139));
		pnlrule.setLayout(null);
		
		JButton btnPlay2 = new JButton("Continue to Game");
		btnPlay2.setBackground(Color.WHITE);
		btnPlay2.setBounds(767, 626, 145, 26);
		pnlrule.add(btnPlay2);
		
		JButton btnHome2 = new JButton("Return Home");
		btnHome2.setBackground(Color.WHITE);
		btnHome2.setBounds(12, 626, 145, 26);
		pnlrule.add(btnHome2);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		label_2.setOpaque(true);
		label_2.setBounds(0, 595, 925, 7);
		pnlrule.add(label_2);
		
		final JToggleButton tglbtnUiGuide = new JToggleButton("Click for Game Rules");
		tglbtnUiGuide.setBackground(Color.WHITE);
		tglbtnUiGuide.setBounds(382, 626, 160, 26);
		pnlrule.add(tglbtnUiGuide);
		
		final JLabel label_1 = new JLabel("");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setIcon(new ImageIcon(game.class.getResource("/Pics/UIguide.png")));
		label_1.setBounds(0, 0, 925, 602);
		pnlrule.add(label_1);
		
		final JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(game.class.getResource("/Buttons/askthb.png")));
		label_4.setBounds(401, 662, 30, 30);
		pnlgame.add(label_4);
		
		final JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(game.class.getResource("/Buttons/guessthb.png")));
		label_5.setBounds(675, 662, 30, 30);
		pnlgame.add(label_5);
		
		final JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(game.class.getResource("/Buttons/nextthb.png")));
		label_6.setBounds(677, 662, 30, 30);
		pnlgame.add(label_6);
		
		final JLabel lblturn = new JLabel("");
		lblturn.setForeground(Color.WHITE);
		lblturn.setFont(new Font("Lucida Bright", Font.BOLD, 22));
		lblturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblturn.setBounds(177, 656, 582, 36);
		pnlgame.add(lblturn);
				
		JLabel label = new JLabel("");
		label.setBounds(134, 63, 263, 87);
		pnlhome.add(label);
		
		final JButton btnPlay = new JButton("Play");
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(210, 360, 107, 25);
		pnlhome.add(btnPlay);
		
		JButton btnRule = new JButton("Instructions");
		btnRule.setBackground(Color.WHITE);
		btnRule.setBounds(210, 390, 107, 25);
		pnlhome.add(btnRule);
		
		final JButton btnSound = new JButton("");
		btnSound.setBounds(12, 12, 50, 50);
		btnSound.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundoff.png")));
		btnSound.setOpaque(false);
		btnSound.setContentAreaFilled(false);
		btnSound.setBorderPainted(false);
		pnlhome.add(btnSound);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(210, 420, 107, 25);
		pnlhome.add(btnExit);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(game.class.getResource("/Pics/board.png")));
		label_3.setBounds(0, 0, 924, 704);
		pnlhome.add(label_3);
		
		final JButton btnSound2 = new JButton("");
		btnSound2.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundoff.png")));
		btnSound2.setOpaque(false);
		btnSound2.setContentAreaFilled(false);
		btnSound2.setBorderPainted(false);
		btnSound2.setBounds(12, 12, 50, 50);
		pnlgame.add(btnSound2);
						
		final JLabel lblplayer = new JLabel("");
		lblplayer.setBounds(30, 125, 100, 148);
		pnlgame.add(lblplayer);
		
		final JButton btnGuess = new JButton("");
		btnGuess.setToolTipText("Guess the Character");
		btnGuess.setBounds(30, 330, 100, 100);
		btnGuess.setIcon(new ImageIcon(game.class.getResource("/Buttons/guess.png")));
		btnGuess.setPressedIcon(new ImageIcon(game.class.getResource("/Buttons/guessclick.png")));
		btnGuess.setOpaque(false);
		btnGuess.setContentAreaFilled(false);
		btnGuess.setBorderPainted(false);
		pnlgame.add(btnGuess);
		
		final JButton btnAsk = new JButton("");
		btnAsk.setToolTipText("Ask a Question");
		btnAsk.setBounds(30, 437, 100, 100);
		btnAsk.setIcon(new ImageIcon(game.class.getResource("/Buttons/ask.png")));
		btnAsk.setPressedIcon(new ImageIcon(game.class.getResource("/Buttons/askclick.png")));
		btnAsk.setOpaque(false);
		btnAsk.setContentAreaFilled(false);
		btnAsk.setBorderPainted(false);
		pnlgame.add(btnAsk);
		
		final JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(game.class.getResource("/Buttons/next.png")));
		btnNext.setPressedIcon(new ImageIcon(game.class.getResource("/Buttons/nextclick.png")));
		btnNext.setToolTipText("Next (End Turn)");
		btnNext.setOpaque(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.setBounds(801, 330, 100, 100);
		pnlgame.add(btnNext);
		
		final JButton btnHome = new JButton("");
		btnHome.setBounds(801, 437, 100, 100);
		btnHome.setToolTipText("Go Home");
		btnHome.setIcon(new ImageIcon(game.class.getResource("/Buttons/home.png")));
		btnHome.setPressedIcon(new ImageIcon(game.class.getResource("/Buttons/homeclick.png")));
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		pnlgame.add(btnHome);
		
		final JLabel lblcpu = new JLabel("");
		lblcpu.setBounds(801, 125, 100, 148);
		pnlgame.add(lblcpu);
		
		
		final JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Alice";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b01++;
					if ( (b01 & 1) == 0) {
						btn1.setIcon(new ImageIcon(game.class.getResource("/Pics/Alice.png")));
					} else {
						btn1.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn1.setBounds(236, 19, 99, 148);
		btn1.setIcon(new ImageIcon(game.class.getResource("/Pics/Alice.png")));
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		pnlgame.add(btn1);
		
		final JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Anita";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b02++;
					if ( (b02 & 1) == 0) {
						btn2.setIcon(new ImageIcon(game.class.getResource("/Pics/Anita.png")));
					} else {
						btn2.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn2.setBounds(355, 19, 99, 148);
		btn2.setIcon(new ImageIcon(game.class.getResource("/Pics/Anita.png")));
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		pnlgame.add(btn2);
		
		final JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Anne";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b03++;
					if ( (b03 & 1) == 0) {
						btn3.setIcon(new ImageIcon(game.class.getResource("/Pics/Anne.png")));
					} else {
						btn3.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn3.setBounds(474, 19, 99, 148);
		btn3.setIcon(new ImageIcon(game.class.getResource("/Pics/Anne.png")));
		btn3.setOpaque(false);
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		pnlgame.add(btn3);
		
		final JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Art";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b04++;
					if ( (b04 & 1) == 0) {
						btn4.setIcon(new ImageIcon(game.class.getResource("/Pics/Art.png")));
					} else {
						btn4.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn4.setBounds(593, 19, 99, 148);
		btn4.setIcon(new ImageIcon(game.class.getResource("/Pics/Art.png")));
		btn4.setOpaque(false);
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		pnlgame.add(btn4);
		
		final JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Bill";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b05++;
					if ( (b05 & 1) == 0) {
						btn5.setIcon(new ImageIcon(game.class.getResource("/Pics/Bill.png")));
					} else {
						btn5.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn5.setBounds(177, 178, 99, 148);
		btn5.setIcon(new ImageIcon(game.class.getResource("/Pics/Bill.png")));
		btn5.setOpaque(false);
		btn5.setContentAreaFilled(false);
		btn5.setBorderPainted(false);
		pnlgame.add(btn5);
		
		final JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Bob";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b06++;
					if ( (b06 & 1) == 0) {
						btn6.setIcon(new ImageIcon(game.class.getResource("/Pics/Bob.png")));
					} else {
						btn6.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn6.setBounds(296, 178, 99, 148);
		btn6.setIcon(new ImageIcon(game.class.getResource("/Pics/Bob.png")));
		btn6.setOpaque(false);
		btn6.setContentAreaFilled(false);
		btn6.setBorderPainted(false);
		pnlgame.add(btn6);
		
		final JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Brian";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b07++;
					if ( (b07 & 1) == 0) {
						btn7.setIcon(new ImageIcon(game.class.getResource("/Pics/Brian.png")));
					} else {
						btn7.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn7.setBounds(419, 178, 99, 148);
		btn7.setIcon(new ImageIcon(game.class.getResource("/Pics/Brian.png")));
		btn7.setOpaque(false);
		btn7.setContentAreaFilled(false);
		btn7.setBorderPainted(false);
		pnlgame.add(btn7);
		
		final JButton btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Carol";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b08++;
					if ( (b08 & 1) == 0) {
						btn8.setIcon(new ImageIcon(game.class.getResource("/Pics/Carol.png")));
					} else {
						btn8.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn8.setBounds(538, 178, 99, 148);
		btn8.setIcon(new ImageIcon(game.class.getResource("/Pics/Carol.png")));
		btn8.setOpaque(false);
		btn8.setContentAreaFilled(false);
		btn8.setBorderPainted(false);
		pnlgame.add(btn8);
		
		final JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "David";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b09++;
					if ( (b09 & 1) == 0) {
						btn9.setIcon(new ImageIcon(game.class.getResource("/Pics/David.png")));
					} else {
						btn9.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn9.setBounds(655, 178, 99, 148);
		btn9.setIcon(new ImageIcon(game.class.getResource("/Pics/David.png")));
		btn9.setOpaque(false);
		btn9.setContentAreaFilled(false);
		btn9.setBorderPainted(false);
		pnlgame.add(btn9);
		
		final JButton btn10 = new JButton("");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Eric";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b10++;
					if ( (b10 & 1) == 0) {
						btn10.setIcon(new ImageIcon(game.class.getResource("/Pics/Eric.png")));
					} else {
						btn10.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn10.setBounds(177, 337, 99, 148);
		btn10.setIcon(new ImageIcon(game.class.getResource("/Pics/Eric.png")));
		btn10.setOpaque(false);
		btn10.setContentAreaFilled(false);
		btn10.setBorderPainted(false);
		pnlgame.add(btn10);
		
		final JButton btn11 = new JButton("");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Frank";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b11++;
					if ( (b11 & 1) == 0) {
						btn11.setIcon(new ImageIcon(game.class.getResource("/Pics/Frank.png")));
					} else {
						btn11.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn11.setBounds(297, 337,  99, 148);
		btn11.setIcon(new ImageIcon(game.class.getResource("/Pics/Frank.png")));
		btn11.setOpaque(false);
		btn11.setContentAreaFilled(false);
		btn11.setBorderPainted(false);
		pnlgame.add(btn11);
		
		final JButton btn12 = new JButton("");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Henry";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b12++;
					if ( (b12 & 1) == 0) {
						btn12.setIcon(new ImageIcon(game.class.getResource("/Pics/Henry.png")));
					} else {
						btn12.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn12.setBounds(419, 337, 99, 148);
		btn12.setIcon(new ImageIcon(game.class.getResource("/Pics/Henry.png")));
		btn12.setOpaque(false);
		btn12.setContentAreaFilled(false);
		btn12.setBorderPainted(false);
		pnlgame.add(btn12);
		
		final JButton btn13 = new JButton("");
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Jill";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b13++;
					if ( (b13 & 1) == 0) {
						btn13.setIcon(new ImageIcon(game.class.getResource("/Pics/Jill.png")));
					} else {
						btn13.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn13.setBounds(538, 337, 99, 148);
		btn13.setIcon(new ImageIcon(game.class.getResource("/Pics/Jill.png")));
		btn13.setOpaque(false);
		btn13.setContentAreaFilled(false);
		btn13.setBorderPainted(false);
		pnlgame.add(btn13);
		
		final JButton btn14 = new JButton("");
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Mike";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b14++;
					if ( (b14 & 1) == 0) {
						btn14.setIcon(new ImageIcon(game.class.getResource("/Pics/Mike.png")));
					} else {
						btn14.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn14.setBounds(655, 337,  99, 148);
		btn14.setIcon(new ImageIcon(game.class.getResource("/Pics/Mike.png")));
		btn14.setOpaque(false);
		btn14.setContentAreaFilled(false);
		btn14.setBorderPainted(false);
		pnlgame.add(btn14);
		
		final JButton btn15 = new JButton("");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Paul";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b15++;
					if ( (b15 & 1) == 0) {
						btn15.setIcon(new ImageIcon(game.class.getResource("/Pics/Paul.png")));
					} else {
						btn15.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn15.setBounds(177, 496,  99, 148);
		btn15.setIcon(new ImageIcon(game.class.getResource("/Pics/Paul.png")));
		btn15.setOpaque(false);
		btn15.setContentAreaFilled(false);
		btn15.setBorderPainted(false);
		pnlgame.add(btn15);
		
		final JButton btn16 = new JButton("");
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Phil";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b16++;
					if ( (b16 & 1) == 0) {
						btn16.setIcon(new ImageIcon(game.class.getResource("/Pics/Phil.png")));
					} else {
						btn16.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn16.setBounds(297, 496,  99, 148);
		btn16.setIcon(new ImageIcon(game.class.getResource("/Pics/Phil.png")));
		btn16.setOpaque(false);
		btn16.setContentAreaFilled(false);
		btn16.setBorderPainted(false);
		pnlgame.add(btn16);
		
		final JButton btn17 = new JButton("");
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Sam";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b17++;
					if ( (b17 & 1) == 0) {
						btn17.setIcon(new ImageIcon(game.class.getResource("/Pics/Sam.png")));
					} else {
						btn17.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn17.setBounds(419, 496,  99, 148);
		btn17.setIcon(new ImageIcon(game.class.getResource("/Pics/Sam.png")));
		btn17.setOpaque(false);
		btn17.setContentAreaFilled(false);
		btn17.setBorderPainted(false);
		pnlgame.add(btn17);
		
		final JButton btn18 = new JButton("");
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Susan";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b18++;
					if ( (b18 & 1) == 0) {
						btn18.setIcon(new ImageIcon(game.class.getResource("/Pics/Susan.png")));
					} else {
						btn18.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn18.setBounds(538, 496,  99, 148);
		btn18.setIcon(new ImageIcon(game.class.getResource("/Pics/Susan.png")));
		btn18.setOpaque(false);
		btn18.setContentAreaFilled(false);
		btn18.setBorderPainted(false);
		pnlgame.add(btn18);
		
		final JButton btn19 = new JButton("");
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String who = "Tom";
				choose (who, lblplayer, lblcpu, lblturn, btnAsk, btnGuess, label_4, label_5);
				if (player_char != 1) {
					b19++;
					if ( (b19 & 1) == 0) {
						btn19.setIcon(new ImageIcon(game.class.getResource("/Pics/Tom.png")));
					} else {
						btn19.setIcon(new ImageIcon(game.class.getResource("/Pics/" + player + ".png")));
					}
				}	
			}
		});
		btn19.setBounds(655, 496,  99, 148);
		btn19.setIcon(new ImageIcon(game.class.getResource("/Pics/Tom.png")));
		btn19.setOpaque(false);
		btn19.setContentAreaFilled(false);
		btn19.setBorderPainted(false);
		pnlgame.add(btn19);
		
		JLabel lblYourCharacter = new JLabel("Your Character");
		lblYourCharacter.setForeground(Color.WHITE);
		lblYourCharacter.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblYourCharacter.setBounds(25, 97, 105, 16);
		pnlgame.add(lblYourCharacter);
		
		JLabel lblCpusCharacter = new JLabel("CPU's Character");
		lblCpusCharacter.setForeground(Color.WHITE);
		lblCpusCharacter.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblCpusCharacter.setBounds(796, 97, 108, 16);
		pnlgame.add(lblCpusCharacter);
		
		btnPlay.addActionListener(new ActionListener() {
			int clicked;
			public void actionPerformed(ActionEvent arg0) {
			
				clicked++;
				Random rnd = new Random();
				
				if (clicked == 1) {
					pnlhome.setVisible(false);
					pnlrule.setVisible(true);
					pnlgame.setVisible(false);
					
				} else {
					Object[] colour = {"Red", "Blue"};
					String s = (String)JOptionPane.showInputDialog(
					                    frame,
					                    "Colour:",
					                    "Choose Colour",
					                    JOptionPane.INFORMATION_MESSAGE,
					                    null,
					                    colour,
					                    "Red");
					
					if (s != null) {
						
						pnlhome.setVisible(false);
						pnlrule.setVisible(false);
						pnlgame.setVisible(true);
						label_4.setVisible(false);
						label_5.setVisible(false);
						label_6.setVisible(false);
						player = s;
						player_char = 0;
						answer = new String[10];
						questions (questions, people);
						quesnum = 0;
						if (player.equals("Red")) {
							pnlgame.setBackground(new Color(125, 0, 0));
						} else {
							pnlgame.setBackground(new Color(0, 0, 102));
						}
						lblturn.setText("Click a Character to Select Your Character");
						declare(chars);
						cpu_choice = chars.get(rnd.nextInt(18-0));
						System.out.println("CPU: " + cpu_choice[0]);
						btnNext.setEnabled(false);
						btnAsk.setEnabled(false);
						btnGuess.setEnabled(false);
					}
				}	
			}
		});
		
		btnAsk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					String s = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Question:",
		                    "Ask Question",
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,
		                    people,
		                    "Alice");
					
					if (s != null) {
						
						if (s.contains("ale")) {
							
							String regex = "?";
							int index = 1;
							skin_check (frame, s, regex, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Skin")) {
							
							String regex = " Skin?";
							int index = 2; 
							skin_check (frame, s, regex, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Hair")) {
							
							String regex = " Hair?";
							int index = 3;
							skin_check (frame, s, regex, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Bald")) {
							
							int index = 4;
							check (frame, s, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Hat")) {
							
							int index = 5;
							check (frame, s, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Earrings")) {
							
							int index = 7;
							check (frame, s, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Glasses")) {
							
							int index = 6;
							check (frame, s, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Mustache")) {
							
							int index = 8;
							check (frame, s, index);
							reorg (questions, s, people);
							
						} else if (s.contains("Beard")) {
							
							int index = 9;
							check (frame, s, index);
							reorg (questions, s, people);
						} 
						if (questions.size() == 0) {
							
							lblturn.setText("All Questions Asked. Guess the Character!");
							btnAsk.setEnabled(false);
						} 	
						btnAsk.setEnabled(false);
						btnGuess.setEnabled(false);
						btnNext.setEnabled(true);
						lblturn.setText("Flip Characters to Hide Then Press Next     !");
						label_4.setVisible(false);
						label_5.setVisible(false);
						label_6.setVisible(true);
				}
			}
		});
		
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] colour = {"Alice", "Anita", "Anne", "Art", "Bill", "Bob", "Brian", "Carol", "David", "Eric", "Frank", "Henry", "Jill", "Mike", "Paul", "Phil", "Sam", "Susan", "Tom"};
				String s = (String)JOptionPane.showInputDialog(
				                    frame,
				                    "Characters:",
				                    "Guess Character",
				                    JOptionPane.INFORMATION_MESSAGE,
				                    null,
				                    colour,
				                    "Alice");
				if (s != null) {
					
					if (s.equals(cpu_choice[0])) {
						lblcpu.setIcon(new ImageIcon(game.class.getResource("/Pics/" + cpu_choice[0] + ".png")));
						JOptionPane.showMessageDialog(frame,
							    "You Win! You Guessed the Correct Character.");
						game_over = true;
						btnHome.doClick();
					} else {
						lblcpu.setIcon(new ImageIcon(game.class.getResource("/Pics/" + cpu_choice[0] + ".png")));
						JOptionPane.showMessageDialog(frame,
								"You Lose! You Guessed the Incorrect Character.\n"
								+ "CPU's character was " + cpu_choice[0] + ".",
							    "Game Lost",
							    JOptionPane.ERROR_MESSAGE);
						game_over = true;
						btnHome.doClick();
					}
					//btnNext.setEnabled(false);
					btnAsk.setEnabled(false);
					btnGuess.setEnabled(false);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean ask = false;
				int index; 
				String trait; 
				quesnum++;
				
				if (chars.size() == 1) {
					ask = true;
					ask(frame, chars, ask, lblcpu);
					game_over = true;
					btnHome.doClick();
					for (int i=0; i<chars.size(); i++) {
						System.out.println(chars.get(i)[0]);
					}
				} else {
					if (quesnum == 1) {
								
						index = quesnum;
						String value = ""; 
						int n = JOptionPane.showConfirmDialog(frame,
							    "Is your character a male?",
							    "CPU Question",
							    JOptionPane.YES_NO_OPTION);
						if ( n == 1) {
							value = "Male";
							check(index, value, chars);
							answer[0]="Female";
						} else {
							value = "Female";
							check(index, value, chars);
							answer[0]="Male";
						}
						System.out.println(answer[0]);
					} 
					if (quesnum == 2) {
								
						if (answer[0].equals("Female")) {
								
							index = 5;
							trait = "Is your character wearing a hat?";
							trait (chars, frame, answer, index, trait);
						}
						if (answer[0].equals("Male")) {
							
							index = quesnum;
							String value = ""; 
							int n = JOptionPane.showConfirmDialog(frame,
								    "Is your character dark skinned?",
								    "CPU Question",
								    JOptionPane.YES_NO_OPTION);
							if ( n == 1) {
								value = "Dark";
								check(index, value, chars);
								answer[1]="Light";
							} else {
								value = "Light";
								check(index, value, chars);
								answer[1]="Dark";
							}
						}	
					}
					if (quesnum == 3) {
								
						if (answer[0].equals("Female")) {
								
							index = 6;
							trait = "Is your character wearing glasses?";
							trait (chars, frame, answer, index, trait);
						}
						if (answer[0].equals("Male")) {
							
							index = 4;
							trait = "Is your character bald?";
							trait (chars, frame, answer, index, trait);
						}	
					}
					if (quesnum == 4) {
								
						if (answer[0].equals("Female")) {
									
							index = 7;
							trait = "Is your character wearing earrings?";
							trait (chars, frame, answer, index, trait);
						}
						if (answer[0].equals("Male") &&  answer[1].equals("Dark")  &&  answer[4].equals("No")) {
						
							index = 8;
							trait = "Does your character have a mustache?";
							trait (chars, frame, answer, index, trait);
						}	
						if (answer[0].equals("Male") &&  answer[1].equals("Light")) {
								
							index = 6;
							trait = "Is your character wearing glasses?";
							trait (chars, frame, answer, index, trait);
							}	
					}
					if (quesnum == 5) {
								
						if (answer[0].equals("Female") && answer[7].equals("Yes")) {
									
							String hair = "Red";
							hair (chars, frame, answer, hair);
						}
						if (answer[0].equals("Female") && answer[7].equals("No")) {
									
							String hair = "Blonde";
							hair (chars, frame, answer, hair);
						}
						if (answer[0].equals("Male") &&  answer[4].equals("Yes")) {
								
							String hair = "Black";
							hair (chars, frame, answer, hair);
						}	
						if (answer[0].equals("Male") &&  answer[4].equals("No")) {
							
							index = 9;
							trait = "Does your chacter have a beard?";
							trait (chars, frame, answer, index, trait);
						}	
					}
					if (quesnum == 6) {
								
						index = 8;
						trait = "Does your character have a mustache?";
						trait (chars, frame, answer, index, trait);
					}	
					if (quesnum == 7) {
						
						index = 5;
						trait = "Is your character wearing a hat?";
						trait (chars, frame, answer, index, trait);
					}	
					if (quesnum == 8) {
								
						String hair =  null;
						if (answer[5].equals("Yes")) { 
							hair = "Brown";
						}
						if (answer[5].equals("No")) { 
							hair = "Red";
						}
						hair (chars, frame, answer, hair);
					}
					btnAsk.setEnabled(true);
					btnGuess.setEnabled(true);
					btnNext.setEnabled(false);
					lblturn.setText("Ask a Question      or Guess a Character     !");
					label_4.setVisible(true);
					label_5.setVisible(true);
					label_6.setVisible(false);
				}	
			}
		});
		
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				home(pnlhome, pnlgame, pnlrule, game_over);
				lblplayer.setIcon(null);
				lblcpu.setIcon(null);
				 b01 = 0; b02 = 0;  b03 = 0; b04 = 0; b05 = 0; b06 = 0; b07 = 0; b08 = 0; b09 = 0; b10 = 0;
				 b11 = 0; b12 = 0;  b13 = 0; b14 = 0; b15 = 0; b16 = 0; b17 = 0; b18 = 0; b19 = 0; 
				 btn1.setIcon(new ImageIcon(game.class.getResource("/Pics/Alice.png"))); btn11.setIcon(new ImageIcon(game.class.getResource("/Pics/Frank.png")));
				 btn2.setIcon(new ImageIcon(game.class.getResource("/Pics/Anita.png"))); btn12.setIcon(new ImageIcon(game.class.getResource("/Pics/Henry.png")));
				 btn3.setIcon(new ImageIcon(game.class.getResource("/Pics/Anne.png"))); btn13.setIcon(new ImageIcon(game.class.getResource("/Pics/Jill.png")));
				 btn4.setIcon(new ImageIcon(game.class.getResource("/Pics/Art.png"))); btn14.setIcon(new ImageIcon(game.class.getResource("/Pics/Mike.png")));
				 btn5.setIcon(new ImageIcon(game.class.getResource("/Pics/Bill.png"))); btn15.setIcon(new ImageIcon(game.class.getResource("/Pics/Paul.png")));
				 btn6.setIcon(new ImageIcon(game.class.getResource("/Pics/Bob.png"))); btn16.setIcon(new ImageIcon(game.class.getResource("/Pics/Phil.png")));
				 btn7.setIcon(new ImageIcon(game.class.getResource("/Pics/Brian.png"))); btn17.setIcon(new ImageIcon(game.class.getResource("/Pics/Sam.png")));
				 btn8.setIcon(new ImageIcon(game.class.getResource("/Pics/Carol.png"))); btn18.setIcon(new ImageIcon(game.class.getResource("/Pics/Susan.png")));
				 btn9.setIcon(new ImageIcon(game.class.getResource("/Pics/David.png"))); btn19.setIcon(new ImageIcon(game.class.getResource("/Pics/Tom.png")));
				 btn10.setIcon(new ImageIcon(game.class.getResource("/Pics/Eric.png")));
			}
		});
		
		btnSound.addActionListener(new ActionListener() {
			int clicked;
			private Clip activeclip;
			public void actionPerformed(ActionEvent arg0) {
				
				clicked++;
				if ( (clicked & 1) == 0) {
					
					activeclip.stop();	
					btnSound.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundoff.png")));
					btnSound2.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundoff.png")));
			
				} else {		
					try {
						Clip clip =  AudioSystem.getClip();
						AudioInputStream inputStream = AudioSystem.getAudioInputStream(game.class.getResource("/Music/music.wav"));
						clip.open(inputStream);
						clip.loop(Clip.LOOP_CONTINUOUSLY);
						clip.start();
						activeclip = clip;
						btnSound.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundon.png")));
						btnSound2.setIcon(new ImageIcon(game.class.getResource("/Buttons/soundon.png")));
						
				          
				    } catch (Exception e) {
				          System.err.println(e.getMessage());
				    }
				}
				
				
			}
		});
		
		btnSound2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnSound.doClick();
			}
		});
		
		btnRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pnlhome.setVisible(false);
				pnlrule.setVisible(true);
				pnlgame.setVisible(false);
			}
		});
		
		tglbtnUiGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(tglbtnUiGuide.isSelected())
			        {
					 	tglbtnUiGuide.setText("Click for UI Guide");
					 	label_1.setIcon(new ImageIcon(game.class.getResource("/Pics/gamerules.png")));
			        }
			        else
			        {
			        	tglbtnUiGuide.setText("Click for Game Rules");
					 	label_1.setIcon(new ImageIcon(game.class.getResource("/Pics/UIguide.png")));
			        }
			}
		});
		
		btnHome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome.doClick();
			}
		});
		
		btnPlay2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlay.doClick();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	private void choose (String who, JLabel lblplayer, JLabel lblcpu, JLabel lblturn, JButton btnAsk, JButton btnGuess, JLabel label_4, JLabel label_5) {
		
		player_char++;
		if (player_char == 1) {
			character = who;
			lblplayer.setIcon(new ImageIcon(game.class.getResource("/Pics/" + who + ".png")));
			if (player.equals("Red")) {
				lblcpu.setIcon(new ImageIcon(game.class.getResource("/Pics/Blue.png")));
			} else {
				lblcpu.setIcon(new ImageIcon(game.class.getResource("/Pics/Red.png")));
			}
			lblturn.setText("Ask a Question      or Guess a Character     !");
			btnAsk.setEnabled(true);
			btnGuess.setEnabled(true);
			label_4.setVisible(true);
			label_5.setVisible(true);
		} 
	}
	
	public void home (JPanel pnlhome, JPanel pnlgame, JPanel pnlrule, boolean game_over) {
		int j;
		if (game_over == false) {
			j = JOptionPane.showConfirmDialog(frame,
				    "Are you sure you would like to exit?",
				    "Comfirm",
				    JOptionPane.WARNING_MESSAGE,
				    JOptionPane.YES_NO_OPTION);
		} else {
			j = JOptionPane.YES_OPTION;
		}	
		
		if (j == JOptionPane.YES_OPTION) {
			pnlhome.setVisible(true);
			pnlrule.setVisible(false);
			pnlgame.setVisible(false);
		}
	}
	
	public static void declare (ArrayList<String[]> chars) {
		
		chars.clear();
		//                        Name      Gender      Skin     Hair       Bald   Hat    Glass  Earr   Mous   Beard
		chars.add( new String [] {"Alice", 	"Female", 	"Light", "Red", 	"No",  "No",  "No",  "Yes", "No",  "No"});
		chars.add( new String [] {"Anita", 	"Female", 	"Light", "Blonde", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Anne",  	"Female", 	"Light", "Black", 	"No",  "No",  "No",  "Yes", "No",  "No"});
		chars.add( new String [] {"Art",	"Male", 	"Dark",  "Black", 	"No",  "No",  "No",  "No",  "Yes", "No"});
		chars.add( new String [] {"Bill", 	"Male", 	"Dark",  "Black", 	"Yes", "No",  "No",  "No",  "Yes", "Yes"});
		chars.add( new String [] {"Bob",	"Male", 	"Light", "Brown", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Brian", 	"Male", 	"Light", "Brown", 	"No",  "Yes", "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Carol", 	"Female", 	"Light", "Red", 	"No",  "Yes", "Yes", "Yes", "No",  "No"});
		chars.add( new String [] {"David", 	"Male", 	"Light", "Blonde",	"No",  "No",  "No",  "No",  "No",  "Yes"});
		chars.add( new String [] {"Eric", 	"Male", 	"Light", "Blonde", 	"No",  "Yes", "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Frank", 	"Male", 	"Light", "Red", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Henry", 	"Male", 	"Light", "Red", 	"Yes", "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Jill", 	"Female", 	"Light", "Blonde", 	"No",  "No",  "Yes", "Yes", "No",  "No"});
		chars.add( new String [] {"Mike", 	"Male", 	"Light", "Brown", 	"No",  "No",  "No",  "No",  "Yes", "No"});
		chars.add( new String [] {"Paul", 	"Male", 	"Light", "White", 	"No",  "No",  "Yes", "No",  "No",  "No"});
		chars.add( new String [] {"Phil", 	"Male", 	"Dark",  "Black", 	"No",  "No",  "No",  "No",  "No",  "Yes"});
		chars.add( new String [] {"Sam", 	"Male", 	"Light", "White", 	"Yes", "No",  "Yes", "No",  "No",  "No"});
		chars.add( new String [] {"Susan", 	"Female", 	"Light", "White", 	"No",  "No",  "No",  "No",  "No",  "No"});
		chars.add( new String [] {"Tom", 	"Male", 	"Light", "Black", 	"Yes", "No",  "Yes", "No",  "No",  "No"});
		
	}
	
	public static void questions (ArrayList<String> questions, String[] people) {
		
		questions.clear();
		questions.add("Male?"); 		questions.add("Female?");
		questions.add("Light Skin?"); 	questions.add("Dark Skin?");
		questions.add("Black Hair?"); 	questions.add("Brown Hair?"); 
		questions.add("Red Hair?"); 	questions.add("Blonde Hair?"); 
		questions.add("White Hair?"); 	questions.add("Bald?");
		questions.add("Hat?"); 			questions.add("Glasses?"); 
		questions.add("Earrings?"); 	questions.add("Mustache?"); 
		questions.add("Beard?");
		
		people = questions.toArray(people);
	}
		
	public static void trait (ArrayList<String[]> chars, JFrame frame, String[] answer, int index, String trait) {
		
		String value="";
		int n = JOptionPane.showConfirmDialog(frame,
			    trait,
			    "CPU Question",
			    JOptionPane.YES_NO_OPTION);
		if ( n == 1) {
			value = "Yes";
			check(index, value, chars);
			answer[index]="No";
		} else {
			value = "No";
			check(index, value, chars);
			answer[index]="Yes";
		}
		System.out.println(chars.size());
	}
	
	public static void hair (ArrayList<String[]> chars, JFrame frame, String[] answer, String hair) {
		
		int index = 3;
		String value = hair;
		int n = JOptionPane.showConfirmDialog(frame,
			    "Does your character have " + hair + " hair?",
			    "CPU Question",
			    JOptionPane.YES_NO_OPTION);
		if ( n == 1) {
			value = hair;
			check(index, value, chars);
			
		} else {
			for (int i=0; i<chars.size(); i++) {
				if (!(chars.get(i))[index].equals(value)) {
					chars.set(i, null);
				}
			}
			chars.removeAll(Collections.singleton(null));
		}
		System.out.println(chars.size());
	}
	
	public static void check (int index, String value, ArrayList<String[]> chars) {
		
		for (int i=0; i<chars.size(); i++) {
			if ((chars.get(i))[index].equals(value)) {
				chars.set(i, null);
			}
		}
		chars.removeAll(Collections.singleton(null));
	}
	
	public static void ask(JFrame frame, ArrayList<String[]> chars, boolean ask, JLabel lblcpu) {
		
		if (ask == true) {
			int n;// = 100;
			String character = null;
			if (chars.size() == 1) { 
				character = chars.get(0)[0];
			}	
			n = JOptionPane.showConfirmDialog(frame,
				"Are you " + character + "?",
				"Answer",
				JOptionPane.YES_NO_OPTION);
			
			lblcpu.setIcon(new ImageIcon(game.class.getResource("/Pics/" + cpu_choice[0] + ".png")));
			if (n == 1) {
				
				JOptionPane.showMessageDialog(frame,
					    "You Win! The CPU guessed wrong.");
				
			} else {
				
				JOptionPane.showMessageDialog(frame,
						"You Lose! The CPU guessed correctly.",
					    "Game Lost",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private static void reorg (ArrayList<String> questions, String s, String[] people) {
		
		for (int i = 0; i < questions.size(); i++)
		{
		    if (questions.get(i).equals(s))
		    {
		       questions.remove(i);
		       people = questions.toArray(people);
		       break;
		    }
		}
	}
	
	private static void check (JFrame frame, String s, int index) {
		
		if (cpu_choice[index].equals("Yes")) {
			
			JOptionPane.showMessageDialog(frame,
					"<html><table><tr><td>Question:</td><td><font color='blue'>" + s + 
					"</td></tr><tr><td>Answer:</td><td><font color='green'>YES</td></tr></table></html>",
				    "CPU's Answer",
				    JOptionPane.INFORMATION_MESSAGE);
			
		} else if (cpu_choice[index].equals("No")) {
			
			JOptionPane.showMessageDialog(frame,
					"<html><table><tr><td>Question:</td><td><font color='blue'>" + s + 
					"</td></tr><tr><td>Answer:</td><td><font color='red'>NO</td></tr></table></html>",
				    "CPU's Answer",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private static void skin_check (JFrame frame, String s, String regex, int index) {
		
		if (cpu_choice[index].equals(s.replace(regex,  ""))) {
			
			JOptionPane.showMessageDialog(frame,
				    "<html><table><tr><td>Question:</td><td><font color='blue'>" + s + 
				    "</td></tr><tr><td>Answer:</td><td><font color='green'>YES</td></tr></table></html>",
				    "CPU's Answer",
				    JOptionPane.INFORMATION_MESSAGE);
			
		} else if (!cpu_choice[index].equals(s.replace(regex,  ""))) {
			
			JOptionPane.showMessageDialog(frame,
					"<html><table><tr><td>Question:</td><td><font color='blue'>" + s + 
					"</td></tr><tr><td>Answer:</td><td><font color='red'>NO</td></tr></table></html>",
				    "CPU's Answer",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
