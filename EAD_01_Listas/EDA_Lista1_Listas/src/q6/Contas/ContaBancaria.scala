package q6.Contas

class ContaBancaria(num: Int) extends Conta(num) {

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
  
}