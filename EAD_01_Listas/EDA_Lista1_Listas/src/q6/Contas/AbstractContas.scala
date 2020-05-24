package q6.Contas

trait AbstractContas {
  
  
  def efetuarCredito(value: Double): Unit
  
  def efetuarDebito(value: Double): Boolean
  
}