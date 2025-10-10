#Vamos importar o solver linear do ORTOOLS
from __future__ import print_function
from random import randint
from ortools.linear_solver import pywraplp

#Vamos declarar o solver considerando o Google's Linear Optimization Programming System
solver = pywraplp.Solver('simple_lp_program', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING) 

#M = int(input())

M = randint(2, 5)
N = randint(2, 5)

Aij = [[randint(1, 5) for j in range(N)] for i in range(M)]
Pi = [randint(1,5) for i in range(M)] 
Sj = [randint(1,5) for j in range(N)]
SP = sum(Pi)
print(SP)
SS = sum(Sj)
print(SS)

if SP >= SS:
    Sj[0] += SP - SS
else:
    Pi[0] += SS - SP

SP = sum(Pi)
SS = sum(Sj)
print(SP)
print(SS)

#3° passo - definição das vairáveis de decisão
xij = [[solver.NumVar(0, min(Pi[i], Sj[j]), f"x{i}{j}") for j in range(N)] for i in range(M)]
    
#4° passo - restrições
for i in range(M):
    ct = solver.Constraint(Pi[i], Pi[i])

    for j in range(N):
        ct.SetCoefficient(xij[i][j], 1)
for j in range(N):
    ct = solver.Constraint(Sj[j], Sj[j])
    for i in range(M):
        ct.SetCoefficient(xij[i][j], 1)

#5° passo - função objetivo
objective = solver.Objective()
for i in range(M):
    for j in range(N):
        objective.SetCoefficient(xij[i][j], Aij[i][j])
objective.SetMinimization()

#6° impressão
resultado = solver.Solve()

if resultado == 0:
    print("Solucao - custo minimo de transporte: ", objective.Value())
    
    for i in range(M):
        print("[", end="")
        for j in range(N):
            print(xij[i][j].solution.value(), end="")
        print("]")
