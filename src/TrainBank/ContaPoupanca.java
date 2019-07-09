/*
  Classe onde possui as funções requeridas no trabalho para
  funcionamento do TrainBank 
*/
package TrainBank;
    public class ContaPoupanca extends Contas{ 
        private double taxa;
        
    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

       public void reajustar(double taxa){
          double saldoAtual = this.getSaldo();
          double reajuste = saldoAtual * taxa;
          this.depositar(reajuste);
       }
        public void reajustar(){
          double saldoAtual = this.getSaldo();
          double reajuste = 0.1 * saldoAtual;
          this.depositar(reajuste);
       }
        
       @Override
     public void tipoConta(){
          System.out.println("Tipo de conta: conta-poupança");   
      }
}
