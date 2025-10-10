from __future__ import print_function
from ortools.linear_solver import pywraplp

solver = pywraplp.Solver('exercício 1', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING)

lb = [0,0]
ub = [4,6]
f = [3,5]
a = [
    [0, 2],
    [3, 2]
]
b = [12,18]

x1 = solver.NumVar(0, 4, 'x1')
x2 = solver.NumVar(0, 6, 'x2')

ct1 = solver.Constraint(-solver.infinity(), 12, 'ct1')
ct2 = solver.Constraint(-solver.infinity(), 18, 'ct2')

ct1.SetCoefficient(x1, 0)
ct1.SetCoefficient(x2, 2)

ct2.SetCoefficient(x1, 3)
ct2.SetCoefficient(x2, 2)

objective = solver.Objective()

objective.SetCoefficient(x1, 3)
objective.SetCoefficient(x2, 5)

objective.SetMaximization()

solver.Solve()

print('Solucao: ')
print('Valor objetivo =', objective.Value())
print('x1 =', x1.solution_value())
print('x2 =', x2.solution_value())