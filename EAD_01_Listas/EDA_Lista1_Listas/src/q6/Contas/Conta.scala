package q6.Contas

class Conta(num: Int) extends AbstractContas {
  
  val numero: Int = num
  var saldo: Double = 0
  var bonus: Double = 0
  
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
  
  def renderBonus(): Unit = {}
  
  def renderJuros(taxa: Double): Unit = {}
  
  
}