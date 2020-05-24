package q6.Contas

class ContaFidelidade(num: Int) extends Conta(num) {
  
  override def efetuarCredito(value: Double): Unit = {
    saldo += value
    bonus += value/100
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
  
  override def renderBonus(): Unit = {
    saldo += bonus
    bonus = 0
  }
  
  
}