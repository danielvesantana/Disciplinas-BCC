from __future__ import print_function
import random
from ortools.linear_solver import pywraplp

solver = pywraplp.Solver('simple_lp_program', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING) 

#xij é a variável de decisão 
#i e j assuma que tem o mesmo limite e vai ser N
N = random.randint(2,6)
S = random.randint(1,N)
T = random.randint(1,N)

aij = [[random.random() for j in range(N)] for i in range(N)] 

#3 determinar as variáveis de decisão
xij = [[solver.NumVar(0, solver.infinity(), f"x{i+1}{j+1}") for j in range(N)] for i in range(N)]
print(xij)

#4 restrições
#if i == S:
i = S
ct = solver.Constraint(1, 1) #fechamento a direita e esquerda = 1
#for j in range(N):
#   ct.SetCoefficient(xij[i][j], 1) #como i = S, é só trocar o S pelo i xij[S][j]
#for j in range(N):
#   ct.SetCoefficient(xij[i][j], -1)

for j in range(N):
    ct.SetCoefficient(xij[i][j], 1)  
    ct.SetCoefficient(xij[i][j], -1)

i = T
ct = solver.Constraint(-1, -1)

for j in range(N):
    ct.SetCoefficient(xij[i][j], 1)  
    ct.SetCoefficient(xij[i][j], -1)

#i != S and i != T
for i in range(N):
    if i != S and i != T:
        ct = solver.Constraint(0,0)
        for j in range(N):
            ct.SetCoefficient(xij[i][j], 1)  
            ct.SetCoefficient(xij[i][j], -1)

#for i in range(N):
    #if i == S:
    #    b = 1
    #elif i == T:
    #    b = -1
    #else:
    #    b = 0
    #for j in range(N):
    #        ct.SetCoefficient(xij[i][j], 1)  
    #        ct.SetCoefficient(xij[i][j], -1)

objective = solver.Objective()
for i in range(N):
    for j in range(N):
        solver.SetCoefficient(xij[i][j], aij[i][j])
objective.SetMinimization()

#6 resolver e imprimir
resultado = solver.Solve()

print("N =", N)
print("S = ", S)
print("T =", T)
print(aij)

if resultado == 0:
    print("Solucao:", objective.Value())
    for i in range(N):
        print("[", end="")
        for j in range(N):
            print(xij[i][j].solution.value(), end="")
        print("]")