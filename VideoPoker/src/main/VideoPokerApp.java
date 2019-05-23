package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carta.Baralho;
import carta.Mao;
import excessao.ETException;
import util.EntradaTeclado;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics2D;

public class VideoPokerApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField txtDigiteOValor;
	
	public static double aposta;
	private JTextField saldo;
	public double saldoDouble;
	int rodada;
	Baralho baralho;
	Mao mao;
	
	boolean apostado = false;
	
	int num_trocas;
	
	static JToggleButton card1;
	static JToggleButton card2;
	static JToggleButton card3;
	static JToggleButton card4;
	static JToggleButton card5;
	private JTextField txtRodada;
	private JTextField numeroRodada;
	private JTextField txtTrocaN;
	private JTextField numeroTroca;
	private JTextField txtVocGanhou;
	private JTextField txtBonus;
	JTextArea txtrGameOver;
	
	//private GuiScreen screen;
	
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		VideoPokerApp frame = new VideoPokerApp();
		frame.setSize(1000, 700);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.game(); //começa o jogo
		
		
	}

	/**
	 * Create the frame.
	 */
	public VideoPokerApp() {
	
		super("THE VIDEO POKER GAME - Special Edition! (by Michelle Wingter)");
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 0));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrGameOver = new JTextArea();
		txtrGameOver.setForeground(new Color(0, 0, 0));
		txtrGameOver.setBackground(new Color(204, 51, 51));
		txtrGameOver.setEditable(false);
		txtrGameOver.setFont(new Font("Viner Hand ITC", Font.BOLD, 70));
		txtrGameOver.setText("GAME OVER!\r\n SEU SALDO\r\n  ACABOU!");
		txtrGameOver.setBounds(238, 208, 493, 332);
		contentPane.add(txtrGameOver);
		txtrGameOver.setEditable(false);
		txtrGameOver.setVisible(false);
		
				
		txtBonus = new JTextField();
		txtBonus.setFont(new Font("Tahoma", Font.BOLD, 40));
		txtBonus.setText("$ 0");
		txtBonus.setHorizontalAlignment(SwingConstants.CENTER);
		txtBonus.setForeground(new Color(255, 0, 0));
		txtBonus.setBounds(384, 494, 218, 59);
		contentPane.add(txtBonus);
		txtBonus.setColumns(10);
		txtBonus.setEditable(false);
		
				
		// =============== CARTAS ===================================
		card1 = new JToggleButton("");
		card1.setBounds(84, 210, 140, 190);
		contentPane.add(card1);
			
		card2 = new JToggleButton("");
		card2.setBounds(253, 210, 140, 190);
		contentPane.add(card2);
		
		card3 = new JToggleButton("");
		card3.setBounds(421, 210, 140, 190);
		contentPane.add(card3);
		
		card4 = new JToggleButton("");
		card4.setBounds(591, 210, 140, 190);
		contentPane.add(card4);
		
		card5 = new JToggleButton("");
		card5.setBounds(756, 210, 140, 190);
		contentPane.add(card5);
		//===========================================================
		
		//botão de aceitar trocar as cartas selecionadas
		JButton TrocarCartas = new JButton("APOSTAR");
		
		saldo = new JTextField();
		saldo.setFont(new Font("Tahoma", Font.BOLD, 25));
		saldo.setBounds(807, 469, 103, 40);
		contentPane.add(saldo);
		saldo.setColumns(10);
		saldo.setEditable(false);

		
		txtDigiteOValor = new JTextField();
		txtDigiteOValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDigiteOValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigiteOValor.setBounds(290, 501, 103, 39);
		contentPane.add(txtDigiteOValor);
		txtDigiteOValor.setColumns(10);
		txtDigiteOValor.setText("0");
		
		TrocarCartas.setFont(new Font("Tahoma", Font.BOLD, 25));
		TrocarCartas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String apostaStr = txtDigiteOValor.getText();
				aposta = Double.parseDouble(apostaStr);
				System.out.println("Apostando: " + aposta + " , saldo = " + saldoDouble);
			}
		});
		TrocarCartas.setBounds(413, 497, 159, 43);
		contentPane.add(TrocarCartas);
		
		//imagem da ficha de poker
		JLabel CoinImg = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/moedaP.png")).getImage();
		CoinImg.setIcon(new ImageIcon(img));
		CoinImg.setBounds(756, 468, 45, 41);
		contentPane.add(CoinImg);
		

		
		JTextPane txtpnValorDaAposta = new JTextPane();
		txtpnValorDaAposta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnValorDaAposta.setBackground(new Color(51, 102, 0));
		txtpnValorDaAposta.setText("Valor da aposta:");
		txtpnValorDaAposta.setBounds(134, 501, 153, 39);
		contentPane.add(txtpnValorDaAposta);
		
		JLabel logoPoker = new JLabel("");
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logoVP.png")).getImage();
		logoPoker.setIcon(new ImageIcon(imgLogo));
		logoPoker.setBackground(new Color(255, 255, 255));
		logoPoker.setBounds(25, 13, 280, 165);
		contentPane.add(logoPoker);
		
		JTextPane txtpnMinhasMoedas = new JTextPane();
		txtpnMinhasMoedas.setText("SALDO");
		txtpnMinhasMoedas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnMinhasMoedas.setBackground(new Color(51, 102, 0));
		txtpnMinhasMoedas.setBounds(775, 430, 78, 39);
		contentPane.add(txtpnMinhasMoedas);
		
		JTextArea txtrcombinaes = new JTextArea();
		txtrcombinaes.setForeground(Color.WHITE);
		txtrcombinaes.setBackground(new Color(51, 102, 0));
		txtrcombinaes.setText("_________________________COMBINA\u00C7\u00D5ES_______________________\r\nDois pares............................................................................................................. 1 X\t\t  \r\nTrinca...................................................................................................................... 2 X\t  \r\nStraight................................................................................................................... 5 X\t  \r\nFlush...................................................................................................................... 10 X  \r\nFull hand............................................................................................................... 20 X\r\nQuadra.................................................................................................................. 50 X\r\nStraight Flush ................................................................................................... 100 X \r\nRoyal Straight Flush........................................................................................ 200 X\t");
		txtrcombinaes.setBounds(439, 13, 543, 184);
		contentPane.add(txtrcombinaes);
		
		txtRodada = new JTextField();
		txtRodada.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRodada.setBackground(new Color(51, 102, 0));
		txtRodada.setText("Rodada:");
		txtRodada.setBounds(308, 447, 64, 22);
		contentPane.add(txtRodada);
		txtRodada.setColumns(10);
		
		numeroRodada = new JTextField();
		numeroRodada.setHorizontalAlignment(SwingConstants.CENTER);
		numeroRodada.setText("0");
		numeroRodada.setBounds(374, 447, 36, 22);
		contentPane.add(numeroRodada);
		numeroRodada.setColumns(10);
		
		JButton btnTrocarCartas = new JButton("TROCAR CARTAS");
		btnTrocarCartas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Trocando as cartas: ");
				
				if(apostado == true) {
					if(card1.isSelected()) {
						System.out.print("1 ");
						baralho.TrocarCarta(mao, 0);	
					}
					if(card2.isSelected()) {
						System.out.print("2 ");
						baralho.TrocarCarta(mao, 1);	
					}
					if(card3.isSelected()) {
						System.out.print("3 ");
						baralho.TrocarCarta(mao, 2);	
					}
					if(card4.isSelected()) {
						System.out.print("4 ");
						baralho.TrocarCarta(mao, 3);	
					}
					if(card5.isSelected()) {
						System.out.print("5 ");
						baralho.TrocarCarta(mao, 4);	
					}
				
					num_trocas++;
					atualizaNumTroca(num_trocas);
					VideoPokerApp.darCartasGUI(mao);
					if(num_trocas == 3) {
						atualizaRodada(rodada);
						
					}
					System.out.println(" e o numero de trocas é " + num_trocas);
				}
			}
		});
		btnTrocarCartas.setBounds(413, 407, 159, 25);
		contentPane.add(btnTrocarCartas);
		
		txtTrocaN = new JTextField();
		txtTrocaN.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTrocaN.setBackground(new Color(51, 102, 0));
		txtTrocaN.setText("Troca n\u00BA:");
		txtTrocaN.setBounds(308, 408, 64, 22);
		contentPane.add(txtTrocaN);
		txtTrocaN.setColumns(10);
		
		numeroTroca = new JTextField();
		numeroTroca.setHorizontalAlignment(SwingConstants.CENTER);
		numeroTroca.setText("0");
		numeroTroca.setBounds(374, 408, 36, 22);
		contentPane.add(numeroTroca);
		numeroTroca.setColumns(10);
		
		txtVocGanhou = new JTextField();
		txtVocGanhou.setHorizontalAlignment(SwingConstants.CENTER);
		txtVocGanhou.setText("Voc\u00EA ganhou:");
		txtVocGanhou.setBounds(384, 469, 218, 26);
		contentPane.add(txtVocGanhou);
		txtVocGanhou.setColumns(10);
		txtVocGanhou.setEditable(false);
		txtBonus.setVisible(false);
		txtVocGanhou.setVisible(false);
		
		

	}
	/**
	 * Converts a given Image into a BufferedImage
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
    private static BufferedImage resize(Image img, int height, int width) {
    	BufferedImage imgB = toBufferedImage(img);
        Image tmp = imgB.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
	public static void darCartasGUI(Mao m) {
		System.out.println("Entrando em darCartasGUI");
		// =============== CARTAS ===================================
		String tipo_carta1 = "/Cards/" + m.get(0).getNaipe() + m.get(0).getValor() + ".png";
		Image img_card1 = new ImageIcon (card1.getClass().getResource(tipo_carta1)).getImage();
		BufferedImage resized = resize(img_card1, 190, 140);
		card1.setIcon(new ImageIcon(resized));
			
		String tipo_carta2 = "/Cards/"  + m.get(1).getNaipe() + m.get(1).getValor() + ".png";
		Image img_card2 = new ImageIcon (card2.getClass().getResource(tipo_carta2)).getImage();
		BufferedImage resized2 = resize(img_card2, 190, 140);
		card2.setIcon(new ImageIcon(resized2));
		
		String tipo_carta3 = "/Cards/"  + m.get(2).getNaipe() + m.get(2).getValor() + ".png";
		Image img_card3 = new ImageIcon (card3.getClass().getResource(tipo_carta3)).getImage();
		BufferedImage resized3 = resize(img_card3, 190, 140);
		card3.setIcon(new ImageIcon(resized3));

		String tipo_carta4 = "/Cards/"  + m.get(3).getNaipe() + m.get(3).getValor() + ".png";
		Image img_card4 = new ImageIcon (card4.getClass().getResource(tipo_carta4)).getImage();
		BufferedImage resized4 = resize(img_card4, 190, 140);
		card4.setIcon(new ImageIcon(resized4));
		
		String tipo_carta5 = "/Cards/"  + m.get(4).getNaipe() + m.get(4).getValor() + ".png";
		Image img_card5 = new ImageIcon (card5.getClass().getResource(tipo_carta5)).getImage();
		BufferedImage resized5 = resize(img_card5, 190, 140);
		card5.setIcon(new ImageIcon(resized5));

		//===========================================================
	}
	
	public void atualizaSaldo(Double s) {
		String saldoStr = "$ " + Double.toString(s);
		saldo.setText(saldoStr);
	}
	
	public void atualizaRodada(int round) {
		String roundStr = Integer.toString(round);
		numeroRodada.setText(roundStr);
	}
	public void atualizaNumTroca(int trocas) {
		String s = Integer.toString(trocas);
		numeroTroca.setText(s);
	}
	public void atualizaBonus(int b) throws InterruptedException {
		txtBonus.setVisible(true);
		txtVocGanhou.setVisible(true);
		
		String s = "$ " + Integer.toString(b);
		txtBonus.setText(s);
		
		TimeUnit.SECONDS.sleep(5);
		txtBonus.setVisible(false);
		txtVocGanhou.setVisible(false);
		
		
	}
	
	public void endGame() {
		
	}
	
	public void game() throws InterruptedException {
		System.out.println("Entrando na game");
		saldoDouble = 200;
		atualizaSaldo(saldoDouble);

		
		rodada = 0;
		atualizaRodada(rodada);
		
		do {
			num_trocas = 0;
			//--------NOVA RODADA--------
			//criando baralho
			baralho = new Baralho();
			//embaralhando o baralho
			baralho.embaralha(baralho.size());
			
			//criando mão
			mao = new Mao(baralho);
			
			
			
			rodada++;
		//	atualizaRodada(rodada);
			//System.out.println("\n###### RODADA " + rodada + " ######");	
			//System.out.printf("Saldo: $%.2f \n", saldoDouble);
			
			
			//fazendo a aposta
			//System.out.println("\nDigite o valor que deseja apostar: ");
			
			aposta = -1;		
			do {
				System.out.println("Verificando aposta = " + aposta);
			}while(aposta < 0 || aposta > saldoDouble);
			apostado = true;
			
			saldoDouble = saldoDouble - aposta;
			atualizaSaldo(saldoDouble);
			

			//System.out.println("Suas cartas são: ");
			//printando a mão
	       // System.out.print("\n");
		//Mao.printaMao(mao);
			VideoPokerApp.darCartasGUI(mao);

			
			
			//PRIMEIRA TROCA
			
			//int option;
		//	System.out.printf("Digite a(s) carta(s) que deseja trocar\n");
			
			//baralho.TrocarCarta(mao, option-1);
			
			//System.out.println("Sua mão atualizada é: ");
			//Mao.printaMao(mao);
			//VideoPokerApp.darCartasGUI(mao);
			
			while(num_trocas < 3) {
				System.out.print("troca " + num_trocas);
			}
			
			
	
			//FIM DA RODADA -- RESULTADOS:
			apostado = false;
			System.out.println("###### FIM DA RODADA " + rodada + " ######\n");
			int bonus = Poker.premio(mao);
			atualizaBonus(bonus);
			
			saldoDouble = saldoDouble + (aposta * bonus); //atualizando o saldo com o premio ganho
			atualizaSaldo(saldoDouble);
			
			//FIM DA RODADA
						
		}while(saldoDouble > 0);
		
		
		System.out.println("Seu saldo acabou!\n FIM DE JOGO!\n");
		txtrGameOver.setVisible(true);
	}
}
