from __future__ import print_function
from ortools.linear_solver import pywraplp
import random

solver = pywraplp.Solver('exercício 1', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING)

#2° passo - parametrização do problema
# i cresce até n 
# j cresce até n

N = int(input())

aij = [[int(input()) for j in range(N)] for i in range(N)] #pode fazer sem j e i

#3° passo - determinar variáveis de decisão
# tem n² variáveis de decisão pois o i varia de 0 -> n e o j também

#xij = [[solver.NumVar(lb, ub, "rótulo")]]
xij = [[solver.NumVar(0, 1, f"x{i}{j}") for j in range(N)] for i in range(N)]

#4° determinar as restrições
for i in range(N):
    ct = solver.Constraint(1,1) #restrição é igual a 1

    for j in range(N):
        ct.SetCoefficient(xij[i][j], 1)

for j in range(N):
    ct = solver.Constraint(1,1)

    for i in range(N):
        ct.SetCoefficient(xij[i][j], 1)

#5° passo - função objetivo
objective = solver.Objective()
for i in range(N):
    for j in range(N):
        objective.SetCoefficient(xij[i][j], aij[i][j])

objective.SetMaximization()

#6° resolver o problema
result = solver.Solve()

if result == 0:
    print("Solucao: ")
    print("Valor objetivo = ", objective.Value())
    for i in range(N):
        for j in range(N):
            #if xij[i][j].solution_value() > 0:  #xij[i][j].solution_value() == 1, use isso por questões de aproximação
            print(xij[i][j], "=" ,"{:.1f}".format(xij[i][j].solution_value()))
