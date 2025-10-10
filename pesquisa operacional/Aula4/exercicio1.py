from __future__ import print_function
from random import randint
from ortools.linear_solver import pywraplp

#Vamos declarar o solver considerando o Google's Linear Optimization Programming System
solver = pywraplp.Solver('simple_lp_program', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING) 

M = int(input())
N = int(input())

Aij = [[float(input()) for j in range(N)] for i in range(M)] #matriz de custo

Pi = [float(input()) for i in range(M)] #matriz de máxima produção
Sj = [float(input()) for j in range(N)] #matriz de máximo armazenamento

xij = [[solver.NumVar(0, min(Pi[i], Sj[j]), f"x{i}{j}") for j in range(N)] for i in range(M)] #variáveis de decisão

#restrições
for i in range(M):
    ct = solver.Constraint(Pi[i], Pi[i])

    for j in range(N):
        ct.SetCoefficient(xij[i][j], 1)

for j in range(N):
    ct = solver.Constraint(Sj[j], Sj[j])

    for i in range(M):
        ct.SetCoefficient(xij[i][j], 1)

#função objetivo
objective = solver.Objective()
for i in range(M):
    for j in range(N):
        objective.SetCoefficient(xij[i][j], Aij[i][j])

objective.SetMinimization()

#resolver o problema
result = solver.Solve()

if result == 0:
    print("Valor objetivo =", objective.Value())

    for i in range(M):
        print("[ ", end="")
        for j in range(N):
            print(str("{:.2f}".format(xij[i][j].solution_value())), end="")
            print(" ", end="")
        print("]")