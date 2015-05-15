package calculadora;

public class ConsoleCalc {
    
    public static void main(String[] args) {
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	Calc calc = new Calc();
	double retorno;
	
	System.out.println("Formula: ");  
	if (scanner.hasNextLine()) {  
	   retorno = calc.calcular(scanner.nextLine());  
	   System.out.printf("Valor: " + retorno);  
	}
	scanner.close();
    }
}
