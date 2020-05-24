package q6.Contas

class ContaPoupanca(num: Int) extends Conta(num){
  
  override def efetuarCredito(value: Double): Unit = {
    saldo += value
  }
  
  override def efetuarDebito(value: Double): Boolean = {
    if(value <= saldo){
      saldo -= value
      true
    }
    else{
      false
    }
  }
  
  override def renderJuros(taxa: Double): Unit = {
    saldo += (saldo*taxa)/100
  }
}