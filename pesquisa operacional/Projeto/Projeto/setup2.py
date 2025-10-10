from __future__ import print_function
from ortools.linear_solver import pywraplp
import numpy as np
import pandas as pd
import csv

def csv_to_array(array, csv_file):
    with open(csv_file) as csvfile:
        array = pd.read_csv(csv_file, header=None)
        array.to_csv("teste.csv")
    return array

Proporcao = 50

M = list(range(0, 5570, 50))  # municípios que recebem cestas, some 1/50 do conjunto
P = list(range(0, 5570))      # municípios que produzem alimentos
A = list(range(14))           # Alimentos
N = list(range(8))            # Nutrientes

#Parametros

#Quantidade cestas a serem distribuídas no município m ∈ M
Q = {m:100 for m in M}

#Disponibilidade (em toneladas) do alimento a ∈ A no produtor p∈P
# Certifique-se de que o arquivo 'Producao_custo_alimentos.xlsx' está no diretório correto.
data_frame = pd.read_excel("Producao_custo_alimentos.xlsx", sheet_name= "Quantidade produzida (Tonela...")
D = np.delete(data_frame.values[4:-2], 0, axis=1).astype(np.int32)

#Requisito (em g ou mg) do nutriente n ∈ N para cada cesta
nutrientes = [
    ('Proteína (g)', 30),
    ('Fibras (g)', 35),
    ('Gorduras (g)', 66),
    ('Vitamina C (mg)', 100),
    ('Cálcio (mg)', 1000),
    ('Ferro (mg)', 18),
    ('Magnésio (mg)', 420),
    ('Zinco (mg)', 11)
]
R = np.array([n[1] for n in nutrientes])

#Oferta do nutriente n ∈ N ( por kg) do alimento a ∈ A O[a][n]
# Certifique-se de que o arquivo 'matriz_nutricional.csv' está no diretório correto.
data_frame = pd.read_csv("matriz_nutricional.csv", header=None)
O = np.delete(data_frame.values[1:], 0, axis=1).astype(np.float32)*1000
    
#Custo (em reais por tonelada) do alimento a ∈ A no produtor p ∈ P.
data_frame = pd.read_excel("Producao_custo_alimentos.xlsx", sheet_name= "Valor da produção (Mil Reais)")

#Matriz de valores por produção
v_total = np.delete(data_frame.values[4:-2], 0, axis=1).astype(np.float32)

#Custo = valor total / total produzido
C = np.array([[v_total[p][a]/max(1,D[p][a]) for p in range(len(D))] for a in A])


print("#PARAMETROS")

#Variáveis de decisão d_[a][m][p]
solver = pywraplp.Solver('simple_lp_program', pywraplp.Solver.GLOP_LINEAR_PROGRAMMING)
d_amp = {} #quantidade (em toneladas) comprada de alimento a ∈ A pelo unicípio m ∈ M do município p ∈ P.
for a in A:
    for p in P:
        if(int(D[p][a]) > 0): #Se p produz o alimento a
            for m in M:
                d_amp[(a,m,p)] = solver.NumVar(0,int(D[p][a]), '')

print("#VARIÁVEIS")
#Restrições

#Nutrição
for m in M:
    for n in N:
        #Para cada município é necessário comprar alimentos com nutrientes suficientes para todas as cestas
        ct = solver.Constraint(int(R[n]*Q[m]),solver.infinity())
        for p in P:
            for a in A:
                if(D[p][a] > 0): #Se p produz o alimento a
                    if (a,m,p) in d_amp:
                        ct.SetCoefficient(d_amp[(a,m,p)], float(O[a][n]))

#Disponibilidade para compra
for p in P:
    for a in A:
        #Cada produtor só pode vender no máximo o que é produzido
        ct = solver.Constraint(0,int(D[p][a]))
        if(D[p][a] > 0): #Se p produz o alimento a
            
            for m in M:
                if (a,m,p) in d_amp:
                    ct.SetCoefficient(d_amp[(a,m,p)],1)

print("#RESTRIÇÕES")

#Função Objetivo
objective = solver.Objective()
for p in P:
    for a in A:
        if(D[p][a] > 0): #Se p produz o alimento a
            for m in M:
                if (a,m,p) in d_amp:
                    objective.SetCoefficient(d_amp[(a,m,p)], C[a][p])

print("#FUNÇÃO OBJETIVO")
objective.SetMinimization()

#Resolução do problema
print('\nSolving the linear programming problem...')
status = solver.Solve()

# Imprimir a solução.
if status == pywraplp.Solver.OPTIMAL:
    print('Solution:')
    print('Objective value =', solver.Objective().Value())
    for key, value in d_amp.items():
         if value.solution_value() > 0:
             print(f'{key} = {value.solution_value()}')
elif status == pywraplp.Solver.INFEASIBLE:
    print('The problem is infeasible.')
else:
    print('The problem does not have an optimal solution.')
