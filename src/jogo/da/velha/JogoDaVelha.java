package jogo.da.velha;//Aqui fica um conjunto de classes, de maneira tipificada e hierarquica.
import java.awt.event.ActionEvent;//Aqui quer dizer o que ocorre um evento quando um botão é clickado.
import javax.swing.*;//Fornece interfaces que permitem o desenvolvimento de métodos de entrada que podem ser usados ​​com qualquer ambiente de tempo de execução Java.
public class JogoDaVelha extends JFrame {
	JButton[] bt = new JButton[9];//Quantos botoes terá no nosso jogo
	JLabel placar = new JLabel("Placar");// Escrita do placar para mostrar o resultado do jogo
	JLabel px = new JLabel("X 0");// Quantas vezes o X ganhou
	JLabel po = new JLabel("O 0");//Quantas vezes o Y ganhou
	int PX = 0;//Variavel do X para pontuar
	int PO = 0;//Variavel do Y para pontuar
	JButton novo = new JButton("Novo jogo");//Botão do Novo jogo
	JButton zerar = new JButton("Zerar");// Botão do Zerar
	boolean xo = false;
	boolean[] click = new boolean[9];//Aqui é a quantidade de "Clicks"
	
	public JogoDaVelha() {
		setVisible(true);
		setTitle("jogo da velha");// título da janela
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(250,100,700,500);
		add(placar);
		add(px);
		add(po);
		add(novo);
		add(zerar);
		placar.setBounds(400,50,100,30);//Tamanho do placar
		px.setBounds(400,75,100,30);//Tamanho do botão 
		po.setBounds(450,75,100,30);//Tamanho do botão 
		novo.setBounds(425,100,140,30);//Tamanho do botão novo
		zerar.setBounds(425,125,140,30);//Tamanho do botao zerar
		novo.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				limpar();
			}
		});
		zerar.addActionListener(new java.awt.event.ActionListener(){//Aqui é a função de zerar o placar sendo assim a variavel Px fica com 0 e a variavel PO fica com 0 
			@Override
			public void actionPerformed(ActionEvent ae) {
				PO =0;
				PX = 0;
				atualizar();
				//Todo o conceito de true or false, é para entender que quando o X for acionado ele pode ser produzido no sentindo matematico, no qual consegue estabelecer uma linha sequencial hierarquica.
				
			}
		});
		int cont = 0;
		for (int  i =0; i < 3; i++) {
			for (int j = 0; j<3; j++ ) {
				bt[cont] =new JButton();//criação do quadrados do jogo da velha
				add(bt[cont]);
				bt[cont].setBounds((100 * i)+ 50, (100*j)+ 50, 95 ,95);//tamanho dos quadradros do jogo da vela
				cont++;
			}
		}
		for (int i=0;i<9; i++ ) {//contagem de repetição, no caso possui o valor 9 como repetição pois o máximo de jogadas são 9.
			click[i] = false;
	}
	
		bt[0].addActionListener(new java.awt.event.ActionListener(){//posição do primeiro traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[0]==false) {
					click[0]=true;
					mudar(bt[0]);
				}
			}
		});
		bt[1].addActionListener(new java.awt.event.ActionListener(){//posição do segundo traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[1]==false) {
					click[1]=true;
					mudar(bt[1]);
				}
			}
		});
		bt[2].addActionListener(new java.awt.event.ActionListener(){//posição do terceiro traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[2]==false) {
					click[2]=true;
					mudar(bt[2]);
				}
			}
		});
		bt[3].addActionListener(new java.awt.event.ActionListener(){//posição do quarto traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[3]==false) {
					click[3]=true;
					mudar(bt[3]);
				}
			}
		});
		bt[4].addActionListener(new java.awt.event.ActionListener(){//posição do quinto traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[4]==false) {
					click[4]=true;
					mudar(bt[4]);
				}
			}
		});
		bt[5].addActionListener(new java.awt.event.ActionListener(){//posição do sexto traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[5]==false) {
					click[5]=true;
					mudar(bt[5]);
				}
			}
		});
		bt[6].addActionListener(new java.awt.event.ActionListener(){//posição do sétimo traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[6]==false) {
					click[6]=true;
					mudar(bt[6]);
				}
			}
		});
		bt[7].addActionListener(new java.awt.event.ActionListener(){//posição do oitavo traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[7]==false) {
					click[7]=true;
					mudar(bt[7]);
				}
			}
		});
		bt[8].addActionListener(new java.awt.event.ActionListener(){//posição do nono traço da velha, e faz com que o X ou Ofique fixo até o fim da rodada
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[8]==false) {
					click[8]=true;
					mudar(bt[8]);
				}
			}
		});
	}
	
