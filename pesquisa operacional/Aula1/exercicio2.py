from __future__ import print_function
from ortools.linear_solver import pywraplp

solver = pywraplp.Solver('exercício 1', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING)

N = int(input())

ei = []
for i in range(0, N):
    ei.append(float(input()))

li = []
for i in range(0, N):
    li.append(float(input()))

ti = []
for i in range(0, N):
    ti.append(float(input()))

t = float(input())

xi = []
for i in range(0, N):
    xi.append(solver.NumVar(0, ei[i], f"x{i+1}"))

ct = solver.Constraint(-solver.infinity(), t, 'ct')

for i in range(0, N):
    ct.SetCoefficient(xi[i], ti[i])

objective = solver.Objective()

for i in range(0, N):
    objective.SetCoefficient(xi[i], li[i])

objective.SetMaximization()

solver.Solve()

print('Solucao: ')
print('Valor objetivo =', "{:.1f}".format(objective.Value()))
for i in range(0, N):
    print(f"x{i+1} =", "{:.1f}".format(xi[i].solution_value()))