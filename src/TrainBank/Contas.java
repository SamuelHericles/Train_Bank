package TrainBank;

    public class Contas{
        private String nome;
        private int numero;
        private double saldo;

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    
    }
        
    public void depositar(double valor){
        this.saldo +=valor;

    }
    
    public boolean sacar(double valor){
        if(valor <= this.saldo){
            this.saldo-=valor;
            return true;
        }            
        return false;
    }
    
    public void tranferir(Contas conta01,double valor){
                this.sacar(valor);
                if(valor<=this.saldo){
                    conta01.depositar(valor);
                }
        }  
       
    public void tipoConta(){
          System.out.println("Tipo de conta: comum");   
      }
    }