public void mudar(JButton btn) {//Aqui é pra intercalar as jogadas, quando xo for false então vai se transformar em true e vice-versa.
	if(xo) {
		btn.setText("O");
		xo = false;			
	}else {
		btn.setText("X");
		xo = true;
		
	}
	ganhou();
}
public void atualizar() {//Aqui serve para quando o X ou o O ganhar, atualizar o placar.
	px.setText("X "+ PX);
	po.setText("O "+ PO);
}

public void ganhou() {//Aqui quando uma das peças venceram poder reiniciar o jogo.
	int cont =0;
	for (int i=0;i<9; i++ ) {
		if (click[i]==true) {
			cont++;
		}
	}
	
	if((bt[0].getText()== "X" && bt[1].getText()== "X" && bt[2].getText()== "X")//Aqui mostra TODAS as possibilidades do X ganhar
			||(bt[3].getText()== "X" && bt[4].getText()== "X" && bt[5].getText()== "X")
			||(bt[6].getText()== "X" && bt[7].getText()== "X" && bt[8].getText()== "X")
			||(bt[0].getText()== "X" && bt[3].getText()== "X" && bt[6].getText()== "X")
			||(bt[1].getText()== "X" && bt[4].getText()== "X" && bt[7].getText()== "X")
			||(bt[2].getText()== "X" && bt[5].getText()== "X" && bt[8].getText()== "X")
			||(bt[0].getText()== "X" && bt[4].getText()== "X" && bt[8].getText()== "X")
			||(bt[6].getText()== "X" && bt[4].getText()== "X" && bt[2].getText()== "X")) { 
		JOptionPane.showMessageDialog(null, "X ganhou");//O que é pra mostrar assim que o X ganhar
		PX++;//Adicionar a pontuação do X
		atualizar();//Atualizar a pontuação
		limpar();//Aqui é o ultima opção de jogo, quando da empate 
	}else if((bt[0].getText()== "O" && bt[1].getText()== "O" && bt[2].getText()== "O")//Aqui mostra TODAS as possibilidades do O ganhar
			||(bt[3].getText()== "O" && bt[4].getText()== "O" && bt[5].getText()== "O")
			||(bt[6].getText()== "O" && bt[7].getText()== "O" && bt[8].getText()== "O")
			||(bt[0].getText()== "O" && bt[3].getText()== "O" && bt[6].getText()== "O")
			||(bt[1].getText()== "O" && bt[4].getText()== "O" && bt[7].getText()== "O")
			||(bt[2].getText()== "O" && bt[5].getText()== "O" && bt[8].getText()== "O")
			||(bt[0].getText()== "O" && bt[4].getText()== "O" && bt[8].getText()== "O")
			||(bt[6].getText()== "O" && bt[4].getText()== "O" && bt[2].getText()== "O")) { 
		JOptionPane.showMessageDialog(null, "O ganhou");//O que é pra mostrar assim que o O ganhar
		PO++;//Adicionar a pontuação do O
		atualizar();//Atualizar a pontuação
		limpar();//Tirar os botoes para a prox rodada
	}else if (cont ==9) {//Aqui é o ultima opção de jogo, quando da empate 
		JOptionPane.showMessageDialog(null, "Deu empate");
		limpar();
	}
	
}
	public void limpar () {//Aqui tem a função que assim que acabar a rodada, limpar todos os X e O feitos no jogo
		for (int i=0;i<9; i++ ) {
			bt[i].setText("");
			click[i]= false;
	}
	
		
	}
	public static void main(String[] args) {//Aqui é onde realmente roda o jogo.
		new JogoDaVelha();
		

	}

}


