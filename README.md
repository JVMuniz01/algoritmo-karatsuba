📌 Projeto: Multiplicação de Números Grandes com o Algoritmo de Karatsuba (sem BigInteger)
Este projeto implementa o algoritmo de Karatsuba para multiplicar dois números inteiros muito grandes, utilizando apenas operações em String, sem BigInteger.multiply().

A multiplicação é feita de forma recursiva, somando e subtraindo strings, simulando a multiplicação manual de forma eficiente.

🚀 Funcionalidades
Multiplica dois números de qualquer tamanho representados como String

Não utiliza BigInteger.multiply() (feito “na mão”)

Implementa o algoritmo de Karatsuba recursivamente

Manipula soma e subtração com strings para lidar com números grandes

Pode ser testado com números maiores do que o long permite

📷 Exemplo de entrada e saída
text
Copiar
Editar
Digite o primeiro número grande: 3141592653589793
Digite o segundo número grande: 2718281828459045

Resultado da multiplicação (Karatsuba manual):
85397342226735604429632853482585


🖥️ Como executar no seu PC
✅ Pré-requisitos
Java JDK instalado (Java 8 ou superior)

Um editor como NetBeans, IntelliJ ou mesmo terminal/VS Code

🚀 Clone o repositório
```bash
git clone https://github.com/JVMuniz01/algoritmo-karatsuba.git
```
Dentro da pasta do projeto
```bash
cd target/classes
java application/AlgoritmoKaratsuba
```
