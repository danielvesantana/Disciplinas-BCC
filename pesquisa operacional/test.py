from ortools.linear_solver import pywraplp

solver = pywraplp.Solver.CreateSolver("GLOP")
if solver:
    print("OR-Tools instalado com sucesso!")
else:
    print("Erro ao iniciar o solver.")
