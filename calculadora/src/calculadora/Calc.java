package calculadora;

public class Calc {
    private int getPrecedente(String formula) {
	int precedente = 0;
	int posicao = 0;
	while (posicao < formula.length()) {
	    if (formula.charAt(posicao) == '(') {
		posicao++;
		while ((formula.charAt(posicao) != ')') && (posicao < formula.length())) {
		    posicao++;
		}
	    
		if (posicao >= formula.length() -1) {
		    precedente = -1; 
		    break;
		}
	    }
	    else if ((formula.charAt(posicao) == '+') || formula.charAt(posicao) == '-') {
		 precedente = posicao;
		 //break;
	    }
	    else if (((formula.charAt(posicao) == '*') || (formula.charAt(posicao) == '/')) && (precedente == 0)) {
		precedente = posicao;
	    }
	    posicao++;
	}
	return precedente;
    }
    
    public double calcular(String formula) {
	double valor = 0;
	String parte1, parte2;
	int precedente = 0;
	int quantidadeParenteses = 0;
	
	formula = formula.trim();
	
	for (int i = 0; i < formula.length(); i++) {
	    if (formula.charAt(i) == '(') {
		quantidadeParenteses++;
	    }
	    else if (formula.charAt(i) == ')') {
		quantidadeParenteses--;
	    }
	}
	
	if (quantidadeParenteses != 0) {
	    System.out.println("Erro na contagem dos parenteses.");
	}
	else {
	    precedente = getPrecedente(formula);
	    if (precedente <0) {
		formula = formula.substring(1, formula.length() -1);
		valor = calcular(formula);
	    }
	    else if (precedente == 0) {
		valor = Double.parseDouble(formula);
	    }
	    else {
		parte1 = formula.substring(0, precedente).trim();
		parte2 = formula.substring(precedente +1, formula.length()).trim();
		
		if (parte1.isEmpty()) {
		    parte1 = "0";
		}
		
		if (parte2.isEmpty()) {
		    parte2 = "0";
		}
		
		if (formula.charAt(precedente) == '*') {
		    valor = calcular(parte1) * calcular(parte2);
		}
		else if (formula.charAt(precedente) == '/') {
		    valor = calcular(parte1) / calcular(parte2);
		}
		else if (formula.charAt(precedente) == '+') {
		    valor = calcular(parte1) + calcular(parte2);
		}
		else if (formula.charAt(precedente) == '-') {
		    valor = calcular(parte1) - calcular(parte2);
		}
	    }
        }
	
	return valor;
    }
}
