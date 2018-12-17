package TrainBank;
public class ContaEspecial extends Contas{
     int limite; 
     double multa;
    

    public int getLimite() {
        return limite;
    }

    public double getMulta() {
        return multa;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    //The "descontar" method form as is discount in looting
    public boolean descontar(double valor, double multa){
        if(valor>limite+getSaldo()){
            return false;
        } else {
                if(valor > this.getSaldo()){
                    double desconto = -1*(multa/100)*(this.getSaldo()- valor);  
                       this.setSaldo(desconto);
                }
                else{
                    this.sacar(valor);//this.getSaldo() -= valor;
                }
                 return true;
        }
       
    }
    /**
     * 
     */
    @Override
    public void tipoConta(){
        System.out.println("Tipo de conta: conta-especial");
      }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}