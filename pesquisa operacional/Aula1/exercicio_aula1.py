#Vamos importar o solver linear do ORTOOLS
from __future__ import print_function
from ortools.linear_solver import pywraplp

#Vamos declarar o solver considerando o Google's Linear Optimization Programming System
solver = pywraplp.Solver('simple_lp_program', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING) 

#Definição dos parâmetros
lb = [0,0]
ub = [1,2]
f = [3,1]
a = [1,1]
b = [2]

#Vamos criar as variáveis numéricas do problema de otimização 
#Formato: solver.NumVar(limite inferior, limite superior, rotulo)
x1 = solver.NumVar(0, 1, 'x1')
x2 = solver.NumVar(0, 2, 'x2')

# ou poderia ser assim: x1 = solver.NumVar(lb[0], ub[0], 'x1')
#                       x2 = solver.NumVar(lb[1], ub[1], 'x2')


#Vamos criar as restrições do problema para as variáveis criadas 
#Restrição linear x1 + x2 <= 2; para isso, precisamos definir o minimo e o máximo valor
# e reescrever a restrição como: x1 + x2 <= 2 
ct = solver.Constraint(-solver.infinity(), 2, 'ct')

#Agora, precisamos colocar os coeficientes multiplicativos de x1 e x2
ct.SetCoefficient(x1, 1);
ct.SetCoefficient(x2, 1);

#Vamos criar as restrições do problema para as variáveis criadas 
#Restrição linear x1 + x2 <= 2; para isso, precisamos definir o minimo e o máximo valor 
#e reescrever a restrição como: x1 + x2 <= 2
#   ct = solver.Constraint(-solver.infinity(), b[0], 'ct')

#Agora, precisamos colocar os coeficientes multiplicativos de x1 e x2
#   ct.SetCoefficient(x1, a[0]);
#   ct.SetCoefficient(x2, a[1]);

#Definiremos a função objetivo 3x1 + x2
#Create the objective function, 3 * x1 + x2
objective = solver.Objective()

#Agora, precisaremos colocar os coeficientes multiplicativos de x1 e x2
objective.SetCoefficient(x1, 3)
objective.SetCoefficient(x2, 1)

#Definiremos o problema como uma maximização
objective.SetMaximization()

#Definiremos a função objetivo 3x1 + x2
#Create the objective function, 3 * x1 + x2
#   objective = solver.Objective()

#Agora, precisaremos colocar os coeficientes multiplicativos de x1 e x2
#   objective.SetCoefficient(x1, f[0])
#   objective.SetCoefficient(x2, f[1])

#Definiremos o problema como uma maximização
#   objective.SetMaximization()

#Executaremos o solver
solver.Solve()

#Imprimiremos a solução 
print('Solução: ')
print('Valor objetivo =', objective.Value())
print('x1 =', x1.solution_value())
print('x2 =', x2.solution_value())