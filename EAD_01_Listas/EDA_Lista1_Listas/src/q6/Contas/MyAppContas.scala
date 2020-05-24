package q6.Contas
import java.util.Scanner

object MyAppContas extends App {
  
  var sc: Scanner = new Scanner(System.in)
  var list = new OrderedLinkedList()
  
  do{
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    
    println("1.Inserir Uma Conta Bancaria")
    println("2.Inserir Uma Conta Poupanca")
    println("3.Inserir Uma Conta Fidelidade")
    println("4.Realizar Credito")
    println("5.Realizar Debito")
    println("6.Consultar Saldo")
    println("7.Consultar Bonus (Somente Conta Fidelidade)")
    println("8.Realizar Tranferencia")
    println("9.Render Juros (Somente Conta Poupanca)")
    println("10.Render Bonus (Somente Conta Fidelidade)")
    println("11.Remover Conta")
    println("12.Imprimir Numero E Saldo De Todas As Contas\n")
    
    println("Escolha uma das opcoes acima: ")
    var op: Int = sc.nextInt()
    
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    
    op match{
      case 1 => println("Digite o número da conta bancaria: ")
                var num: Int = sc.nextInt()
                var conta: Conta = new ContaBancaria(num)
                list.insert(conta)
                println("Conta inserida!")
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
                
      
      case 2 => println("Digite o número da conta poupanca: ")
                var num: Int = sc.nextInt()
                var conta: Conta = new ContaPoupanca(num)
                list.insert(conta)
                println("Conta inserida!")
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 3 => println("Digite o número da conta fidelidade: ")
                var num: Int = sc.nextInt()
                var conta: Conta = new ContaFidelidade(num)
                list.insert(conta)
                println("Conta inserida!")
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 4 => println("Digite o numero da conta em que quer creditar: ")
                var num: Int = sc.nextInt()
                var conta: Conta = list.search(num)
                if(conta != null){
                  println("Digite o credito a ser efetuado: ")
                  var credito: Double = sc.nextDouble()
                  conta.efetuarCredito(credito)
                  println("Creditado com sucesso!")
                }
                else{
                  println("Conta Inexistente")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 5 => println("Digite o numero da conta em que quer debitar: ")
                var num: Int = sc.nextInt()
                var conta: Conta = list.search(num)
                if(conta != null){
                  println("Digite o debito a ser efetuado: ")
                  var debito: Double = sc.nextDouble()
                  if(conta.efetuarDebito(debito) == true){
                    println("Debitado com sucesso!")
                  }
                  else{
                    println("Saldo Insuficiente.")
                  }
                }
                else{
                  println("Conta Inexistente")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 6 => println("Digite o numero da conta para ver o saldo: ")
                var num: Int = sc.nextInt()
                var conta: Conta = list.search(num)
                if(conta != null){
                  println("R$"+conta.saldo)
                }
                else{
                  println("Conta Inexistente")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 7 => println("Digite o número da conta fidelidade: ")
                var num: Int = sc.nextInt()
                var conta = list.search(num)
                if(conta != null && conta.isInstanceOf[ContaFidelidade]){
                  println("R$"+conta.bonus)
                }
                else{
                  println("Conta Fidelidade Invalida")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 8 => println("Digite o número da sua conta: ")
                var numOrigem: Int = sc.nextInt()
                var contaOrigem: Conta = list.search(numOrigem)
                if(contaOrigem != null){
                  println("Digite o número da conta em que deseja tranferir: ")
                  var numDestino: Int = sc.nextInt()
                  var contaDestino: Conta = list.search(numDestino)
                  if(contaDestino != null){
                    println("Digite o valor da tranferencia: ")
                    var valor: Double = sc.nextDouble()
                    if(contaOrigem.efetuarDebito(valor) == true){
                      contaDestino.efetuarCredito(valor)
                      println("Tranferido com sucesso!")
                    }
                    else{
                      println("Saldo Insuficiente.")
                    }
                  }
                  else{
                  println("Conta Inexistente")
                  }
                }
                else{
                  println("Conta Inexistente")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 9 => println("Digite o número da conta poupanca: ")
                var num: Int = sc.nextInt()
                var conta = list.search(num)
                println("Digite o valor da taxa de rendimento em porcentagem (%): ")
                var taxa: Double = sc.nextDouble()
                if(conta != null && conta.isInstanceOf[ContaPoupanca]){
                  conta.renderJuros(taxa)
                  println("Rendimento aplicado!")
                }
                else{
                  println("Conta Poupanca Invalida")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 10 => println("Digite o número da conta fidelidade: ")
                var num: Int = sc.nextInt()
                var conta = list.search(num)
                if(conta != null && conta.isInstanceOf[ContaFidelidade]){
                  conta.renderBonus()
                  println("Rendimento de bonus aplicado!")
                }
                else{
                  println("Conta Fidelidade Invalida")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 11 => println("Digite o número da conta que deseja remover: ")
                var num: Int = sc.nextInt()
                var conta = list.search(num)
                if(conta != null){
                  list.remove(conta)
                  println("Conta removida!")
                }
                else{
                  println("Conta Inexistente")
                }
                var voltar: Int = 1
                do{
                  println("\nDigite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case 12 => list.printListRecursive(list.nodeHead)
                var voltar: Int = 1
                do{
                  println("Digite 0 para voltar ao menu principal: ")
                  voltar = sc.nextInt()
                }while(voltar != 0)
      
      case _  => println("Opcao invalida! ")
    }
      
    
    
  }while(true)
}