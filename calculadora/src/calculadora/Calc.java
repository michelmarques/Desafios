package calculadora;

public class Calc {
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
	    int posicao = 0;
	    while ((valor == 0) && (posicao < formula.length())) {
                if (formula.charAt(posicao) == '(') {
		    posicao++;
		    while ((formula.charAt(posicao) != ')') && (posicao < formula.length())) {
                        posicao++;
		    }
		    
		    if (posicao >= formula.length() -1) {
                        formula = formula.substring(1, formula.length() -1);
                        posicao = 0; // voltar ao início com a formula sem os parênteses inicial e final
		    }
                }
		else if ((formula.charAt(posicao) == '+') || formula.charAt(posicao) == '-') {
		     precedente = posicao;
		     break;
                }
		else if ((formula.charAt(posicao) == '*') || formula.charAt(posicao) == '/') {
                    precedente = posicao;
                }
                posicao++;
            }
	    if (precedente == 0) {
		valor = Double.parseDouble(formula);
	    }
	    else {
		parte1 = formula.substring(0, precedente);
		parte2 = formula.substring(precedente +1, formula.length());
		
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
