
/*
 * In this class, have the sequences screens for initial TrainBank
 * 
 * */

package TrainBank;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Configuracoes  extends JFrame implements ActionListener{
	
	// All types for the class ''Configuracoes''
	private static final long serialVersionUID = 1L;
	JButton bt1,bt2,bt3,bt4,bt5,bt6;
    Contas conta1;
    ContaPoupanca conta2;
    ContaEspecial conta3;
    String teste;
    
    
    // Constructor of the class,here make the all parameters for popular the Bank
    public Configuracoes(){
    		
      super("Prmeira Janela");
      conta1 = new Contas();
      conta1.setNome(JOptionPane.showInputDialog("Digite o nome do titular da conta comum"));
      conta1.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da conta comum")));
      conta1.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta comum")));
      
      conta2  = new ContaPoupanca();
      conta2.setNome(JOptionPane.showInputDialog("Digite o nome do titular da conta poupanca"));
      conta2.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da conta poupanca")));
      conta2.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta poupanca"))); 
      conta2.setTaxa(Double.parseDouble(teste = JOptionPane.showInputDialog("Digite a taxa de reajuste")));
      

      conta3  = new ContaEspecial();
      conta3.setNome(JOptionPane.showInputDialog("Digite o nome do titular conta especial"));
      conta3.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta especial")));
      conta3.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta especial"))); 
      conta3.setLimite(Integer.parseInt(JOptionPane.showInputDialog("Digite o limite da conta")));
      conta3.setMulta(Double.parseDouble(JOptionPane.showInputDialog("Digite a multa da conta")));
        

      //The buttons and your actions.
	    Container c = getContentPane();
	
	    c.setLayout(new GridLayout(3,2,10,15));
	
	    bt1 = new JButton("SACAR");
	    bt1.addActionListener(this);
	
	    bt2 = new JButton("DEPOSITAR");
	    bt2.addActionListener(this);
	
	    bt3 = new JButton("TRANSFERIR");
	    bt3.addActionListener(this);
	
	    bt4 = new JButton("REAJUSTAR");
	    bt4.addActionListener(this);
	
	    bt5 = new JButton("VER SALDO");
	    bt5.addActionListener(this);
	
	    bt6 = new JButton("SAIR");
	    bt6.addActionListener(this);
	    
	    c.add(bt1);
	    c.add(bt2);
	    c.add(bt3);
	    c.add(bt4);
	    c.add(bt5);
	    c.add(bt6);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	    setLocationRelativeTo(null);
	    setTitle("Selecione a op��oo desejada");
	    setSize(300,200);
	    setVisible(true);

    }// End the constructor class "Configuacoes"
    
    //Treat errors in user inputs
    @Override
    public void actionPerformed(ActionEvent e) {
        /*SACAR*/
            if(e.getSource() == bt1){
                int numero;
                double valor;
                boolean a;
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta->"));
                valor  = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado->"));
                if(numero==conta1.getNumero()){
                    a = conta1.sacar(valor);
                }
                else if(numero==conta2.getNumero()){
                    a = conta2.sacar(valor);
                }
                else if(numero==conta3.getNumero()){
                    a = conta3.descontar(valor, conta3.getMulta());
                }
                else{
                    a = false;
                }
                
                if(a==true){
                    JOptionPane.showMessageDialog(null,"Saque efetuado com sucesso");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Saldo insuficente");               
                }
          }
            /*DEPOSITAR*/
            if(e.getSource() == bt2){
                int numero;
                double valor;

                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta->"));
                valor  = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado->"));
                if(numero==conta1.getNumero()){
                 conta1.depositar(valor);
                }
                if(numero==conta2.getNumero()){
                    conta2.depositar(valor);
                }
                if(numero==conta3.getNumero()){
                   conta3.depositar(valor);
                }
                    JOptionPane.showMessageDialog(null,"Operação com sucesso"); 
          }
          /*TRANSFERIR*/
            if(e.getSource() == bt3){
                int numero1,numero2;
                double valor;
                boolean a = false;
                String a1, a2;
                numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta de inicio->"));
                numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta destino->"));
                valor  = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser transferido->"));
                if(numero1==conta1.getNumero()){
                 a = conta1.sacar(valor);
                 a1 = conta1.getNome();
                }
                if(numero1==conta2.getNumero()){
                    a = conta2.sacar(valor);
                    a1 = conta2.getNome();
                }
                if(numero1==conta3.getNumero()){
                   a = conta3.sacar(valor);
                   a1 = conta3.getNome();
                }
                if(a==true){
                if(numero2==conta1.getNumero()){
                    conta1.depositar(valor);
                    a2 = conta1.getNome();
                }
                if(numero2==conta2.getNumero()){
                    conta2.depositar(valor);
                    a2 = conta2.getNome();
                }
                if(numero2==conta3.getNumero()){
                    conta3.depositar(valor);
                    a2 = conta3.getNome();
                }
                JOptionPane.showMessageDialog(null,"Operação com sucesso");
            }
                else{
                    JOptionPane.showMessageDialog(null,"Operação não concluida");
                
                }
            }
            /*REAJUSTAR*/
            if(e.getSource() == bt4){
                
                if(teste.equals("")){
                    conta2.reajustar();
                }
                else{
                    conta2.reajustar(conta2.getTaxa());
                }
                    JOptionPane.showMessageDialog(null,"Operação com sucesso"); 
          }
           /*VER SALDO*/
            if(e.getSource() == bt5){
                    JOptionPane.showMessageDialog(null,"Conta:"+conta1.getNumero()+"Saldo:"+conta1.getSaldo()+"\nConta:"+conta2.getNumero()+"Saldo:"+conta2.getSaldo()+"\nConta:"+conta3.getNumero()+"Saldo:"+conta3.getSaldo());
            }
            /*SAIR*/
            if(e.getSource() == bt6){
                setVisible(false);
                dispose();
            }      
          }// End treats
    
}// End Class
